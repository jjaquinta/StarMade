package com.google.code.tempusfugit.concurrency;

public abstract interface Callable<V, E extends Exception> extends java.util.concurrent.Callable<V>
{
  public abstract V call()
    throws Exception;
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     com.google.code.tempusfugit.concurrency.Callable
 * JD-Core Version:    0.6.2
 */