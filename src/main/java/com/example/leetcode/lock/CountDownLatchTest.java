/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhongbin on 2019-08-20 14:42 
 */
@Slf4j
public class CountDownLatchTest {

	public static void test() {

		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
				.setNameFormat("threadFactory name : %s").build();

		ExecutorService executorService = new ThreadPoolExecutor(10,
				10,
				0, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(),
				namedThreadFactory,
				new ThreadPoolExecutor.AbortPolicy());

		Runnable runnable = () -> {

		};

		Thread thread = namedThreadFactory.newThread(runnable);
		for (int i = 0; i < 10; i++) {

			log.error(thread.getName());
			thread = namedThreadFactory.newThread(runnable);
		}

	}

	public static void main(String[] args) {
		CountDownLatchTest.test();
	}
}
