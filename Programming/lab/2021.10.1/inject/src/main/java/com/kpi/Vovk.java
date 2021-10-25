package com.kpi;

import com.google.inject.Inject;

public class Vovk implements IAnimal{


    private IColor color;

    @Inject
    public Vovk(IColor color){
        this.color = color;
    }

    public void Say() {
        System.out.println("Hm.... Nu... Huinya. Peresdacha" + color.a());
    }
    
}
