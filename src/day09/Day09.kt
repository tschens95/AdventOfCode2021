package day09

import java.io.File

fun main() {

    fun part1(input: List<String>, part1: Boolean): Int {
        val matrix = input.map { inputPos ->
            inputPos.map { it.digitToInt() }
        }
        val rowSize = input[0].length
        var res = 0
        for (row in input.indices) {
            for (column in 0 until rowSize) {
                val currVal = matrix[row][column]
                val adjacents = listOfNotNull(
                    matrix[row].getOrNull(column-1),
                    matrix[row].getOrNull(column+1),
                    matrix.getOrNull(row+1)?.get(column),
                    matrix.getOrNull(row-1)?.get(column)
                )
                val minValue = adjacents.minOrNull()
                if (currVal < minValue!!) {
                   res += 1 + currVal
                }
            }
        }
        return res
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = File("src/day09", "Day09.txt").readText()
    println(part1(input.split("\n"), true))
    println(part2(input.split("\n")))
}