package dev.sonalake.ct.aoc2020

class Day04(private val input: String) {
    companion object {
        private val REQUIRED_KEYS = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
        private val COLOUR_REGEX = """^#[a-f\d]{6}""".toRegex()
        private val VALID_EYE_COLOURS = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    }

    fun solvePart1() = passportsToList().filter { fieldMap -> fieldMap.keys.containsAll(REQUIRED_KEYS) }.count()

    fun solvePart2() = passportsToList().filter { fieldMap -> Passport(fieldMap).isValid() }.count()

    private fun passportsToList(): List<Map<String, String>> =
        input.split("\n\n").map {  // passports delimited by a blank line
            it.split(" ", "\n")
                .filter { it.isNotBlank() }
                .map {
                    it.split(":")[0] to it.split(":")[1]
                }
                .toMap()
        }

    private class Passport(val fields: Map<String, String>) {
        fun isValid(): Boolean {
            return fields.keys.containsAll(REQUIRED_KEYS) &&
                fields["byr"]?.toIntOrNull()?.run { this in 1920..2002 } == true &&
                fields["iyr"]?.toIntOrNull()?.run { this in 2010..2020 } == true &&
                fields["eyr"]?.toIntOrNull()?.run { this in 2020..2030 } == true &&
                fields["pid"]?.toIntOrNull()?.run { fields["pid"]!!.length == 9 } == true &&
                fields["ecl"] in VALID_EYE_COLOURS &&
                colourIsValid(fields["hcl"]!!) &&
                heightIsValid(fields["hgt"]!!)
        }

        fun colourIsValid(colour: String) = colour.matches(COLOUR_REGEX)

        fun heightIsValid(height: String) =
            when(height.takeLast(2)) {
                "cm" -> height.substringBefore("cm").toInt() in 150..193
                "in" -> height.substringBefore("in").toInt() in 59..76
                else -> false
            }
    }
}
