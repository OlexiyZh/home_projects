package test.java;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import main.java.greetings.locale.impl.MessageTypeEnum;
import main.java.greetings.message.IGreetingsResource;
import main.java.greetings.message.impl.GreetingsResource;

import org.junit.BeforeClass;
import org.junit.Test;

public class GreetingsResourceTest
{   
   private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
   
   private static IGreetingsResource greetingsResource;
   private static IMessageResource messageResource;
   
   @BeforeClass
   public static void setUpClass() {
      IMessageResourceFactory messageResourceFactory = new MessageResourceFactory();
      messageResource = messageResourceFactory.getMessageResource(Locale.getDefault());
      
      IGreetingsHandler greetingsHandler = new MorningHandler(new DayHandler(new EveningHandler(new NightHandler(new FinalHandler()))));
      greetingsResource = new GreetingsResource(greetingsHandler, messageResource);
   }

   @Test
   public void defaultLocaleAllMessages() {

      Date morning = null, day = null, evening = null, night = null;
      try
      {
         morning = dateFormat.parse("08:11:00");
         day = dateFormat.parse("15:11:00");
         evening = dateFormat.parse("20:42:31");
         night = dateFormat.parse("00:57:03");
      } catch (ParseException e)
      {
         System.err.println("Exception during parsing date");
      }
      
      assertEquals(messageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS), greetingsResource.getGreetingsMessage(morning));
      assertEquals(messageResource.getMessage(MessageTypeEnum.DAY_GREETINGS), greetingsResource.getGreetingsMessage(day));
      assertEquals(messageResource.getMessage(MessageTypeEnum.EVENING_GREETINGS), greetingsResource.getGreetingsMessage(evening));
      assertEquals(messageResource.getMessage(MessageTypeEnum.NIGHT_GREETINGS), greetingsResource.getGreetingsMessage(night));
   }
   
   @Test
   public void defaultLocaleCurrrentDateIsNull() {
      assertEquals(greetingsResource.getGreetingsMessage(null), greetingsResource.getGreetingsMessage(new Date()));
   }
   
   @Test
   public void defaultLocaleMorningBoundaryValues() {

      Date morning1 = null, morning2 = null;
      try
      {
         morning1 = dateFormat.parse("06:00:00");
         morning2 = dateFormat.parse("08:59:00");
      } catch (ParseException e)
      {
         System.err.println("Exception during parsing date");
      }
      
      assertEquals(messageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS), greetingsResource.getGreetingsMessage(morning1));
      assertEquals(messageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS), greetingsResource.getGreetingsMessage(morning2));
   }
   
   @Test
   public void defaultLocaleDayBoundaryValues() {

      Date day1 = null, day2 = null;
      try
      {
         day1 = dateFormat.parse("09:00:00");
         day2 = dateFormat.parse("18:59:59");
      } catch (ParseException e)
      {
         System.err.println("Exception during parsing date");
      }

      assertEquals(messageResource.getMessage(MessageTypeEnum.DAY_GREETINGS), greetingsResource.getGreetingsMessage(day1));
      assertEquals(messageResource.getMessage(MessageTypeEnum.DAY_GREETINGS), greetingsResource.getGreetingsMessage(day2));
   }
   
   @Test
   public void defaultLocaleEveningBoundaryValues() {

      Date evening1 = null, evening2 = null;
      try
      {
         evening1 = dateFormat.parse("19:00:00");
         evening2 = dateFormat.parse("22:59:59");
      } catch (ParseException e)
      {
         System.err.println("Exception during parsing date");
      }

      assertEquals(messageResource.getMessage(MessageTypeEnum.EVENING_GREETINGS), greetingsResource.getGreetingsMessage(evening1));
      assertEquals(messageResource.getMessage(MessageTypeEnum.EVENING_GREETINGS), greetingsResource.getGreetingsMessage(evening2));
   }
   
   @Test
   public void defaultLocaleNightBoundaryValues() {

      Date night1 = null, night2 = null;
      try
      {
         night1 = dateFormat.parse("23:00:00");
         night2 = dateFormat.parse("05:59:59");
      } catch (ParseException e)
      {
         System.err.println("Exception during parsing date");
      }

      assertEquals(messageResource.getMessage(MessageTypeEnum.NIGHT_GREETINGS), greetingsResource.getGreetingsMessage(night1));
      assertEquals(messageResource.getMessage(MessageTypeEnum.NIGHT_GREETINGS), greetingsResource.getGreetingsMessage(night2));
   }
}
