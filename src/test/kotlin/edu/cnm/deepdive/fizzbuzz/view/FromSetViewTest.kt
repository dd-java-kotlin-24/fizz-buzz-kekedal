package edu.cnm.deepdive.fizzbuzz.view

import edu.cnm.deepdive.fizzbuzz.model.FizzBuzz
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.collections.emptySet

class FromSetViewTest {
    @ParameterizedTest
    @MethodSource("neither fizz nor buzz test cases")
    fun `render returns string for value on empty evaluation`(
        value: Int,
        evaluation: Set<FizzBuzz>,
        expected: String
    ) {
        val view = FromSetView()
        assertEquals(expected, view.render(value, evaluation))

    }

    @ParameterizedTest
    @MethodSource("fizz test cases")
    fun `render returns FIZZ for setOf(FIZZ)`(
        value: Int,
        evaluation: Set<FizzBuzz>,
        expected: String

    ) {
        val view = FromSetView()
        assertEquals(expected, view.render(value, evaluation))

    }

    @ParameterizedTest
    @MethodSource("buzz test cases")
    fun `render returns BUZZ for setOf(BUZZ)`(
        value: Int,
        evaluation: Set<FizzBuzz>,
        expected: String) {

        val view = FromSetView()
        assertEquals(expected, view.render(value, evaluation))

    }
    @ParameterizedTest
    @MethodSource("fizzbuzz test cases")
    fun `render returns representation of fizzbuzz`(
        value: Int,
        evaluation: Set<FizzBuzz>,
        expected: String) {

        val view = FromSetView()
        assertEquals(expected, view.render(value, evaluation))

    }

    companion object {

        @JvmStatic
        fun `neither fizz nor buzz test cases`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, emptySet<FizzBuzz>(), "1"),
                Arguments.of(2, emptySet<FizzBuzz>(), "2"),
                Arguments.of(16, emptySet<FizzBuzz>(), "16"),
                Arguments.of(1024, emptySet<FizzBuzz>(), "1024"),
                Arguments.of(Int.MAX_VALUE, emptySet<FizzBuzz>(), Int.MAX_VALUE.toString()),

                )
        }

        @JvmStatic
        fun `fizz test cases`(): Stream<Arguments> {
            val evaluation = setOf(FizzBuzz.FIZZ)
            return Stream.of(
                Arguments.of(3, evaluation, FromSetView.FIZZ_REPRESENTATION),
                Arguments.of(6, evaluation, FromSetView.FIZZ_REPRESENTATION),
                Arguments.of(21, evaluation, FromSetView.FIZZ_REPRESENTATION),
                Arguments.of(99, evaluation, FromSetView.FIZZ_REPRESENTATION),
                Arguments.of(Int.MAX_VALUE - 1, evaluation, FromSetView.FIZZ_REPRESENTATION),

                )
        }

        @JvmStatic
        fun `buzz test cases`(): Stream<Arguments> {
            val evaluation = setOf(FizzBuzz.BUZZ)
            return Stream.of(
                Arguments.of(5, evaluation, FromSetView.BUZZ_REPRESENTATION),
                Arguments.of(25, evaluation, FromSetView.BUZZ_REPRESENTATION),
                Arguments.of(50, evaluation, FromSetView.BUZZ_REPRESENTATION),
                Arguments.of(100, evaluation, FromSetView.BUZZ_REPRESENTATION),
                Arguments.of(Int.MAX_VALUE - 2, evaluation, FromSetView.BUZZ_REPRESENTATION),

                )
        }

        @JvmStatic
        fun `fizzbuzz test cases`(): Stream<Arguments> {
            val evaluation = setOf(FizzBuzz.FIZZ, FizzBuzz.BUZZ)
            return Stream.of(
                Arguments.of(0, evaluation, FromSetView.FIZZ_BUZZ_REPRESENTATION),
                Arguments.of(15, evaluation, FromSetView.FIZZ_BUZZ_REPRESENTATION),
                Arguments.of(45, evaluation, FromSetView.FIZZ_BUZZ_REPRESENTATION),
                Arguments.of(105, evaluation, FromSetView.FIZZ_BUZZ_REPRESENTATION),
                Arguments.of(Int.MAX_VALUE - 7, evaluation, FromSetView.FIZZ_BUZZ_REPRESENTATION),
            )
        }

    }

}