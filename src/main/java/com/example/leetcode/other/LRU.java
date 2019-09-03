/*
 * Copyright (c) 2018 Wormpex.com. All Rights Reserved
 */
package com.example.leetcode.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * O(1) get/put
 *
 *
 * @author liuhongbin on 2019-08-30 14:44 
 */
public class LRU<K, V> {

	private int maxSize;

	private int size = 0;

	private Node head;

	private Node tail;

	/**
	 * 淘汰策略
	 * @param count
	 * @return
	 */
	private boolean knockOut(int count) {

		if (count < 0) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < count; i++) {
			if (knockOut()) {

			}
		}


		return Boolean.FALSE;
	}

	private boolean knockOut() {

		return Boolean.FALSE;
	}

	public V get(K key) {

		return null;
	}

	public Boolean put(K key, V value) {

		return null;
	}


	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	private static class Node<K, V> {

		private K key;

		private V value;

		private Node pre;

		private Node next;

	}
}
