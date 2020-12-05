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
            val pair = Day01(exampleInputs).solvePart1(2020)
            val product = pair?.let { exampleInputs[pair.first] * exampleInputs[pair.second] }
            assertEquals(514_579, product)
        }

        @Test
        fun `Actual answer`() {
            val inputs = Resources.resourceAsList("day01.txt").map { it.toInt() }
            val pair = Day01(inputs).solvePart1(2020)
            val product = pair?.let { inputs[pair.first] * inputs[pair.second] }
            assertEquals(299_299, product)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val triple = Day01(exampleInputs).solvePart2(2020)
            val product = triple?.let { exampleInputs[triple.first] *
                exampleInputs[triple.second] * exampleInputs[triple.third] }
            assertEquals(241_861_950, product)
        }

        @Test
        fun `Actual answer`() {
            val inputs = Resources.resourceAsList("day01.txt").map { it.toInt() }
            val triple = Day01(inputs).solvePart2(2020)
            val product = triple?.let { inputs[triple.first] *
                inputs[triple.second] * inputs[triple.third] }
            assertEquals(287_730_716, product)
        }
    }
}
