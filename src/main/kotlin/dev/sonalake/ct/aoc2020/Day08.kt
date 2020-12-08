package dev.sonalake.ct.aoc2020

import dev.sonalake.ct.aoc2020.Day08.OpCode.*

class Day08(instructions: List<String>) {
    val cpu = CPU(parseInstructions(instructions))

    fun solvePart1(): Int {
        cpu.run()
        return cpu.acc
    }

    fun solvePart2() {
    }

    class CPU(val memory: List<Instruction>) {
        var pc = 0  // Program Counter
        var acc = 0 // Accumulator
        var executed = BooleanArray(memory.size) // Which memory locations have been executed

        fun run(): Boolean {
            while (true) {
                val instr = memory[pc]
                if (pc > memory.size) return true // Valid exit - program completed
                if (executed[pc]) return false    // Invalid exit - infinite loop
                executed[pc] = true
                when (instr.opcode) {
                    NOP -> pc++
                    ACC -> {
                        acc += instr.operand
                        pc++
                    }
                    JMP -> pc += instr.operand
                }
            }
        }

        fun reset() {
            pc = 0
            acc = 0
            executed = BooleanArray(memory.size)
        }
    }

    data class Instruction(val opcode: OpCode, val operand: Int)

    enum class OpCode {
        NOP,
        ACC,
        JMP
    }

    private fun parseInstructions(instructions: List<String>): List<Instruction> =
        instructions.map {
            Instruction(
                valueOf(it.split(" ")[0].toUpperCase()),
                it.split(" ")[1].toInt()
            )
        }
}
