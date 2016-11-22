package main.java.greetings.chain.impl;

import java.util.Calendar;
import java.util.Date;

import main.java.greetings.chain.IGreetingsHandler;
import main.java.greetings.locale.impl.MessageTypeEnum;

public class MorningHandler extends AbstractGreetingsHandler implements IGreetingsHandler {

   public MorningHandler(IGreetingsHandler nextHandler) {
      super(nextHandler);
   }

   protected boolean checkCondition(Date currentDate) {

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentDate);
      int hours = calendar.get(Calendar.HOUR_OF_DAY);
      
      if (6 <= hours && hours < 9) {
         return true;
      }
      
      return false;
   }

   @Override
   protected MessageTypeEnum getGreetingsName() {
      return MessageTypeEnum.MORNING_GREETINGS;
   }

}
