package dev.sonalake.ct.aoc2020

class Day09(val input: List<Long>) {

    fun solvePart1(preambleLength: Int) =
        // Grab last element (the target) from first non-valid sliding window of length (preamble + target)
        input.windowed(preambleLength + 1).first { !isValid(it) }.last()

    fun solvePart2(target: Long): Long {
        // TODO Make this functionalish - more reading and thinking required
        for (start in 0..input.lastIndex) {
            var total = 0L
            for (i in start..input.lastIndex) {
                total += input[i]
                if (total == target) {
                    val sublist = input.subList(start, i)
                    return sublist.minOrNull()!! + sublist.maxOrNull()!!
                }
            }
        }
        return 0
    }

    // Zero doesn't appear in data so there's no way of getting a match of 0 + target = target
    // list.last() is target
    fun isValid(list: List<Long>) = list.any { list.last() - it in list }
}
