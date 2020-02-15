/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpa.prediction;

/**
 *
 * @author omer
 */
public class gpa_calculator 
{
    
    public double calculate(double gpa[],double credit[])
    {
        double result=0;
        double denominator=0;
        double numerator=0;
        for(int i=0; i<gpa.length;i++)
        {
            denominator=(gpa[i]*credit[i])+denominator;
            numerator=credit[i]+numerator;
              
        }
        result=denominator/numerator;
        return result;
    }
    
    
}
