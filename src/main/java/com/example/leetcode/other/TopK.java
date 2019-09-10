/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.other;

import com.example.leetcode.sort.InsertSort;

/**
 * @author liuhongbin on 2019-09-10 11:01 
 */
public class TopK {

	public int run(int[] arr, int k) {

		if (null == arr
				|| 0 == arr.length
				|| k < 0
				|| k > arr.length) {
			throw new IllegalArgumentException();
		}

		compute(arr, 0, arr.length - 1, k - 1);

		return arr[arr.length - k];
	}

	private void compute(int[] arr, int left, int right, int k) {
		if (left <= right) {
			int partition = partition(arr, left, right);
			if (partition > k) {
				compute(arr, left, partition, k);
			} else if (partition < k) {
				compute(arr, partition + 1, right, k);
			}
		}
	}

	private int partition(int[] arr, int left, int right) {

		int start = left;
		int pivot = arr[start];

		while (left <= right) {

			while (left <= right && arr[left] >= pivot) {
				left++;
			}

			while (left <= right && pivot >= arr[right]) {
				right--;
			}

			if (left < right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}

		swap(arr, start, right);
		return right;
	}

	private void swap(int[] arr, int item1, int item2) {
		int temp = arr[item1];
		arr[item1] = arr[item2];
		arr[item2] = temp;
	}

	public static void main(String[] args) {
		int topK = new TopK().run(new int[] {12, 8, 13, 10, 19, 16, 14}, 4);
	}
}
