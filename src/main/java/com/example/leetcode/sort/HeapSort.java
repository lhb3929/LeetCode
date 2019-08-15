/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.sort;

/**
 * @author liuhongbin on 2019-08-15 13:08 
 */
public class HeapSort extends AbstractSort {


	@Override
	protected int[] sort(int[] intArr) {

		buildHeap(intArr, intArr.length);

		for (int i = intArr.length - 1; i > 0; i--) {

			int temp = intArr[0];
			intArr[0] = intArr[i];
			intArr[i] = temp;

			siftDown(intArr, 0, i);
		}

		return intArr;
	}

	private void buildHeap(int[] intArr, int n) {
		int p = n / 2 - 1;
		for (int i = p; i >= 0; i--) {
			siftDown(intArr, i, n);
		}
	}

	private void siftDown(int[] intArr, int i, int n) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int min = i;

		if (left < n && intArr[min] < intArr[left]) {
			min = left;
		}

		if (right < n && intArr[min] < intArr[right]) {
			min = right;
		}

		if (min != i) {
			int temp = intArr[min];
			intArr[min] = intArr[i];
			intArr[i] = temp;

			siftDown(intArr, min, n);
		}

	}


	public static void main(String[] args) {
		new HeapSort().run(new int[] {12, 8, 13, 10, 19, 16, 14});
	}
}
