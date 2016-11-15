package main.java.greetings;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.greetings.message.IMessageResource;


public class GreetingsRunner
{

   public static void main(String[] args)
   {
      ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:main/java/greetings/ComponentConfiguration-Greetings.xml" });
      IMessageResource messageResource = context.getBean("GreetingsMessageResource", IMessageResource.class);
      
      String message = messageResource.getGreetingsMessage(new Date());
      System.out.println(message);
   }

}
