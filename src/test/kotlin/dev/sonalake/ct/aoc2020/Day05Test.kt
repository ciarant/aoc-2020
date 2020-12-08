package dev.sonalake.ct.aoc2020

import Resources
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 5")
class Day05Test {
    val exampleInput = """
        BFFFBBFRRR
        FFFBBBFRRR
        BBFFBBFRLL
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val max = Day05(exampleInput).solvePart1()
            assertEquals(820, max)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day05.txt")
            val max = Day05(input).solvePart1()
            assertEquals(974, max)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day05.txt")
            val max = Day05(input).solvePart2()
            assertEquals(646, max)
        }
    }

}
