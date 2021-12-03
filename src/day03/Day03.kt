package day03

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val length = input.first().length
        val gammaArray = IntArray(length)
        val epsilonArray = IntArray(length)
        for (s in input) {
            for (i in s.indices) {
                when (s[i]) {
                    '0' -> gammaArray[i] += 1
                    '1' -> epsilonArray[i] += 1
                }
            }
        }

        val gamma = CharArray(length) { '0' }
        val epsilon = CharArray(length) { '0' }
        for (i in 0 until length) {
            if (gammaArray[i] > epsilonArray[i]) epsilon[i] = '1' else gamma[i] = '1'
        }

        return gamma.concatToString().toInt(2) * epsilon.concatToString().toInt(2)
    }

    fun commonBits(input: List<String>, index: Int, most: Boolean): Int {
        val length = input.first().length
        val gammaArray = IntArray(length)
        val epsilonArray = IntArray(length)
        for (s in input) {
            for (i in s.indices) {
                when (s[i]) {
                    '0' -> gammaArray[i] += 1
                    '1' -> epsilonArray[i] += 1
                }
            }
        }

        val gamma = CharArray(length) { '0' }
        val epsilon = CharArray(length) { '0' }
        for (i in 0 until length) {
            if (gammaArray[i] > epsilonArray[i]) epsilon[i] = '1' else gamma[i] = '1'
        }
        return if (most) {
            println(gammaArray)
            gammaArray[index]
        } else {
            println(epsilonArray)
            epsilonArray[index]
        }
    }

    fun computeShit(input: List<String>, most: Boolean): List<String> {
        var tempRemainingO2 = input
        val length = input.size
        var index = 0
        while (index < length && tempRemainingO2.size > 1) {
            val commonBit = commonBits(tempRemainingO2, index, most)
            println("CommonBit $commonBit")
            tempRemainingO2 = if (most) {
                tempRemainingO2.filter { it.substring(index).startsWith(commonBit.toString()) }
            } else {
                tempRemainingO2.filter { it.substring(index).startsWith(commonBit.toString()) }
            }

            index++
            println("Index $index")
            println("List size ${tempRemainingO2.size}")
        }
        return tempRemainingO2
    }

    fun part2(input: List<String>): Int {
        println("list 1")
        val resultList1 = computeShit(input, true)
        println("list 2")
        val resultList2 = computeShit(input, false)
        println(resultList1)
        println(resultList2)
        return input.size
    }



    val input = readInput("03")
    println(part1(input))
    println(part2(input))
}