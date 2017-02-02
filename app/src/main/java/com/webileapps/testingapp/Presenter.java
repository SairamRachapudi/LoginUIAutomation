package com.webileapps.testingapp;

/**
 * Created by sairam on 31/1/17.
 */

public class Presenter {

    Service service;
    public Presenter(Service service) {
        this.service = service;
    }

    public int doSum(int a,int b){
        try {
            return service.doSum(a, b);
        }catch (RuntimeException e){
            return -1;
        }
    }

}
