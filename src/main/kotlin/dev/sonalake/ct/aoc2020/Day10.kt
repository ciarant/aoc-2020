package dev.sonalake.ct.aoc2020

class Day10(input: List<Int>) {
    private val input = input.sorted()

    fun solvePart1(): Int {
        // Prefix the adapter list with the outlet joltage (0), and suffix it with the device voltage (max + 3)
        val adapters = listOf(0) + input + listOf(input.last() + 3)
        // Difference distribution
        val differences = adapters.zipWithNext().map { it.second - it.first }.groupBy { it }
        return differences[1]!!.size * differences[3]!!.size
    }

    fun solvePart2(): Long {
        val permutations = mutableMapOf(0 to 1L)
        input.forEach { adapter ->
            permutations[adapter] = (1..3).map { offset -> // Count the ways out of each adapter
                permutations[adapter - offset] ?: 0
            }.sum()
        }
        return permutations[input.last()]!!
    }
}
