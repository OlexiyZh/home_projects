package main.java.greetings.chain.impl;

import java.util.Date;
import java.util.ResourceBundle;

import main.java.greetings.chain.IGreetingsHandler;

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
   public String handleRequest(Date currentDate, ResourceBundle messages)
   {
      throw new RuntimeException("You reach this handler in runtime it means your conditions for handlers are incorrect. Please check it");
   }

   @Override
   protected String getGreetingsName()
   {
      return null;
   }

   @Override
   protected boolean checkCondition(Date currentDate)
   {
      return true;
   }

}
