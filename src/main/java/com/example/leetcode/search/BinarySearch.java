/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.search;

import lombok.extern.java.Log;

/**
 * @author liuhongbin on 2019-08-20 10:56 
 */
@Log
public class BinarySearch {

	private int search(int[] intArr, int target) {

		if (null == intArr || 0 == intArr.length) {
			return -1;
		}

		int end = intArr.length;
		int middle = end / 2;
		while (middle < end) {

			if (intArr[middle] == target && (0 == middle || intArr[middle - 1] != intArr[middle])) {
				return middle;
			} else if (intArr[middle] < target) {
				middle = (middle + end) / 2;
			} else {
				end = middle;
				middle = end / 2;
			}
		}

		return -1;
	}

	private int roundSearch(int[] intArr, int target) {

		if (null == intArr || 0 == intArr.length) {
			return -1;
		}

		int start = 0;
		int end = intArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (intArr[mid] == target) {
				return mid;
			}

			if (intArr[start] < intArr[mid]) {
				if (intArr[start] <= target & intArr[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (intArr[end] >= target && intArr[mid] < target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}

		return -1;
	}


	public static void main(String[] args) {
		int pos = new BinarySearch().search(new int[] {7, 8, 8, 8, 8, 8, 8, 13, 20, 39, 46, 64}, 8);

		int pos2 = new BinarySearch().roundSearch(new int[] {7, 8, 9, 13, 20, 39, 46, 64, 1, 2, 3}, 3);
		log.info(pos + "  -  " + pos2);
	}
}
