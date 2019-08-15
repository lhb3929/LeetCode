/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.sort;

/**
 * @author liuhongbin on 2019-08-15 12:56 
 */
public class InsertSort extends AbstractSort {


	@Override
	protected int[] sort(int[] intArr) {

		for (int p = 1; p < intArr.length; p++) {

			int temp = intArr[p];
			int i = p - 1;

			while (i >= 0 && intArr[i] > temp) {

				intArr[i + 1] = intArr[i];
				i--;
			}

			intArr[i + 1] = temp;
		}

		return intArr;
	}


	public static void main(String[] args) {
		new InsertSort().run(new int[] {12, 8, 13, 10, 19, 16, 14});
	}
}
