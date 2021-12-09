package day09

import java.io.File
import kotlin.math.min

fun main() {

    fun compareThree(a: Int, b: Int, c: Int): Boolean {
        val min = min(a, min(b, c))
        return a == min
    }

    fun compareFour(a: Int, b: Int, c: Int, d: Int): Boolean {
        val min = min(min(a, b), min(c, d))
        return a == min
    }

    fun compareFive(a: Int, b: Int, c: Int, d: Int, e: Int): Boolean {
        val min = min(min(min(a, b), min(c, d)), e)
        return a == min
    }

    fun part1(input: List<String>, part1: Boolean): Int {
        val matrix = input.map { inputPos ->
            inputPos.map { it.digitToInt() }
        }
        val lowPoints = mutableListOf<Int>()
        val rowSize = input[0].length
        for (row in input.indices) {
            for (column in 0 until rowSize) {
                val res: Int = matrix[row][column] + 1
                when (row) {
                    0 -> {
                        when (column) {
                            0 -> {
                                if (compareThree(
                                        matrix[row][column],
                                        matrix[row][column + 1],
                                        matrix[row + 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                            rowSize - 1 -> {
                                if (compareThree(
                                        matrix[row][column],
                                        matrix[row][column - 1],
                                        matrix[row + 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                            else -> {
                                if (compareFour(
                                        matrix[row][column],
                                        matrix[row][column + 1],
                                        matrix[row][column - 1],
                                        matrix[row + 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                        }
                    }
                    input.size - 1 -> {
                        when (column) {
                            0 -> {
                                if (compareThree(
                                        matrix[row][column],
                                        matrix[row][column + 1],
                                        matrix[row - 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                            rowSize - 1 -> {
                                if (compareThree(
                                        matrix[row][column],
                                        matrix[row][column - 1],
                                        matrix[row - 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                            else -> {
                                if (compareFour(
                                        matrix[row][column],
                                        matrix[row][column + 1],
                                        matrix[row][column - 1],
                                        matrix[row - 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                        }
                    }
                    else -> {
                        when (column) {
                            0 -> {
                                if (compareFour(
                                        matrix[row][column],
                                        matrix[row][column + 1],
                                        matrix[row - 1][column],
                                        matrix[row + 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                            rowSize - 1 -> {
                                if (compareFour(
                                        matrix[row][column],
                                        matrix[row][column - 1],
                                        matrix[row - 1][column],
                                        matrix[row + 1][column]
                                    )
                                ) {
                                    lowPoints.add(res)
                                }
                            }
                            else -> {
                                if (compareFive(
                                        matrix[row][column],
                                        matrix[row][column + 1],
                                        matrix[row][column - 1],
                                        matrix[row - 1][column],
                                        matrix[row + 1][column]
                                    )) {
                                    lowPoints.add(res)
                                }
                            }
                        }
                    }
                }
            }
        }
        val sum = lowPoints.filter { it >= 0 }
        return sum.sum()
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = File("src/day09", "Day09.txt").readText()
    println(part1(input.split("\n"), true))
    println(part2(input.split("\n")))
}