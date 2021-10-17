package com.kpi;

import com.google.inject.Inject;

public class HelloWorlder3 implements IHelloWorlder3 {

    @Inject
    public HelloWorlder3(){};

    public void sayHi(){
        System.out.println("Hello");
    }
}
