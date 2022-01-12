package com.mms.medmanagesystem.model;

import javax.persistence.Entity;

public class PairModel {
    private double [] timedata;
    private double [] heartratedata;
    
    public PairModel(double[] timedata, double[] heartratedata){

        this.timedata=timedata;
        this.heartratedata=heartratedata;
    }
    public double [] gettimedata(){return timedata;}
    public double [] getheartratedata(){return heartratedata;}
}
