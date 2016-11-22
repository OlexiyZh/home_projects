package main.java.greetings.locale.factory;

import java.util.Locale;

import main.java.greetings.locale.IMessageResource;

public interface IMessageResourceFactory
{
   public IMessageResource getMessageResource(Locale locale);
}
