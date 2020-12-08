package dev.sonalake.ct.aoc2020

import dev.sonalake.ct.aoc2020.Day08.OpCode.*
import java.lang.IllegalArgumentException

class Day08(instructions: List<String>) {
    val program = parseInstructions(instructions)

    fun solvePart1(): Int {
        val cpu = CPU(program)
        cpu.run()
        return cpu.acc
    }

    fun solvePart2(): Int {
        program.forEachIndexed { i, instr ->
            when (instr.opcode) { // Modify program
                NOP -> program.take(i) + instr.copy(opcode = JMP) + program.drop(i + 1)
                JMP -> program.take(i) + instr.copy(opcode = NOP) + program.drop(i + 1)
                else -> null
            }?.let { modifiedProgram ->
                val cpu = CPU(modifiedProgram)
                if (cpu.run()) return cpu.acc
            }
        }
        throw IllegalArgumentException("Solution not found")
    }

    class CPU(val memory: List<Instruction>) {
        var pc = 0  // Program Counter
        var acc = 0 // Accumulator
        var executed = BooleanArray(memory.size) // Which memory locations have been executed

        fun run(): Boolean {
            while (true) {
                if (pc >= memory.size) return true // Valid exit - program completed
                if (executed[pc]) return false    // Invalid exit - infinite loop
                val instr = memory[pc]
                executed[pc] = true
                when (instr.opcode) {
                    ACC -> acc += instr.operand
                    JMP -> pc += instr.operand - 1
                }
                pc++
            }
        }
    }

    data class Instruction(var opcode: OpCode, val operand: Int)

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
