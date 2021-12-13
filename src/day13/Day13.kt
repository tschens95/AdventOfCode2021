package day13

import java.io.File
import kotlin.math.abs

fun main() {
    val input = File("src/day13", "Day13.txt").readText()
    val testInput = File("src/day13", "Day13_test.txt").readText()
    println(part1(testInput.split("\n")))
    part1(input.split("\n"))
    part2(testInput.split("\n"))
    part2(input.split("\n"))
}


data class FoldPoint(var x: Int, var y: Int)

private fun part1(input: List<String>): Int {
    val foldIndex = input.indexOfFirst { it.startsWith("fold") }
    val pointList = input.subList(0, foldIndex - 1)
    val commandList = input.subList(foldIndex, input.size - 1)

    val foldPointList = pointList.map {
        val coordinateX = it.split(",")[0].toInt()
        val coordinateY = it.split(",")[1].toInt()
        FoldPoint(coordinateX, coordinateY)
    }
    val foldedList = fold(foldPointList, commandList[0])
    return foldedList.size
}

private fun part2(input: List<String>) {
    val foldIndex = input.indexOfFirst { it.startsWith("fold") }
    val pointList = input.subList(0, foldIndex - 1)
    val commandList = input.subList(foldIndex, input.size - 1)

    val foldPointList = pointList.map {
        val coordinateX = it.split(",")[0].toInt()
        val coordinateY = it.split(",")[1].toInt()
        FoldPoint(coordinateX, coordinateY)
    }
    var resultList = foldPointList
    for (command in commandList) {
        resultList = fold(resultList, command)
    }
    val sorted = resultList.sortedWith(compareBy({ it.x }, { it.y }))
    val rowSize = sorted.maxOf { it.y }
    for (i in 0..rowSize) {
        val row = sorted.filter { it.y == i }
        if (row.isNotEmpty()) {
            val colSize = row.maxOf { it.x }
            var printString = ""
            for (colCount in 0..colSize) {
                printString += if (row.any { it.x == colCount }) {
                    "#"
                } else {
                    "."
                }
            }
            println(printString)
        }
    }
}

private fun fold(input: List<FoldPoint>, command: String): List<FoldPoint> {
    val coordinate = command.substringAfter("fold along ").split("=")
    val coordinateDirection = coordinate[0]
    val coordinateValue = coordinate[1].toInt()
    val resultList = input
    for (fp in resultList) {
        when (coordinateDirection) {
            "x" -> {
                if (fp.x > coordinateValue) {
                    val diff = abs(fp.x - coordinateValue)
                    fp.x = coordinateValue - diff
                }
            }
            "y" -> {
                if (fp.y > coordinateValue) {
                    val diff = abs(fp.y - coordinateValue)
                    fp.y = coordinateValue - diff
                }
            }
            else -> null
        }
    }
    return resultList
}