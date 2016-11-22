package main.java.greetings.locale.factory.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import main.java.greetings.locale.IMessageResource;
import main.java.greetings.locale.factory.IMessageResourceFactory;
import main.java.greetings.locale.impl.EnglishMessages;
import main.java.greetings.locale.impl.RussianMessages;

public class MessageResourceFactory implements IMessageResourceFactory {
   
   private static final String DEFAULT_LANGUAGE = "en";

   private Map<String, IMessageResource> messageResources = new HashMap<>();

   @Override
   public IMessageResource getMessageResource(Locale locale) {

      String localeLanguage = null;
      if (locale == null) {
         System.out.println("Locale can't be null. [" + DEFAULT_LANGUAGE + "] language will be used.");
         localeLanguage = DEFAULT_LANGUAGE;
      } else {
         localeLanguage = locale.getLanguage();
      }

      return getMessageResourceByLanguage(localeLanguage);
   }

   private IMessageResource getMessageResourceByLanguage(String language) {
      
      IMessageResource messageResource = messageResources.get(language);
      if (messageResource != null) {
         return messageResource;
      }
      
      System.out.println("MessageResource for language [" + language + "] not found in pool. New message resource will be created.");
      messageResource = createAndAddToPoolMessgeResource(language);

      return messageResource;
   }

   private IMessageResource createAndAddToPoolMessgeResource(String localeLanguage)
   {
      IMessageResource messageResource = null;

      if ("en".equals(localeLanguage)) {
         messageResource = new EnglishMessages();
         messageResources.put("en", messageResource);
      } else if ("ru".equals(localeLanguage)) {
         messageResource = new RussianMessages();
         messageResources.put("ru", messageResource);
      } else {
         System.out.println("Messages for language [" + localeLanguage + "] not found. [" + DEFAULT_LANGUAGE + "] language will be used.");
         messageResource = getMessageResourceByLanguage(DEFAULT_LANGUAGE);
      }

      return messageResource;
   }

}
