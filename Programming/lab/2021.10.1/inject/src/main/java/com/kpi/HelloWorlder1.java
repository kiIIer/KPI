package com.kpi;

import com.google.inject.Inject;

public class HelloWorlder1 {
    private final HelloWorlder2 hi2;
    
    @Inject
    public HelloWorlder1(HelloWorlder2 hi2){
        this.hi2 = hi2;
    }

    public void sayHi(){
        hi2.sayHi();
    } 
}
