package main.java.greetings.locale.impl;

import java.util.EnumMap;
import java.util.Map;

import main.java.greetings.locale.IMessageResource;

public class RussianMessages implements IMessageResource {

   private static final Map<MessageTypeEnum, String> messages = new EnumMap<MessageTypeEnum, String>(MessageTypeEnum.class);
   static {
      messages.put(MessageTypeEnum.MORNING_GREETINGS, "Ru: Good morning, World!");
      messages.put(MessageTypeEnum.DAY_GREETINGS, "Ru: Good day, World!");
      messages.put(MessageTypeEnum.EVENING_GREETINGS, "Ru: Good evening, World!");
      messages.put(MessageTypeEnum.NIGHT_GREETINGS, "Ru: Good night, World!");
   }


   @Override
   public String getMessage(MessageTypeEnum messageType) {
      if (messageType == null) {
         throw new IllegalArgumentException("messageType can't be null");
      }
      return messages.get(messageType);
   }

}
