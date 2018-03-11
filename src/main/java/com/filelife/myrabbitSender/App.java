package com.filelife.myrabbitSender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Starting Sender...");
		int i = 0;
		ExecutorService executorService = new ThreadPoolExecutor(100, 1000, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		Callable<String> callableTask = () -> {
			AmqpSender rmqs = new RabbitmqSender();
			String threadName = Thread.currentThread().getName();
			rmqs.sendMessage("Msg_id 1 Send@ " + (DateTime.now() + " Maronn Task's execution by thread " + threadName));
			return "MsgId 1 Send@ " + DateTime.now() + " Maronn Task's execution by thread " + threadName;
		};

		List<Callable<String>> callableTasks = new ArrayList<>();
		for (int k = 0; k < 100; k++) {
			for (i = 0; i < 1000; i++) {
				callableTasks.add(callableTask);
			}
		}

		try {
			List<Future<String>> futures = executorService.invokeAll(callableTasks);
			String result = "";
			for (Future<String> future : futures) {
				result = future.get();
				System.out.println("Result: " + result);
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * int r=0; AmqpSender rmqs = new RabbitmqSender(); try { for (int i = 0; i <
		 * 10; i++) { rmqs.sendMessage("Msg_id "+i+" Send@ "+(DateTime.now() +
		 * " Maronn wait for " +r));
		 * //System.out.println("Msg_id "+i+" Send@ "+(DateTime.now() +
		 * " Maronn wait for " +r)); r = ThreadLocalRandom.current().nextInt(1000, 5000
		 * + 1); Thread.sleep(r); } } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}
}
