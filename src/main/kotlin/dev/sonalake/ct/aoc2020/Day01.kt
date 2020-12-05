package dev.sonalake.ct.aoc2020

class Day01(val input: List<Int>) {

    // Return the two integers from the input list that sum to the `target`
    fun solvePart1(target: Int): Pair<Int, Int>? {
        // Two Sum problem - one-pass hashtable
        val map = HashMap<Int, Int>()
        //
        input.forEachIndexed { i, item ->
            if (map.contains(target - item)) { // Found it. The complement of the current item in the map.
                return Pair(map[target - item]!!, i)
            }
            map.put(item, i)
        }
        return null
    }

    // Return the three integers from the input list that sum to the `target`
    fun solvePart2(target: Int): Triple<Int, Int, Int>? {
        // FIXME this feels a little copy pastey of `solvePart1`
        input.forEachIndexed { i, item ->
            val pair = solvePart1(target - item)
            if (pair != null) return Triple(pair.first, pair.second, i)
        }
        return null
    }
}
