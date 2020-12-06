package dev.sonalake.ct.aoc2020

class Day06(private val input: String) {

    fun solvePart1() =
        input.split("\n\n").map {  // groups delimited by a blank line
            it.split(" ", "\n")
                .map { it.toCharArray().toList() }
                .flatten()
                .distinct()
                .count()
        }.sum()

    fun solvePart2() {
    }
}
