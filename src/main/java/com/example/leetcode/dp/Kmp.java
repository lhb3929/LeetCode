/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.dp;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;

/**
 * @author liuhongbin on 2019-08-23 12:02 
 */
public class Kmp {

	private int[] next(String str) {
		int[] next = new int[str.length()];
		next[0] = 0;


		for (int i = 1; i < str.length(); i++) {

			int k = next[i - 1];
			while (k > 0 && !Objects.equals(str.charAt(i), str.charAt(k))) {
				k = next[k - 1];
			}

			if (Objects.equals(str.charAt(i), str.charAt(k))) {
				next[i] = k + 1;
			} else {
				next[i] = 0;
			}
		}

		return next;
	}

	public int compute(String p, String t) {

		if (StringUtils.isBlank(p) || StringUtils.isBlank(t) || t.length() < p.length()) {
			return -1;
		}

		int[] next = next(p);
		int i = 0, j = 0;

		while (i < p.length() && j < t.length()) {
			if (j == -1 || Objects.equals(p.charAt(i), t.charAt(j))) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}

		if (j == p.length()) {
			return i - j;
		} else {
			return -1;
		}
	}
}
