package test.java;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import main.java.greetings.message.IMessageResource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:main/java/greetings/ComponentConfiguration-Greetings.xml"})
public class GreetingsTest
{
   private static final String RESOURCES_LOCATION = "resources.Messages";
   private static final String MORNING = "morning";
   private static final String DAY = "day";
   private static final String EVENING = "evening";
   private static final String NIGHT = "night";
   
   private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
   
   @Autowired
   @Qualifier("GreetingsMessageResource")
   private IMessageResource messageResource;
   
   @Test
   public void defaultLocaleAllMessages() {
      ResourceBundle messages = ResourceBundle.getBundle(RESOURCES_LOCATION, Locale.getDefault());
      
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
      
      assertEquals(messages.getString(MORNING), messageResource.getGreetingsMessage(morning));
      assertEquals(messages.getString(DAY), messageResource.getGreetingsMessage(day));
      assertEquals(messages.getString(EVENING), messageResource.getGreetingsMessage(evening));
      assertEquals(messages.getString(NIGHT), messageResource.getGreetingsMessage(night));

   }
   
   @Test
   public void defaultLocaleBoundaryValues() {
      ResourceBundle messages = ResourceBundle.getBundle(RESOURCES_LOCATION, Locale.getDefault());
      
      Date morning1 = null, morning2 = null, day1 = null, day2 = null, evening1 = null, evening2 = null, night1 = null, night2 = null;
      try
      {
         morning1 = dateFormat.parse("06:00:00");
         morning2 = dateFormat.parse("08:59:00");
         day1 = dateFormat.parse("09:00:00");
         day2 = dateFormat.parse("18:59:59");
         evening1 = dateFormat.parse("19:00:00");
         evening2 = dateFormat.parse("22:59:59");
         night1 = dateFormat.parse("23:00:00");
         night2 = dateFormat.parse("05:59:59");
      } catch (ParseException e)
      {
         System.err.println("Exception during parsing date");
      }
      
      assertEquals(messages.getString(MORNING), messageResource.getGreetingsMessage(morning1));
      assertEquals(messages.getString(MORNING), messageResource.getGreetingsMessage(morning2));
      assertEquals(messages.getString(DAY), messageResource.getGreetingsMessage(day1));
      assertEquals(messages.getString(DAY), messageResource.getGreetingsMessage(day2));
      assertEquals(messages.getString(EVENING), messageResource.getGreetingsMessage(evening1));
      assertEquals(messages.getString(EVENING), messageResource.getGreetingsMessage(evening2));
      assertEquals(messages.getString(NIGHT), messageResource.getGreetingsMessage(night1));
      assertEquals(messages.getString(NIGHT), messageResource.getGreetingsMessage(night2));
   }
}
