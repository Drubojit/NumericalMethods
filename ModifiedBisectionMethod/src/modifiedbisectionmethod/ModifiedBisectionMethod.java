
package modifiedbisectionmethod;

import java.util.Scanner;

public class ModifiedBisectionMethod {
    public static double horners(double equation[],double value)
    {
        double result=equation[0];
        for(int i=1;i<equation.length;i++)
        {
            result=result*value+equation[i];
        }
        return result;
    }
    public static void modifiedbisection(double equation[],double low,double high)
    {
        double dx=0.00001;
        double e=0.000000001;
        double x0,x1,x2;
        double f0,f1,f2;
        x2=low;
        while(x2<high)
        {
            low=x2;
            x1=low;
            x2=x1+dx;
            f1=horners(equation,x1);
            f2=horners(equation,x2);
            while(Math.abs((x2-x1)/x2)>e)
            {
                if((f1*f2)>0)
                {
                    break;
                }
                x0=(x1+x2)/2;
                f0=horners(equation,x0);
                if(f0==0)
                {
                }
                if((f0*f1)<0)
                {
                    x2=x0;
                    f2=f0;
                }
                else{
                    x1=x0;
                    f1=f0;
                }
            }
            if(Math.abs((x2-x1)/x2)<e)
            {
                System.out.println("Root: "+(x1+x2)/2);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter degree: ");
        int degree=input.nextInt();
        double equation[]=new double[degree+1];
         Scanner input1=new Scanner(System.in);
        for(int i=0;i<equation.length;i++)
        {
            double data=input1.nextDouble();
            equation[i]=data;
        }
        System.out.println("Enter lower limit: ");
         double low=input1.nextDouble();
         System.out.println("Enter lower limit: ");
         double high=input1.nextDouble();
         modifiedbisection(equation,low,high);
    }
}