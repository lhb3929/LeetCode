/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.other;

/**
 * @author liuhongbin on 2019-09-12 13:06 
 */
public class Sqrt {

	public double SqrtByBisection(double n, double eps) {

		double start = 0.0;
		double end = n < 1 ? 1 : n;
		double mid = (start + end) / 2;
		double last;
		do {
			if (mid * mid > n) {
				end = mid;
			} else {
				start = mid;
			}

			last = mid;
			mid = (start + end) / 2;
		} while (fabsf(mid - last) > eps);

		return mid;
	}

	private double fabsf(double n) {
		return n > 0.0 ? n : 0 - n;
	}

	public double SqrtByNewton(double x, double eps) {

		double val = x;
		double last;
		do {
			last = val;
			val = (val + x / val) / 2;
		} while (fabsf(val - last) > eps);
		return val;
	}

	public static void main(String[] args) {
		double val = new Sqrt().SqrtByBisection(2, 0.001);
	}

}
