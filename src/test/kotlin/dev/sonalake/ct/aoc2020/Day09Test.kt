package dev.sonalake.ct.aoc2020

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 9")
class Day09Test {
    val exampleInput = """
        35
        20
        15
        25
        47
        40
        62
        55
        65
        95
        102
        117
        150
        182
        127
        219
        299
        277
        309
        576
    """.trimIndent().lines().map { it.toLong() }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val match = Day09(exampleInput).solvePart1(5)
            assertEquals(127, match)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day09.txt").map { it.toLong() }
            val match = Day09(input).solvePart1(25)
            assertEquals(105950735, match)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val sum = Day09(exampleInput).solvePart2(127)
            assertEquals(62, sum)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day09.txt").map { it.toLong() }
            val sum = Day09(input).solvePart2(105950735)
            assertEquals(13826915, sum)
        }
    }
}
