package main.java.greetings;

import java.util.Date;
import java.util.Locale;

import main.java.greetings.chain.IGreetingsHandler;
import main.java.greetings.chain.impl.DayHandler;
import main.java.greetings.chain.impl.EveningHandler;
import main.java.greetings.chain.impl.FinalHandler;
import main.java.greetings.chain.impl.MorningHandler;
import main.java.greetings.chain.impl.NightHandler;
import main.java.greetings.locale.IMessageResource;
import main.java.greetings.locale.factory.IMessageResourceFactory;
import main.java.greetings.locale.factory.impl.MessageResourceFactory;
import main.java.greetings.message.IGreetingsResource;
import main.java.greetings.message.impl.GreetingsResource;


public class GreetingsRunner {

   public static void main(String[] args) {

      IGreetingsResource greetingsResource = createGreetingsResource();
      
      String message = greetingsResource.getGreetingsMessage(new Date());
      System.out.println(message);
   }

   private static IGreetingsResource createGreetingsResource() {
      
      IMessageResourceFactory messageResourceFactory = new MessageResourceFactory();
      IMessageResource messageResource = messageResourceFactory.getMessageResource(Locale.getDefault());

      IGreetingsHandler greetingsHandler = new MorningHandler(new DayHandler(new EveningHandler(new NightHandler(new FinalHandler()))));

      return new GreetingsResource(greetingsHandler, messageResource);
   }

}
