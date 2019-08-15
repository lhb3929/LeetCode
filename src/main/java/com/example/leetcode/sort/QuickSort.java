/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.sort;

/**
 * @author liuhongbin on 2019-08-15 12:15 
 */
public class QuickSort extends AbstractSort {


	@Override
	protected int[] sort(int[] intArr) {
		quickSort(0, intArr.length - 1, intArr);
		return intArr;
	}

	private void quickSort(int start, int end, int[] intArr) {

		if (end > start) {
			int partition = partition(start, end, intArr);
			quickSort(start, partition - 1, intArr);
			quickSort(partition + 1, end, intArr);
		}
	}

	private int partition(int start, int end, int[] intArr) {

		int pivot = intArr[start];
		int left = start,
				right = end;

		while (left <= right) {
			while (left <= right && intArr[left] <= pivot) {
				left++;
			}

			while (left <= right && intArr[right] > pivot) {
				right--;
			}

			if (left < right) {
				swap(intArr, left, right);
				left++;
				right--;
			}
		}

		swap(intArr, start, right);
		return right;
	}

	private void swap(int[] intArr, int left, int right) {
		int temp = intArr[left];
		intArr[left] = intArr[right];
		intArr[right] = temp;
	}

	public static void main(String[] args) {
		new QuickSort().run(new int[] {12, 8, 13, 10, 19, 16, 14});
	}

}
