package com.kpi;

import java.io.IOException;

import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.opencsv.exceptions.CsvException;

public class App {
  public static void main(String[] args) {
    if(args.length != 2){
      System.out.println("I need 2 arguments to work. Which formula and name of file!");
      return;
    }
    String actionName = args[0];
    String filename = args[1];
    
    Injector injector = Guice.createInjector(new MatrixModule());

    IMatrixReader reader = injector.getInstance(MatrixReader.class);

    double[][] matrix;
    try {
      matrix = reader.read(filename);
    } catch (NumberFormatException e) {
      System.out.println("Could not to parse number: " + e.getMessage());
      return;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return;
    } catch (CsvException e) {
      System.out.println(e.getMessage());
      return;
    }

    Binding<IMatrixProcessor> workerBinding = injector.getExistingBinding(Key.get(IMatrixProcessor.class, Names.named(actionName)));
    if(workerBinding == null){
      System.out.println("Unsupported action");
      return;
    }
    IMatrixProcessor processor = workerBinding.getProvider().get();

    processor.process(matrix);
  }
}
