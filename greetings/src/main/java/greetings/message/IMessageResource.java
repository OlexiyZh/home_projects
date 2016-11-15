package main.java.greetings.message;

import java.util.Date;
import java.util.Locale;

public interface IMessageResource
{
   public String getGreetingsMessage(Date currentDate);
   public void setLocale(Locale locale);
}
