package dev.sonalake.ct.aoc2020

class Day02 {
    companion object {
        private val pattern = Regex("""(\d*)-(\d*) ([a-z]): (.*)""")
    }

    fun solvePart1(input: List<String>): Int {
        return toPasswordEntryList(input).count { it.isValid1() }
    }

    fun solvePart2(input: List<String>): Int {
        return toPasswordEntryList(input).count { it.isValid2() }
    }

    private fun toPasswordEntryList(input: List<String>): List<PasswordEntry> =
        input.map {
            val (min, max, ch, password) = pattern.matchEntire(it)!!.destructured
            PasswordEntry(ch[0], IntRange(min.toInt(), max.toInt()), password)
        }

    class PasswordEntry(private val ch: Char, private val range: IntRange, private val password: String) {
        fun isValid1() = password.count(ch) in range
        fun isValid2() = password.charAtIs(range.first - 1, ch) xor
            password.charAtIs(range.last - 1, ch)
    }
}

fun String.count(ch: Char) = this.count { it == ch }
fun String.charAtIs(position: Int, ch: Char) = this[position] == ch
