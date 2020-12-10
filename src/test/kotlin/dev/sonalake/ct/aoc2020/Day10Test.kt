package dev.sonalake.ct.aoc2020

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 10")
class Day10Test {
    val example1Input = """
        16
        10
        15
        5
        1
        11
        7
        19
        6
        12
        4
    """.trimIndent().lines().map { it.toInt() }
    val example2Input = """
        28
        33
        18
        42
        31
        14
        46
        20
        48
        47
        24
        23
        49
        45
        19
        38
        39
        11
        1
        32
        25
        35
        8
        17
        7
        9
        4
        2
        34
        10
        3
    """.trimIndent().lines().map { it.toInt() }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example 1`() {
            val result = Day10(example1Input).solvePart1()
            assertEquals(35, result)
        }

        @Test
        fun `Matches example 2`() {
            val result = Day10(example2Input).solvePart1()
            assertEquals(220, result)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day10.txt").map { it.toInt() }
            val result = Day10(input).solvePart1()
            assertEquals(1890, result)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example 1`() {
            val count = Day10(example1Input).solvePart2()
            assertEquals(8, count)
        }

        @Test
        fun `Matches example 2`() {
            val count = Day10(example2Input).solvePart2()
            assertEquals(19208, count)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day10.txt").map { it.toInt() }
            val count = Day10(input).solvePart2()
            assertEquals(49607173328384, count)
        }
    }
}
