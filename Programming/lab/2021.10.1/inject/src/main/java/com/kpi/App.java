package com.kpi;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new HiModule());
        HelloWorlder1 instance = injector.getInstance(HelloWorlder1.class);
        instance.sayHi();
    }
}
