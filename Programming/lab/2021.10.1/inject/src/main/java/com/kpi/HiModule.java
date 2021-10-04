package com.kpi;

import com.google.inject.AbstractModule;

public class HiModule extends AbstractModule {
    @Override
    protected void configure(){
        bind(HelloWorlder1.class);
        // .to(HelloWorlder1.class);
        bind(HelloWorlder2.class);
        // .to(HelloWorlder2.class);
        bind(IHelloWorlder3.class).to(HelloWorlder3.class);
    }
}
