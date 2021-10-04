package com.kpi;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class HiModule extends AbstractModule {
    @Override
    protected void configure(){
        // bind(HelloWorlder1.class).annotatedWith(Names.named("Hi1")).to(HelloWorlder1.class);
        // // .to(HelloWorlder1.class);
        // bind(HelloWorlder2.class);
        // // .to(HelloWorlder2.class);
        // bind(IHelloWorlder3.class).to(HelloWorlder3.class);
        bind(IHi.class).annotatedWith(Names.named("En")).to(HiEn.class);
        bind(IHi.class).annotatedWith(Names.named("Ja")).to(HiJa.class);
    }
}
