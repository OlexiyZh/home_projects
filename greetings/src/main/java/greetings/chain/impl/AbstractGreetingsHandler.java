package main.java.greetings.chain.impl;

import java.util.Date;
import java.util.ResourceBundle;

import main.java.greetings.chain.IGreetingsHandler;

public abstract class AbstractGreetingsHandler implements IGreetingsHandler
{
   private final IGreetingsHandler nextHandler;
   
   public AbstractGreetingsHandler(IGreetingsHandler nextHandler) {
      this.nextHandler = nextHandler;
   }
   
   protected IGreetingsHandler getNextHandler() {
      return nextHandler;
   }
   
   public String handleRequest(Date currentDate, ResourceBundle messages)
   {
      if (checkCondition(currentDate)) {
         return messages.getString(getGreetingsName());
      }
      
      return getNextHandler().handleRequest(currentDate, messages);
   }
   
   abstract protected boolean checkCondition(Date currentDate);
   abstract protected String getGreetingsName();
}
