/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpa.prediction;

import static com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker.check;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author omer
 */
public class GpaPrediction
{

    //This variable is used to get gpa correct to two decimal figures//
    
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    //This function is used to suggest the gpa// 
    public static double[] suggest(double expected)
            
    {
        //dummy hardcoded course gpa values along with thier respcetive credit hour in gpa//
        double[] gpa={1,3,4,3.67,2.67,2.67,3.33};
        double[] credit={1,3,3,3,1,3,3};
        
         double min=10;
         int index=0;
         //variable to find min//
        
        double cgpa=3.16;
        //this is a hardcoded gpa which would be get directly from database inn spring//
        int semester=3;
       //this is a hardcoded semester which would be get directly from database inn spring//
        
        
        gpa_calculator a=new  gpa_calculator();
        //a would be used to create and object so that we can calculate the gpa of  each semester individually//
        double [] gpa_to_improve;
        
        while(cgpa<expected)
        {
           
          for(int i=0;i<gpa.length;i++)
          {
              if(gpa[i]<min)
              {
                  min=gpa[i];
                  System.out.print(gpa[i]);
                  index=i;
              }
          }
          gpa[index]=gpa[index]+0.67;
          cgpa=a.calculate(gpa, credit);
          min=10;
    
          
            
        }
        return gpa;
        
        
        
        
        
    }
    
    public static void main(String[] args)
    {
        double[] gpa={1,3,4,3.67,2.67,2.67,3.33};
        double[] credit={1,3,3,3,1,3,3};
        gpa_calculator a=new  gpa_calculator();
        System.out.println(df.format(a.calculate(gpa, credit)));
        
        double[] check=new double[7];
        check=suggest(3.5);
        
         for(int i=0;i<check.length;i++)
          {
              System.out.println(check[i]);
              
          }
       
        
        
        
        
        
        
    }
    
    
    
}
