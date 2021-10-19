package com.kpi;

import com.google.inject.Inject;

public class HelloWorlder2 {
    private final IHelloWorlder3 hi3;

    @Inject
    public HelloWorlder2(IHelloWorlder3 hi3){
        this.hi3 = hi3;
    }

    public void sayHi(){
        this.hi3.sayHi();
    }
}
