package dev.sonalake.ct.aoc2020

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
class Day03Test {
    val exampleInput = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val count = Day03(exampleInput).solvePart1()
            assertEquals(7, count)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day03.txt")
            val count = Day03(input).solvePart1()
            assertEquals(270, count)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val count = Day03(exampleInput).solvePart2()
            assertEquals(336, count)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsList("day03.txt")
            val count = Day03(input).solvePart2()
            assertEquals(2122848000, count)
        }
    }
}
