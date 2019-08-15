/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.sort;

import java.util.Arrays;

import lombok.extern.java.Log;

/**
 * @author liuhongbin on 2019-08-15 12:15 
 */
@Log
public abstract class AbstractSort {

	/**
	 * 可以做一些速度等指标统计
	 *
	 * @param intArr
	 */
	public void run(int[] intArr) {

		if (null == intArr) {
			throw new IllegalArgumentException();
		}

		int[] preIntArr = Arrays.copyOf(intArr, intArr.length);
		sort(intArr);

		if (null == intArr || intArr.length != preIntArr.length) {
			throw new RuntimeException();
		}

		log.info("\n排序之前 " + Arrays.toString(preIntArr) + "\n排序之后 " + Arrays.toString(intArr));
	}

	/**
	 *
	 * @param intArr
	 */
	protected abstract int[] sort(int[] intArr);
}
