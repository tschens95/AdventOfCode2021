package day07

import java.io.File
import kotlin.math.abs

fun main() {

    fun part1(input: List<String>, part1: Boolean): Int {
        val resultList = input.map { it.toInt() }.toMutableList()
        println(resultList.size)
        val sortedList = resultList.sorted()
        val median = sortedList.let { (it[it.size / 2] + it[(it.size - 1) / 2]) / 2 }
        println(median)
        val distances = resultList.map { abs(median - it) }
        println(distances)
        return if (part1) {
            distances.sum()
        } else {
            median
        }
    }

    fun part2(input: List<String>): Int {
        // binäre Suche
        val resultList = input.map { it.toInt() }.toMutableList()
        val sum: Int = Int.MAX_VALUE
        val median = part1(input, false)
        println(median)
        val distances = resultList.map { val d = abs(median - it); (d*(d+1)) / 2 }
        println(resultList)
        println(distances)
        return distances.sum()
    }

    val input = File("src/day07", "Day07.txt").readText()
    println(part1(input.split(","), true))
    println(part2(input.split(",")))
}