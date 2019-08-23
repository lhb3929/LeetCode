/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.dp;

/**
 * @author liuhongbin on 2019-08-23 10:12 
 */
public class KnapSackProblem {

	/**
	 * 商品的体积2、3、4、5
	 */
	private final int[] w = {1, 2, 3, 4, 5};

	/**
	 * 商品的价值3、4、5、6
	 */
	private final int[] v = {1, 3, 4, 5, 6};

	/**
	 * 背包大小
	 */
	private final int bagV = 8;

	private final int[][] dp = new int[w.length + 1][bagV + 1];


	private int compute() {

		for (int i = 0; i <= w.length; i++) {
			for (int j = 0; j <= bagV; j++) {
				dp[i][j] = 0;
			}
		}

		for (int j = 1; j <= w.length; j++) {
			for (int i = 1; i <= bagV; i++) {

				if (i < w[j - 1]) {
					dp[j][i] = dp[j - 1][i];
				} else {
					dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i - w[j - 1]] + v[j - 1]);
				}
			}
		}

		return dp[w.length][bagV];
	}

	public static void main(String[] args) {
		int value = new KnapSackProblem().compute();
	}

}
