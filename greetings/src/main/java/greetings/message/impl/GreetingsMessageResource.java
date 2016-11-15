package main.java.greetings.message.impl;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import main.java.greetings.chain.IGreetingsHandler;
import main.java.greetings.message.IMessageResource;

public class GreetingsMessageResource implements IMessageResource
{
   private IGreetingsHandler greetingsHandler;
   private ResourceBundle messages;
   
   public GreetingsMessageResource(IGreetingsHandler greetingsHandler) {
      this.greetingsHandler = greetingsHandler;
      this.messages = ResourceBundle.getBundle("resources.Messages", Locale.getDefault());
   }

   public String getGreetingsMessage(Date currentDate)
   {
      return greetingsHandler.handleRequest(currentDate, messages);
   }

}
