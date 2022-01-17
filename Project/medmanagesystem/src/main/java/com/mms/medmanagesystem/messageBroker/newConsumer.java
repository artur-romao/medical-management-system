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

    @RabbitListener(queues = {Config.hbq, Config.tempq, Config.tempq, Config.oxiq})
    public void listen(String input) {
        System.out.println("   Receive input: " + input);

    
        JSONObject msg =new JSONObject(input);
        // System.out.println(message);
        int id=Integer.parseInt(msg.get("id").toString());
        
        switch (msg.get("name").toString()) {
            case "hb":
                Double[] sendhb= eatHB(msg.get("values"));
                try {
                    Internamento inter= service.getInternamentoById(id);
                    inter.setPulso(sendhb);
                    service.updateInternamento(id, inter);
                } catch (ResourceNotFoundException e) {
                    System.err.println("erro");
                }
            break;
            
            case "temp":
                float sendtemp=eattemp(msg.get("values"));
                try {
                    System.out.println(msg);
                    Internamento inter= service.getInternamentoById(id);    //ERRO AQUI NULL POINTER
                    inter.setTemperatura(sendtemp);
                    service.updateInternamento(id, inter);
                } catch (ResourceNotFoundException e) {
                    System.err.println("erro");
                }
                break;

            case "press":
                Float[] sendp= eatpress(msg.get("values"));
                try {
                    Internamento inter= service.getInternamentoById(id);
                    inter.setPressaoarterial(sendp);
                    service.updateInternamento(id, inter);
                } catch (ResourceNotFoundException e) {
                    System.err.println("erro");
                }
            case "oxi":
                float sendoxi =eatoxi(msg.get("values"));
                try {
                    Internamento inter= service.getInternamentoById(id);
                    inter.setOxigenio(sendoxi);
                    service.updateInternamento(id, inter);
            } catch (ResourceNotFoundException e) {
                System.err.println("erro");
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
    
    public static Float eatoxi(Object object){
        
        
        return Float.parseFloat(object.toString());
        
    }
    public static Float[] eatpress(Object object){
        //o obejto vem like [sis,dia]
        String[] actualvals =object.toString().replaceAll("[\\[\\]]","").split(",");
        System.out.println(actualvals[0] +"as"+ actualvals[1]);
        return new Float[] {Float.parseFloat(actualvals[0].trim()),Float.parseFloat(actualvals[1].trim())};    
    }
        
    public static Float eattemp(Object object){
            
            return Float.parseFloat(object.toString());
            
        }
        
    }
    
