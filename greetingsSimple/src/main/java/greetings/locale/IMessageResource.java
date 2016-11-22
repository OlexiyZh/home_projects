package main.java.greetings.locale;

import main.java.greetings.locale.impl.MessageTypeEnum;

public interface IMessageResource {
   public String getMessage(MessageTypeEnum messageType);
}
