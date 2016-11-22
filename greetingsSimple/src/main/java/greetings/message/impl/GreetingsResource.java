package main.java.greetings.message.impl;

import java.util.Date;

import main.java.greetings.chain.IGreetingsHandler;
import main.java.greetings.locale.IMessageResource;
import main.java.greetings.message.IGreetingsResource;

public class GreetingsResource implements IGreetingsResource
{
   private IGreetingsHandler greetingsHandler;
   private IMessageResource messageResource;
   
   public GreetingsResource(IGreetingsHandler greetingsHandler, IMessageResource messageResource) {
      this.greetingsHandler = greetingsHandler;
      this.messageResource = messageResource;
   }

   public String getGreetingsMessage(Date currentDate) {
      if (currentDate == null) {
         currentDate = new Date();
      }
      return greetingsHandler.handleRequest(currentDate, messageResource);
   }

}
