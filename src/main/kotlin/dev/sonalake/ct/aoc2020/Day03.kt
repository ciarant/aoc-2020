package dev.sonalake.ct.aoc2020

class Day03(val input: List<String>) {
    val width = input[0].length
    val height = input.size

    fun solvePart1(): Int = countTrees(Pair(3, 1))

    fun solvePart2(): Long {
        val slopes = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
        return slopes.map { countTrees(it).toLong() }.reduce { acc, i -> acc * i }
    }

    // Sequence of points visited for given path (x and y offsets)
    fun path(step: Pair<Int, Int>): Sequence<Pair<Int, Int>> =
        generateSequence(Pair(0, 0)) { prev -> Pair(prev.first + step.first, prev.second + step.second)
            .takeIf { next -> next.second < height }}

    fun countTrees(step: Pair<Int, Int>): Int =
        path(step).count { point -> input[point.second][point.first % width] == '#' }
}
