package com.kpi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class EzApp {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new EzModule());

        String name = "vovk";

        IAnimal animal = injector.getBinding(Key.get(IAnimal.class, Names.named(name))).getProvider().get();

        animal.Say();
    }
}
