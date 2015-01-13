package com.acn.webapp.eloa.client.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class RunnableTask implements Runnable
{
  @Override
  public void run()
  {
    System.out.println("Running a task...");
  }

public static void main(String[] args)
{
  ExecutorService executor = Executors.newCachedThreadPool();
  for (int i = 0; i < 8; i++) executor.execute(new RunnableTask());
}
}
