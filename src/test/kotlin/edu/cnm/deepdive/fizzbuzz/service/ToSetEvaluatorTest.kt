package edu.cnm.deepdive.fizzbuzz.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFailsWith

class ToSetEvaluatorTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, -3, -5, -15, Int.MIN_VALUE])
    fun `evaluate throws IllegalArgumentException for negative values` (input: Int) {
        val evaluator = ToSetEvaluator()
        assertFailsWith<IllegalArgumentException> { evaluator.evaluate(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 6, 9, 33, Int.MAX_VALUE - 1])
    fun `evaluate returns Set(Fizz) for multiples of 3`(input: Int) {
        val evaluator = ToSetEvaluator()
        assertEquals(setOf(FizzBuzz.FIZZ), evaluator.evaluate(input))

    }

    @ParameterizedTest
    @ValueSource(ints = [5, 25, 50, 100, Int.MAX_VALUE - 2])
    fun `evaluate returns Set(Buzz) for multiples of 5`(input: Int) {
        val evaluator = ToSetEvaluator()
        assertEquals(setOf(FizzBuzz.BUZZ), evaluator.evaluate(input))

    }
    @ParameterizedTest
    @ValueSource(ints = [0, 15, 45, 105, Int.MAX_VALUE - 7])
    fun `evaluate returns Set(FizzBuzz) for multiples of 3 and 5`(input: Int) {
        val evaluator = ToSetEvaluator()
        assertEquals(setOf(FizzBuzz.FIZZ, FizzBuzz.BUZZ), evaluator.evaluate(input))

    }
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 16, 128, Int.MAX_VALUE])
    fun `evaluate returns EmptySet(FizzBuzz) when no multiples of 3 or 5`(input: Int) {
        val evaluator = ToSetEvaluator()
        assertEquals(emptySet<FizzBuzz>(), evaluator.evaluate(input))

    }

}