package dev.sonalake.ct.aoc2020

import Resources
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 4")
class Day04Test {
    val exampleInput = """
        ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
        byr:1937 iyr:2017 cid:147 hgt:183cm

        iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
        hcl:#cfa07d byr:1929

        hcl:#ae17e1 iyr:2013
        eyr:2024
        ecl:brn pid:760753108 byr:1931
        hgt:179cm

        hcl:#cfa07d eyr:2025 pid:166559648
        iyr:2011 ecl:brn hgt:59in
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val count = Day04(exampleInput).solvePart1()
            assertEquals(2, count)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsString("day04.txt")
            val count = Day04(input).solvePart1()
            assertEquals(254, count)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val count = Day04(exampleInput).solvePart2()
            assertEquals(2, count)
        }

        @Test
        fun `Actual answer`() {
            val input = Resources.resourceAsString("day04.txt")
            val count = Day04(input).solvePart2()
            assertEquals(184, count)
        }
    }
}
