package dev.sonalake.ct.aoc2020

import Resources
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06Test {
    val exampleInput = """
        abc

        a
        b
        c

        ab
        ac

        a
        a
        a
        a

        b
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val count = Day06(exampleInput).solvePart1()
            assertEquals(11, count)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsString("day06.txt")
            val count = Day06(input).solvePart1()
            assertEquals(6504, count)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
        }
        
        @Test
        fun `Actual answer`() {
        }
    }

}
