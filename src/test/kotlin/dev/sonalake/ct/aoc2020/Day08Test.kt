package dev.sonalake.ct.aoc2020

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 8")
class Day08Test {
    val exampleInput = """
        nop +0
        acc +1
        jmp +4
        acc +3
        jmp -3
        acc -99
        acc +1
        jmp -4
        acc +6
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val acc = Day08(exampleInput).solvePart1()
            assertEquals(5, acc)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day08.txt")
            val acc = Day08(input).solvePart1()
            assertEquals(1600, acc)
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
