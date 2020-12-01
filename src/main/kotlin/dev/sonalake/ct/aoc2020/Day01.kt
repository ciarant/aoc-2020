package dev.sonalake.ct.aoc2020

class Day01(val input: List<Int>) {

    fun solvePart1(target: Int): Pair<Int, Int> {
        // Two Sum problem - one-pass hashtable
        val map = HashMap<Int, Int>()
        input.forEachIndexed { i, item ->
            if (map.contains(target - item)) {
                return Pair(map[target - item]!!, i)
            }
            map.put(item, i)
        }
        return Pair(-1, -1) // FIXME avoid magic number
    }

    fun solvePart2(target: Int): Triple<Int, Int, Int> {
        input.forEachIndexed { i, item ->
            val (first, second) = solvePart1(target - item)
            if (first != -1) {
                return Triple(first, second, i)
            }
        }
        throw IllegalArgumentException("No solution") // FIXME avoid exception
    }
}
