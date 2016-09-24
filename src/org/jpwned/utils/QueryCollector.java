package org.jpwned.utils;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 
 * @author Dariush Moshiri
 *
 */
public class QueryCollector implements Collector<Map.Entry<String, String>, StringBuilder, String> {

	@Override
	public Supplier<StringBuilder> supplier() {
		return () -> new StringBuilder();
	}

	@Override
	public BiConsumer<StringBuilder, Entry<String, String>> accumulator() {
		return (acc, entry) -> acc.append("&" + entry.getKey() + "=" + entry.getValue());
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		return (acc1, acc2) -> acc1.append(acc2);
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		return (acc) -> acc.toString().replaceFirst("&", "?");
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
