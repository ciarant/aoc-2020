package dev.sonalake.ct.aoc2020

import Resources
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
class Day01Test {
    val exampleInputs = listOf("1721", "979", "366", "299", "675", "1456").map { it.toInt() }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val (first, second) = Day01(exampleInputs).solvePart1(2020)
            val product = exampleInputs[first] * exampleInputs[second]
            println("Hello")
            assertEquals(514_579, product)
        }

        @Test
        fun `Actual answer`() {
            val inputs = Resources.resourceAsList("day01.txt").map { it.toInt() }
            val (first, second) = Day01(inputs).solvePart1(2020)
            val product = inputs[first] * inputs[second]
            assertEquals(299_299, product)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val (first, second, third) = Day01(exampleInputs).solvePart2(2020)
            val product = exampleInputs[first] * exampleInputs[second] * exampleInputs[third]
            assertEquals(241_861_950, product)
        }

        @Test
        fun `Actual answer`() {
            val inputs = Resources.resourceAsList("day01.txt").map { it.toInt() }
            val (first, second, third) = Day01(inputs).solvePart2(2020)
            val product = inputs[first] * inputs[second] * inputs[third]
            assertEquals(287_730_716, product)
        }
    }
}
