package dev.sonalake.ct.aoc2020

import Resources
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 2")
class Day02Test {
    val exampleInputs = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val count = Day02().solvePart1(exampleInputs)
            assertEquals(2, count)
        }

        @Test
        fun `Actual answer`() {
            val inputs = Resources.resourceAsList("day02.txt")
            val count = Day02().solvePart1(inputs)
            assertEquals(591, count)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val count = Day02().solvePart2(exampleInputs)
            assertEquals(1, count)
        }

        @Test
        fun `Actual answer`() {
            val inputs = Resources.resourceAsList("day02.txt")
            val count = Day02().solvePart2(inputs)
            assertEquals(335, count)
        }
    }
}
