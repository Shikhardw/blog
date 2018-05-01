package com.swayam.jmh.algos;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.swayam.practice.algos.strings.IntegerArrayMatcher;
import com.swayam.practice.algos.strings.IntegerArrayMatcherSimpleStringImpl;

public class IntegerArrayMatcherSimpleStringImplBenchmark {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testContains_positive() {
		// given
		IntegerArrayMatcher testClass = new IntegerArrayMatcherSimpleStringImpl(
				new int[] { 84, 112, 93, 104, 82, 61, 96, 102, 93, 104, 87, 110 });

		// when
		@SuppressWarnings("unused")
		boolean result = testClass.contains(104);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testContains_negative_1() {
		// given
		IntegerArrayMatcher testClass = new IntegerArrayMatcherSimpleStringImpl(
				new int[] { 84, 112, 93, 104, 82, 61, 96, 102, 93, 104, 87, 110 });

		// when
		@SuppressWarnings("unused")
		boolean result = testClass.contains(826);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testContains_negative_2() {
		// given
		IntegerArrayMatcher testClass = new IntegerArrayMatcherSimpleStringImpl(
				new int[] { 84, 112, 93, 104, 82, 61, 96, 102, 93, 104, 87, 110 });

		// when
		@SuppressWarnings("unused")
		boolean result = testClass.contains(9);
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(IntegerArrayMatcherSimpleStringImplBenchmark.class.getSimpleName())
				.warmupIterations(5).measurementIterations(5).forks(1).build();

		new Runner(opt).run();
	}

}