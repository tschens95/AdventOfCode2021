package day06

import readInput
import java.io.File

fun main() {

    fun part1(input: List<String>): Int {
        var resultList = input.map { it.toInt() }.toMutableList()
        var i = 0
        while (i < 256) {
            val queueList = mutableListOf<Int>()
            resultList = resultList.map {
                if (it == 0) {
                    queueList.add(8)
                    6
                } else {
                    it-1
                }
            }.toMutableList()
            for (item in queueList) {
                resultList.add(item)
            }
            i++
        }
        return resultList.size
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = File("src/day06", "Day07.txt").readText()
    println(part1(input.split(",")))
    println(part2(readInput("06")))
}