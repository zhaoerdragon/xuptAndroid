package com.example.library.datastru;

/**
 * 2维元组
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "first is " + first + " second is " + second;
    }
}
