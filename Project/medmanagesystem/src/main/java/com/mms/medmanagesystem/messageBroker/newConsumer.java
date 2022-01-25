package com.mms.medmanagesystem.messageBroker;

import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.service.InternamentoService;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


import org.springframework.beans.factory.annotation.Autowired;

public class newConsumer {

    @Autowired
    private InternamentoService service;

    @RabbitListener(queues = {Config.hbq, Config.tempq, Config.pressq, Config.oxiq})
    public void listen(String input) {
        // System.out.println("   Receive input: " + input);

    
        JSONObject msg =new JSONObject(input);
        // System.out.println(message);
        int id=Integer.parseInt(msg.get("id").toString());
        switch (msg.get("name").toString()) {
            case "hb":
            //first half of the array is the hb values  peaks usually around 2
            Double[] sendhb= eatHB(msg.get("values"));
            try {
                Internamento inter= service.getInternamentoById(id);
                
                inter.setPulso(sendhb);
                service.updateInternamento(id, inter);
                
                    //not sure how to update this one
                    //maybe localizar o intervalo q mostra um e apenas um maximo de forma garantida 
                    // trabalhar com o maximo detro desse intervalo, saber um maximo normal e usalo como benchmark?
                    //we can do this because sendhb is an array composed by two arrays of the same lenght so its always an even number
                    int halfway = sendhb.length/2;
                    //convert into a half sized array
                    Double[] checker= new Double[halfway];
                    for (int i = 0; i < checker.length; i++) {
                        checker[i]= sendhb[i]; 
                    }
                    //make it a non primitive for easier handle
                    double[] d = ArrayUtils.toPrimitive(checker);
                    for ( int i = 0 ; i < halfway; i++) {
                        d[i]=checker[i];

                    }
                    //updateStates(int idinternamento, String sensorname, int value )
                    //get max of the hearbeat values
                    double maximum= -100;
                    for (int i = 0; i < d.length; i++) {
                        if (d[i]> maximum){
                            maximum=d[i];
                        }
                    }
                    //create conditions
                    if(maximum >1.7){ //stable
                        service.updateStates(id,"hb", 0);
                    }else if(maximum<0.5){//critico
                        service.updateStates(id,"hb", 1);
                    }else{ //grave
                        service.updateStates(id,"hb", 2);
                    
                    }


                } catch (ResourceNotFoundException e) {
                    //System.err.println("erro");
                }
            break;
            
            case "temp":
                Float sendtemp=eattemp(msg.get("values"));
                try {
                    Internamento inter= service.getInternamentoById(id);    //ERRO AQUI NULL POINTER
                    inter.setTemperatura(sendtemp);
                    service.updateInternamento(id, inter);
                    //update paciente statues due to critical conditions:D
                    if(sendtemp<=37.5 || sendtemp>= 36.5){ //stable
                        service.updateStates(id,"temp", 0);
                    }else if(sendtemp<=38.3 || sendtemp>= 35.5){ //grave
                        
                        service.updateStates(id,"temp", 1);
                    }else{ //coma
                        service.updateStates(id,"temp", 2);
                    }


                } catch (ResourceNotFoundException e) {
                    //System.err.println("erro");
                }
                

                break;

            case "press":
                Float[] sendp= eatpress(msg.get("values"));
                try {
                    
                    Internamento inter= service.getInternamentoById(id);
                    inter.setPressaoarterial(sendp);
                    service.updateInternamento(id, inter);
                    //update paciente statues due to critical conditions:D
                    // distolica is pos 1 sistolica pos 0
                    if(sendp[1]>105 || sendp[0]>160   ){ //coma

                        service.updateStates(id,"press", 2);
                    }else if((sendp[0]<=140 && sendp[0]>=105) || (sendp[0]<=100 && sendp[1]>60)){ //stable
                        service.updateStates(id,"press", 0);

                    }else{ //grave
                        service.updateStates(id,"press", 1);
                    }


                } catch (ResourceNotFoundException e) {
                    //System.err.println("erro");
                }
                break;
            case "oxi":
                Float sendoxi =eatoxi(msg.get("values"));
                try {
                    Internamento inter= service.getInternamentoById(id);
                    inter.setOxigenio(sendoxi);
                    service.updateInternamento(id, inter);
                    //update paciente statues due to critical conditions:D

                    if (sendoxi>94){ //stable
                        service.updateStates(id,"oxi", 0);
                    }else if(sendoxi<90 ){ //coma

                        service.updateStates(id,"oxi", 2);
                    }else{ //grave
                        service.updateStates(id,"oxi", 1);
                    }
            } catch (ResourceNotFoundException e) {
                //System.err.println("erro");
            }
            break;
            default:
            break;
        }
        
    };
    
  

    //todos estes metodos vao dar return aos valores a ser colocados na db/mandados pro frontend
    public static Double[] eatHB(Object object){
        //this one is special so we need to create a pair
        
        double[] hv = new double[540000]; //heart values array
        double[] td = new double[540000]; //time data array
        int hvl= hv.length;
        int tdl= hv.length;
        double[] res =new double[hvl+tdl]; 
        String[] actualvals =object.toString().replaceAll("[\\[\\]]","").split(",");
        
        int mid=actualvals.length/2-1;
        int counter=0;
        for (int i = 0; i < actualvals.length; i++) {
            
            if (i>=mid){
                hv[counter]=Double.parseDouble(actualvals[i].trim());
                counter++;
            }else{
                td[i]=Double.parseDouble(actualvals[i].trim());
                
            }
            
        }
        
        System.arraycopy(hv, 0, res,0,hvl);
        System.arraycopy(td, 0, res,hvl,tdl);
        
        
        return ArrayUtils.toObject(res);
        
    } 

    public static Float[] eatpress(Object object){
        //o obejto vem like [sis,dia]
        String[] actualvals =object.toString().replaceAll("[\\[\\]]","").split(",");
        // System.out.println(Float.parseFloat(actualvals[0].trim()) +"as"+ actualvals[1]);
        return new Float[] {Float.parseFloat(actualvals[0].trim()),Float.parseFloat(actualvals[1].trim())};    
    }
        
    public static Float eattemp(Object object){
            
            return Float.parseFloat(object.toString());
            
        }
    public static Float eatoxi(Object object){
            
            return Float.parseFloat(object.toString());
            
        }
        
        
    }