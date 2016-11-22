package main.java.greetings.chain.impl;

import java.util.Calendar;
import java.util.Date;

import main.java.greetings.chain.IGreetingsHandler;
import main.java.greetings.locale.impl.MessageTypeEnum;

public class NightHandler extends AbstractGreetingsHandler implements IGreetingsHandler {

   public NightHandler(IGreetingsHandler nextHandler) {
      super(nextHandler);
   }

   @Override
   protected boolean checkCondition(Date currentDate) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentDate);
      int hours = calendar.get(Calendar.HOUR_OF_DAY);
      
      if (hours < 6 || hours >= 23) {
         return true;
      }
      
      return false;
   }

   @Override
   protected MessageTypeEnum getGreetingsName() {
      return MessageTypeEnum.NIGHT_GREETINGS;
   }

}
