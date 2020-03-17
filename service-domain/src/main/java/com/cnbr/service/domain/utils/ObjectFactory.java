package com.cnbr.service.domain.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectFactory {
	public static <E> E build(Supplier<E> x, Consumer<E> y) {
		E e = x.get();
		y.accept(e);
		return e;
	}
}
