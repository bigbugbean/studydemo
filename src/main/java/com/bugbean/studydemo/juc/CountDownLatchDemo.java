package com.bugbean.studydemo.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(1);

		for (int i = 0; i < 6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "走人");
				countDownLatch.countDown();
			}, String.valueOf(i)).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName() + "*****班长走人");
	}
}
