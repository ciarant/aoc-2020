package dev.sonalake.ct.aoc2020

import kotlin.math.pow

class Day05(private val tickets: List<String>) {

    fun solvePart1() = tickets.map { seatId(it) }.maxOrNull()

    fun solvePart2(): Int {
        tickets.map { seatId(it) }.sorted().zipWithNext { a, b -> if (a + 1 < b) return a + 1 }
        return -1 // FIXME magic number
    }

    private fun seatId(ticket: String): Int = decodePartialTicket(ticket.substring(0..6)) * 8 +
        decodePartialTicket(ticket.substring(7..9))

    // TODO figure out how to do something more succinct and idiomatic than this
    private fun decodePartialTicket(partial: String): Int {
        var low = 0
        var high = (2.0.pow(partial.length) - 1).toInt()
        var value = 0
        partial.forEach {
            when (it) {
                'F', 'L' -> {
                    high -= ((high - low) / 2) + 1
                    value = low
                }
                'B', 'R' -> {
                    low += ((high - low) / 2) + 1
                    value = high
                }
            }
        }
        return value
    }
}
