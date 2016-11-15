package main.java.greetings.chain.impl;

import java.util.Calendar;
import java.util.Date;

import main.java.greetings.chain.IGreetingsHandler;

public class DayHandler extends AbstractGreetingsHandler implements IGreetingsHandler
{
   private static final String GREETINGS = "day";

   public DayHandler(IGreetingsHandler nextHandler)
   {
      super(nextHandler);
   }

   @Override
   protected boolean checkCondition(Date currentDate)
   {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentDate);
      int hours = calendar.get(Calendar.HOUR_OF_DAY);
      
      if (9 <= hours && hours < 19) {
         return true;
      }
      
      return false;
   }

   @Override
   protected String getGreetingsName()
   {
      return GREETINGS;
   }

}
