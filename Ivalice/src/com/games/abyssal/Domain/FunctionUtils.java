package com.games.abyssal.Domain;

public class FunctionUtils {
	public static int linear(Float a, Float b, int x) {
		float res = (b*x + a);
		return (int) res;
	}

	public static int square(Float a, Float b, Float c, int x) {
		double res = (Math.pow(x, c)*b + a);
		return (int) res;
	}

	public static int root(Float a, Float b, int x) {
		double res = (Math.pow(x, 0.5)*b + a);
		return (int) res;
	}

	public static int constant(float a) {
		return (int)a;
	}
	
	public static int linearInverse(Float a, Float b, int y) {
		float res = ((y - a)/b);
		return (int) res;
	}

	public static int squareInverse(Float a, Float b, Float c, int y) {
		return (int) (Math.pow((y - a)/b, 1/c ));
	}

	public static int rootInverse(Float a, Float b, int y) {
		return (int) Math.pow( (y - a) / b, 2.0f );
	}
}
