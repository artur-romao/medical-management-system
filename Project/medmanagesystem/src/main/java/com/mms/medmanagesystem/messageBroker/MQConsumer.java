package com.mms.medmanagesystem.messageBroker;
import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class MQConsumer {

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
            System.out.println(message);
            message=message.replaceAll("[\\[\\](){}]","");
            message=message.replaceFirst(",",":");
            String [] newmessage=message.split(":",4);
            /*for (int i = 0; i < newmessage.length; i++) {
            
                System.out.println(" [x] Received '" + newmessage[i] + "'"); //posição 2 e 4 do array têm os valores que queremos o 2 tem o nome da queue e o 4 os valores associados
                 
            }*/
            System.out.println("new message is here");
            String opt= newmessage[1].replace("\"","").trim();
            switch (opt) {
                case "hb":
                    eatHB(newmessage[3]);
                    break;
                case "temp":
                    eattemp(newmessage[3]);
                    
                    break;
                case "press":
                    eatpress(newmessage[3]);
                    
                    break;
                case "oxi":
                    eatoxi(newmessage[3]);
                    
                    break;
                default:
                    break;
            }
        };
        channel.basicConsume(hbq, true, deliverCallback, consumerTag -> { });
        channel.basicConsume(tempq, true, deliverCallback, consumerTag -> { });
        channel.basicConsume(oxiq, true, deliverCallback, consumerTag -> { });
        channel.basicConsume(paq, true, deliverCallback, consumerTag -> { });

    }
    //todos estes metodos vao dar return aos valores a ser colocados na db/mandados pro frontend
    public static double[] eatHB(String values){
        //this one is special so we need to create a pair
        double[] hv = new double[540000]; //heart values array
        double[] td = new double[540000]; //time data array
        int hvl= hv.length;
        int tdl= hv.length;
        double [] res =new double[hvl+tdl]; 
        String [] actualvals=values.split("[:,]"); 
        int mid=actualvals.length/2;
        int counter=0;
        for (int i = 0; i < actualvals.length; i++) {
            if (!(actualvals[i].trim().contains("times_data") || actualvals[i].trim().contains("heart_values"))){

                if (i>=mid){
                    hv[counter]=Double.parseDouble(actualvals[i].trim());
                    counter++;
                }else{
                    td[i-1]=Double.parseDouble(actualvals[i].trim());

                }
            } 
        
        }

        System.arraycopy(hv, 0, res,0,hvl);
        System.arraycopy(td, 0, res,hvl,tdl);



        return res;

    }
    public static float eatoxi(String values){


        return Float.parseFloat(values.trim());

    }
    public static float[] eatpress(String values){
        
        String [] actualvals=values.split("[:,]"); 
        
        return new float[] {Float.parseFloat(actualvals[1].trim()),Float.parseFloat(actualvals[3].trim())};    }

    public static float eattemp(String values){

        return Float.parseFloat(values.trim());

    }




}


