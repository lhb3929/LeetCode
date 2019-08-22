/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.sort;

/**
 * @author liuhongbin on 2019-08-22 11:18 
 */
public class MergeSort extends AbstractSort {


	@Override
	protected int[] sort(int[] intArr) {
		mergeSort(intArr, 0, intArr.length - 1);
		return intArr;
	}


	private void merge(int[] data, int start, int mid, int end) {

		int len1 = mid - start + 1;
		int len2 = end - mid;

		int[] left = new int[len1];
		int[] right = new int[len2];

		for (int i = 0; i < len1; i++) {
			left[i] = data[i + start];
		}

		for (int j = 0; j < len2; j++) {
			right[j] = data[mid + j + 1];
		}

		int i = 0, j = 0, k;
		for (k = start; k < end; k++) {
			if (i == len1 || j == len2) {
				break;
			}

			if (left[i] <= right[j]) {
				data[k] = left[i++];
			} else {
				data[k] = right[j++];
			}

		}

		while (i < len1) {
			data[k++] = left[i++];
		}

		while (j < len2) {
			data[k++] = right[j++];
		}

	}

	private void mergeSort(int[] data, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			merge(data, start, mid, end);
		}
	}


	public static void main(String[] args) {
		new MergeSort().run(new int[] {12, 8, 13, 10, 19, 16, 14});
	}
}
