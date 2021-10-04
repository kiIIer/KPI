package com.kpi;

public class App 
{
    public static void main( String[] args )
    {
      double[][] a = new double[][] {{1,2,3},{-50,2,3},{50,-2,-3}};
      MinInMax b = new MinInMax();
      System.out.println(b.getMin(a));
    }
}
