package in.ineuron;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory= new ClassPathXmlApplicationContext("/applicationContext.xml");
        Scanner sc=new Scanner(System.in);
        
         IStudentService service=factory.getBean(IStudentService.class);
         while(true) {
        	 System.out.println("1. To add the data into table");
        	 System.out.println("2. To Update the data into table");
        	 System.out.println("3. To Delete the data ");
        	 System.out.println("4. To get the all Student data");
        	 int a=sc.nextInt();
        	 switch(a){
        		 case 1:
        			 System.out.println("Enter Your name:");
        			 String name= sc.next();
        			 System.out.println("Enter your address");
        			 String address=sc.next();
        			 System.out.println("Enter your age");
        			 int age=sc.nextInt();
        			 StudentDTO stdto=new StudentDTO();
        			 stdto.setSname(name);
        			 stdto.setSaddress(address);
        			 stdto.setSage(age);
        			 
        			 int i=service.addData(stdto);
        			 if(i!=0)
        				 System.out.println("Data is saved successfully");
        			 
        			 else
        				 System.out.println("Data is not saved successfully");
        			 
        			 //((ConfigurableApplicationContext) factory).close();
        			 break;
        			 
        		 case 2:
        			 System.out.println("Enter the id you want to update");
        			 int n=sc.nextInt();
        			 StudentDTO dto1=service.getData(n);
        			 System.out.println("id is "+dto1.getId());
        			 		 System.out.println(" name is "+dto1.getSname()+"  Enter the Name ");
        			 		 String name1=sc.nextLine();
        			 		 System.out.println();
        			 		 System.out.println("address is "+dto1.getSaddress()+" Enter the address");
        			 		 String address1=sc.nextLine();
        			 		 System.out.println();
        			 		 System.out.println("age is "+dto1.getSage()+" Enter the AGE ");
        			 		 int age1=sc.nextInt();
        			 		StudentDTO stdto1=new StudentDTO();
               			    stdto1.setSname(name1);
               			    stdto1.setSaddress(address1);
               			    stdto1.setSage(age1);
               			    if(service.updateData(stdto1).equals("success"))
               			    System.out.println("Record updated Successfully");
               			    else
               			    	System.out.println("Record not Updated Successfully");
        			 		 
        			 
        			 
        			 
        			 break;
        		 case 3:
        			 System.out.println("Enter the ID of the record");
        			 int j =sc.nextInt();
        			try { if(service.deleteData(j).equals("success"))
        				 System.out.println("REcord delete successfully");
        			 else
        				 System.out.println("Record not deleted successfully ");}
        			catch(Exception e) {
        				System.out.println(e);
        			}
        			 break;
        		 case 4:
        			 System.out.println("Enter the record id to get the data");
        			 int k=sc.nextInt();
        			 StudentDTO dto=service.getData(k);
        			 System.out.println("id is "+dto.getId()+" name is "+dto.getSname()+"address is "+dto.getSaddress()+"age is "+dto.getSage());
        			 

        				 
        			 
        			 
        	 }
        		 
        			 
        	 
        		 
         }
        	 
         
        }
}
