package com.kpi;

import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new HiModule());
        // HelloWorlder1 instance = injector.getInstance(HelloWorler1.class);
        // instance.sayHi();
        String param = "En";

        Binding<IHi> binding = injector.getExistingBinding(Key.get(IHi.class, Names.named(param)));

        if(binding == null){
            System.out.println("Wait. That's illegal.");
            return;
        }

        IHi instance = binding.getProvider().get();

        instance.sayHi();
    }
}
