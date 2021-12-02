package day01

import readInput
import kotlin.streams.toList

fun main() {
    fun part1(input: List<String>): Int {
        var current = input[0].toInt()
        var next: Int
        var counter = 0
        for (i in 0..input.size) {
            if (i <= input.size-1) {
                next = input[i].toInt()
                if (current < next) {
                    counter++
                }
                current = next
            }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        val intList = input.stream().map(String::toInt).toList()
        for (i in 0..intList.size) {
            if (i <= intList.size - 4) {
                val currentMW = intList[i] + intList[i+1] + intList[i+2]
                val nextMW = intList[i+1] + intList[i+2] + intList[i+3]
                if (currentMW < nextMW) {
                    counter++
                }
            }
        }
        return counter
    }

    val input = readInput("day01")
    println(part1(input))
    println(part2(input))
}