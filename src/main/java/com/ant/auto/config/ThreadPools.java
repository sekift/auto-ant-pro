package com.ant.auto.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sekift
 */
public class ThreadPools {
	
	public static ExecutorService newExecutorService(int coreSize, 
													 int maxSize,
													 int keepAlive,
													final String nameTemplate) {
		
		BlockingQueue<Runnable> queue =  new SynchronousQueue<>();
		ThreadFactory fac = r -> {
			Thread t = Executors.defaultThreadFactory().newThread(r);
			t.setName(nameTemplate + "@[" + System.identityHashCode(t) + "]");
			t.setDaemon(true);
			return t;
		};
		return new ThreadPoolExecutor(coreSize, maxSize, keepAlive, TimeUnit.SECONDS, queue, fac); 
	}
	
	public static ScheduledExecutorService newScheduledExecutorService(int coreSize, final String nameTemplate) {
		
		ThreadFactory fac = r -> {
			Thread t = Executors.defaultThreadFactory().newThread(r);
			t.setName(nameTemplate + "@[" + System.identityHashCode(t) + "]");
			t.setDaemon(true);
			return t;
		};
		return new ScheduledThreadPoolExecutor(coreSize, fac);
	}
}
