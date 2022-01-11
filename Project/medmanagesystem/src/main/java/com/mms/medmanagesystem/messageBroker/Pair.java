package com.mms.medmanagesystem.messageBroker;

public class Pair {
    private double [] timedata;
    private double [] heartratedata;
    
    public Pair(double[] timedata, double[] heartratedata){

        this.timedata=timedata;
        this.heartratedata=heartratedata;
    }
    public double [] gettimedata(){return timedata;}
    public double [] getheartratedata(){return heartratedata;}
}
