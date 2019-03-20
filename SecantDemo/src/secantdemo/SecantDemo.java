
package secantdemo;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SecantDemo {
public static DecimalFormat df2 = new DecimalFormat(".##");
static double honor(double arr[],int n,double x)
{
    double result=arr[0];
    for(int i=1;i<n;i++)
    {
        result=result*x+arr[i];
    }
    return result;
}
static final double epsilon=0.001;
public void secantmethod(double x1,double x2,int n,double arr[])
{
   double x0,c,xm;
   if(honor(arr,n,x1)/honor(arr,n,x2)<0)
   {
       do{
           x0=((x1*honor(arr,n,x2))-(x2*(honor(arr,n,x1))))/((honor(arr,n,x2))-(honor(arr,n,x1)));
           c=honor(arr,n,x1)*honor(arr,n,x0);
           x1=x2;
           x2=x0;
           if(c==0)
           {
               break;
           }
           xm=((x1*honor(arr,n,x2))-(x2*(honor(arr,n,x1))))/((honor(arr,n,x2))-(honor(arr,n,x1)));
           
       }while(Math.abs(xm - x0) >= epsilon);  
       System.out.println("The root is :"+df2.format(x0));
   }
   else{
       System.out.println("Cannot find root in the interval");
   }
}
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       int number;
        System.out.println("Enter the polynomial number of the equation: ");
        number=input.nextInt();
        double arr[]=new double[number+1];
        for(int i=0;i<number+1;i++)
        {
            System.out.println("Enter coeffient: ");
            arr[i]=input.nextDouble();
        }
        int n=arr.length;
        System.out.println("Enter the two guess value: ");
        double x1=input.nextInt();
        double x2=input.nextInt();
        SecantDemo obj=new SecantDemo();
        obj.secantmethod(x1, x2, n, arr);
    }
    
}
