package main.java.greetings.chain;

import java.util.Date;
import java.util.ResourceBundle;

public interface IGreetingsHandler
{
   public String handleRequest(Date currentDate, ResourceBundle messages);
}
