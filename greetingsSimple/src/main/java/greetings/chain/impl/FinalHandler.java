package main.java.greetings.chain.impl;

import java.util.Date;

import main.java.greetings.chain.IGreetingsHandler;
import main.java.greetings.locale.IMessageResource;
import main.java.greetings.locale.impl.MessageTypeEnum;

/*
 * If you reach this handler in runtime it means your conditions for handlers are incorrect. Please check it 
 */
public class FinalHandler extends AbstractGreetingsHandler implements IGreetingsHandler
{
   public FinalHandler()
   {
      super(null);
   }

   @Override
   public String handleRequest(Date currentDate, IMessageResource messageResource)
   {
      throw new RuntimeException("You reach this handler in runtime it means your conditions for handlers are incorrect. Please check it");
   }

   @Override
   protected MessageTypeEnum getGreetingsName()
   {
      return null;
   }

   @Override
   protected boolean checkCondition(Date currentDate)
   {
      return true;
   }

}
