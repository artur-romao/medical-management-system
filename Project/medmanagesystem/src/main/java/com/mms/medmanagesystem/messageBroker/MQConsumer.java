package com.mms.medmanagesystem.messageBroker;
import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import  java.lang.Object ;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.mms.medmanagesystem.exception.ResourceNotFoundException;
import com.mms.medmanagesystem.model.Internamento;
import com.mms.medmanagesystem.service.InternamentoService;




public class MQConsumer {

    
    private static InternamentoService service;
	@Autowired
	private MQConsumer(InternamentoService sv) {
		MQConsumer.service = sv;
	}
    private final static String hbq = "hb";
    private final static String oxiq = "oxi";
    private final static String paq = "pressao_arterial";
    private final static String tempq = "temp";


    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
     

        channel.queueDeclare(hbq, false, false, false, null);
        channel.queueDeclare(oxiq, false, false, false, null);
        channel.queueDeclare(paq, false, false, false, null);
        channel.queueDeclare(tempq, false, false, false, null);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            JSONObject msg =new JSONObject(message);
            System.out.println(message);
            System.out.println(msg);
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
                    Internamento inter= service.getInternamentoById(id);
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

        //service.getInternamentoById(id_internamento)
        channel.basicConsume(hbq, true, deliverCallback, consumerTag -> { });
        channel.basicConsume(tempq, true, deliverCallback, consumerTag -> { });
        channel.basicConsume(oxiq, true, deliverCallback, consumerTag -> { });
        channel.basicConsume(paq, true, deliverCallback, consumerTag -> { });

    }
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
    
    public static float eatoxi(Object object){


        return Float.parseFloat(object.toString());

    }
    public static Float[] eatpress(Object object){
        //o obejto vem like [sis,dia]
        String[] actualvals =object.toString().replaceAll("[\\[\\]]","").split(",");

        return new Float[] {Float.parseFloat(actualvals[0].trim()),Float.parseFloat(actualvals[1].trim())};    }

    public static Float eattemp(Object object){

        return Float.parseFloat(object.toString());

    }




}

