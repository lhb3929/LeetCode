/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.other;

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

			if (intArr[middle] == target) {
				return middle;
			} else if (intArr[middle] > target) {
				end = middle;
				middle = end / 2;
			} else {
				middle = (middle + end) / 2;
			}
		}

		return -1;
	}


	public static void main(String[] args) {
		int pos = new BinarySearch().search(new int[] {7, 8, 13, 20, 39, 46, 64}, 7);
		log.info(pos + "");
	}
}
