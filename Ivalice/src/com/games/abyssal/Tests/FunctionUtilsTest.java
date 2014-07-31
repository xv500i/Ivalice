package com.games.abyssal.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.games.abyssal.Domain.FunctionUtils;

public class FunctionUtilsTest {

	@Test
	public void testConstant() {
		assertTrue(FunctionUtils.constant(4f) == 4);
		assertTrue(FunctionUtils.constant(367f) == 367);
		assertTrue(FunctionUtils.constant(0f) == 0);
	}
	
	@Test
	public void testLinear() {
		assertTrue(FunctionUtils.linear(5f, 2f, 3) == 2*3+5);
		assertTrue(FunctionUtils.linear(0f, 0.76f, 4) == 3);
		assertTrue(FunctionUtils.linear(0f, 0.51f, 4) == 2);
		int x = 4;
		assertEquals(x, FunctionUtils.linearInverse(5f, 3f, FunctionUtils.linear(5f, 3f, x)));
		// Rounding down
		assertEquals(x-1, FunctionUtils.linearInverse(5.5f, 3.0f, FunctionUtils.linear(5.5f, 3.0f, x)));
	}

	@Test
	public void testRoot() {
		assertTrue(FunctionUtils.root(5f, 2f, 9) == 3*2+5);
		assertTrue(FunctionUtils.root(0f, 0.76f, 16) == 3);
		assertTrue(FunctionUtils.root(0f, 0.51f, 16) == 2);
		int x = 4;
		assertEquals(x, FunctionUtils.rootInverse(5f, 3f, FunctionUtils.root(5f, 3f, x)));
		// Rounding down
		assertEquals(x-1, FunctionUtils.rootInverse(5.5f, 3.0f, FunctionUtils.root(5.5f, 3.0f, x)));
	}
	
	@Test
	public void testSquare() {
		assertTrue(FunctionUtils.square(5f, 2f, 3f, 9) == 1463);
		assertTrue(FunctionUtils.square(0f, 0.76f, 3f, 16) == 3112);
		assertEquals(FunctionUtils.square(0f, 0.51f, 2f, 16), 130);
		int x = 4;
		assertEquals(x, FunctionUtils.squareInverse(5f, 3f, 2f, FunctionUtils.square(5f, 3f, 2f, x)));
		// Rounding down
		assertEquals(x-1, FunctionUtils.squareInverse(5.5f, 3.0f, 2f, FunctionUtils.square(5.5f, 3.0f, 2f, x)));
	}
}
