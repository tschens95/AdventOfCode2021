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
                val currentMW = MeasurementWindow(intList[i], intList[i+1], intList[i+2])
                val nextMW = MeasurementWindow(intList[i+1], intList[i+2], intList[i+3])
                if (currentMW.sum() < nextMW.sum()) {
                    counter++
                }
            }
        }
        return counter
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

class MeasurementWindow(
    private val a: Int,
    private val b: Int,
    private val c: Int
) {

    fun sum() = a + b + c
}
