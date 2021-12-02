fun main() {

    fun part1(input: List<String>): Int  {
        val start = System.currentTimeMillis()
        var horizontal = 0
        var depth = 0
        val instructions = input.map { it.split(" ")}
        for (instruction in instructions) {
            val value = instruction[1].toInt()
            when (instruction[0]) {
                "forward" -> horizontal += value
                "down" -> depth += value
                "up" -> depth -= value
            }
        }
        val end = System.currentTimeMillis()
        println("Duration: ${end - start}")
        return horizontal*depth
    }

    fun part2(input: List<String>): Int  {
        val start = System.currentTimeMillis()
        var horizontal = 0
        var depth = 0
        var aim = 0
        val instructions = input.map { it.split(" ")}
        for (instruction in instructions) {
            val value = instruction[1].toInt()
            when (instruction[0]) {
                "forward" -> {
                    horizontal += value
                    depth += (aim * value)
                }
                "down" -> aim += value
                "up" -> aim -= value
            }
        }
        val end = System.currentTimeMillis()
        println("Duration: ${end - start}")
        return horizontal*depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}