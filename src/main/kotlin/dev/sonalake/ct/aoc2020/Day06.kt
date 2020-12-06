package dev.sonalake.ct.aoc2020

class Day06(private val input: String) {

    fun solvePart1() = questionnairesToList().sumBy {
        it.reduce { acc, person ->  acc union person }.size }

    fun solvePart2() = questionnairesToList().sumBy {
        it.reduce { acc, person ->  acc intersect person }.size }

    fun questionnairesToList() = input
        .split("\n\n") // groups delimited by a blank line
        .map {
            it.split("\n")
                .filter { it.isNotEmpty() }
                .map { it.toSet() }
        }
}
