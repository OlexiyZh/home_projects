package main.java.greetings.chain;

import java.util.Date;

import main.java.greetings.locale.IMessageResource;

public interface IGreetingsHandler
{
   public String handleRequest(Date currentDate, IMessageResource messageResource);
}
