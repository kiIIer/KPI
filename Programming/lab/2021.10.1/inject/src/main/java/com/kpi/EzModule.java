package com.kpi;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class EzModule extends AbstractModule {

   @Override
   protected void configure(){
    bind(IAnimal.class).annotatedWith(Names.named("vovk")).to(Vovk.class);
    bind(IAnimal.class).annotatedWith(Names.named("lisa")).to(Lisa.class);
    bind(IColor.class).to(Color.class);
   }
}
