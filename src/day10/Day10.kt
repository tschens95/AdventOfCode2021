package day10

import java.io.File
import java.util.*

fun main() {

    fun isOpenBracket(c: Char): Boolean {
        return when (c) {
            '(', '{', '<', '[' -> true
            else -> false
        }
    }

    fun isNotClosing(open: Char, close: Char): Boolean {
        return when (open) {
            '(' -> close != ')'
            '{' -> close != '}'
            '[' -> close != ']'
            '<' -> close != '>'
            else -> false
        }
    }

    fun fillStack(s: String): Stack<Char> {
        val stack = Stack<Char>()
        for (c in s.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c)
            } else {
                val currBracket = stack.pop()
                if (isNotClosing(currBracket, c)) {
                    return Stack()
                }
            }
        }
        println(stack)
        return stack
    }

    fun part1(input: List<String>): Int {
        var res = 0;
        for (s in input) {
            val stack = Stack<Char>()
            for (c in s.toCharArray()) {
                if (isOpenBracket(c)) {
                    stack.push(c)
                } else {
                    val currBracket = stack.pop()
                    if (isNotClosing(currBracket, c)) {
                        when (c) {
                            ')' -> res += 3
                            ']' -> res += 57
                            '}' -> res += 1197
                            '>' -> res += 25137
                        }
                    }
                }
            }
        }
        return res
    }

    fun matchBracket(c: Char): Char {
        return when (c) {
            '(' -> ')'
            '{' -> '}'
            '[' -> ']'
            '<' -> '>'
            else -> ' '
        }
    }

    fun bracketValue(c: Char): Int {
        return when (c) {
            ')' -> 1
            ']' -> 2
            '}' -> 3
            '>' -> 4
            else -> 0
        }
    }

    fun calculateScore(closingBrackets: List<Char>): Long {
        return closingBrackets.fold(0L) { acc , c -> acc*5 + bracketValue(c)}
    }

    fun part2(input: List<String>): Long {
        val scoreList = mutableListOf<Long>()
        for (s in input) {
            val stack = fillStack(s)
            if (!stack.isEmpty()) {
                stack.reverse()
                val closingBrackets = stack.map { matchBracket(it) }
                scoreList.add(calculateScore(closingBrackets))
            }

        }
        scoreList.sort()
        val medianIndex = scoreList.size / 2
        return scoreList[medianIndex]
    }


    val input = File("src/day10", "Day10.txt").readText()
    val testInput = File("src/day10", "Day10_test.txt").readText()
    println(part1(testInput.split("\n")))
    println(part1(input.split("\n")))

    println(part2(testInput.split("\n")))
    println(part2(input.split("\n")))
}