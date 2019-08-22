/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author liuhongbin on 2019-08-20 14:42 
 */
public class CountDownLatchTest {

	public void test() {

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

	}
}
