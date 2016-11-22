package main.java.greetings.chain.impl;

import java.util.Date;

import main.java.greetings.chain.IGreetingsHandler;
import main.java.greetings.locale.IMessageResource;
import main.java.greetings.locale.impl.MessageTypeEnum;

public abstract class AbstractGreetingsHandler implements IGreetingsHandler {

   private final IGreetingsHandler nextHandler;
   
   public AbstractGreetingsHandler(IGreetingsHandler nextHandler) {
      this.nextHandler = nextHandler;
   }
   
   protected IGreetingsHandler getNextHandler() {
      return nextHandler;
   }
   
   public String handleRequest(Date currentDate, IMessageResource messageResource) {
      if (checkCondition(currentDate)) {
         return messageResource.getMessage(getGreetingsName());
      }
      
      return getNextHandler().handleRequest(currentDate, messageResource);
   }
   
   abstract protected boolean checkCondition(Date currentDate);
   abstract protected MessageTypeEnum getGreetingsName();
}
