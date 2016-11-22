package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Locale;

import main.java.greetings.locale.IMessageResource;
import main.java.greetings.locale.factory.IMessageResourceFactory;
import main.java.greetings.locale.factory.impl.MessageResourceFactory;
import main.java.greetings.locale.impl.EnglishMessages;
import main.java.greetings.locale.impl.MessageTypeEnum;
import main.java.greetings.locale.impl.RussianMessages;

import org.junit.BeforeClass;
import org.junit.Test;

public class MessageResourceTest
{
   private static IMessageResourceFactory messageResourceFactory;
   private static IMessageResource englishMessageResource;
   private static IMessageResource russianMessageResource;
   
   @BeforeClass
   public static void setUpClass() {
      messageResourceFactory = new MessageResourceFactory();
      englishMessageResource = new EnglishMessages();
      russianMessageResource = new RussianMessages();
   }
   
   @Test
   public void englishMessages() {
      IMessageResource messageResource = messageResourceFactory.getMessageResource(Locale.ENGLISH);
      
      assertEquals(englishMessageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS), messageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS));
   }
   
   @Test
   public void russianMessages() {
      IMessageResource messageResource = messageResourceFactory.getMessageResource(Locale.forLanguageTag("ru"));
      
      assertEquals(russianMessageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS), messageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS));
   }
   
   @Test
   public void messagesNotFoundDefaultLanguage() {
      IMessageResource messageResource = messageResourceFactory.getMessageResource(Locale.forLanguageTag("fr"));
      
      assertEquals(englishMessageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS), messageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS));
   }
   
   @Test
   public void localeIsNull() {
      IMessageResource messageResource = messageResourceFactory.getMessageResource(null);
      
      assertEquals(englishMessageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS), messageResource.getMessage(MessageTypeEnum.MORNING_GREETINGS));
   }
   
   @Test
   public void messageResourceIsOneLocaleIsNull() {
      IMessageResource messageResource1 = messageResourceFactory.getMessageResource(null);
      IMessageResource messageResource2 = messageResourceFactory.getMessageResource(null);
      
      assertSame(messageResource1, messageResource2);
   }
   
   @Test
   public void messageResourceIsOneRussianLocale() {
      IMessageResource messageResource1 = messageResourceFactory.getMessageResource(Locale.forLanguageTag("ru"));
      IMessageResource messageResource2 = messageResourceFactory.getMessageResource(Locale.forLanguageTag("ru"));
      
      assertSame(messageResource1, messageResource2);
   }
   
   @Test
   public void messageResourceIsOneEnglishLocale() {
      IMessageResource messageResource1 = messageResourceFactory.getMessageResource(Locale.ENGLISH);
      IMessageResource messageResource2 = messageResourceFactory.getMessageResource(Locale.ENGLISH);
      
      assertSame(messageResource1, messageResource2);
   }
}
