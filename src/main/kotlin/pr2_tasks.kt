import java.util.Calendar
fun taskOne(intNumber: Int) {
    when{
        intNumber % 2 == 0 -> println("Even")
        else -> {println("Odd")}
    }
}

fun taskTwo(number: Int) {
    when {
        number % 2 == 0 -> println("${number * 4}")
        else -> {
            println("${number * 5}")
        }
    }
}
fun taskThree(number: Int){
    println(-number)
}

fun taskFour(year: Int){
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    println("Age: ${currentYear-year}" )
}

fun taskFive(array: IntArray){
    var min = array[0]
    for (i in array) if (i < min) min = i
    println("Minimum number: $min")
}

fun taskSix(array: IntArray) {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    for (i in array){
        if (i > max1){
            max2 = max1
            max1 = i
        }else
            if (i > max2){
                max2 = i
            }
    }
    println("The two largest numbers: $max2, $max1")
}

fun taskSeven(array: IntArray){
    var p = 0
    var n = 0
    for (i in array){
        when{
            i > 0 -> p++
            else -> n += i
        }
    }
    println("Number of positive numbers $p, sum of negative $n")
}

fun taskEight(array: CharArray){
    var i = 0
    for (k in array){
        if (k in setOf('a', 'e', 'i', 'o', 'u', 'y')){
            i++
        }
    }
    println("Number of voice letters $i")
}

fun taskNine(array: String){
    when{
        array.length % 2 == 0 ->
            println("Middle two symbols of a row: ${array.substring(array.length / 2 - 1, array.length / 2 + 1)}")
        else -> println("Middle row symbol: ${array.substring(array.length / 2, array.length / 2 + 1)}")
    }
}

fun taskTen(size: Int): Array<IntArray>{
    val table = Array(size) {IntArray(size)}
    for (i in 0 until size){
        for (j in 0 until size){
            table[i][j] = (i + 1) * (j + 1)
        }
    }
    return table
}

fun main(){
    println("Task 1:")
    taskOne(readln().toInt())

    println("\nTask 2:")
    taskTwo(readln().toInt())

    println("\nTask 3:")
    taskThree(readln().toInt())

    println("\nTask 4:")
    taskFour(readln().toInt())

    println("\nTask 5")
    taskFive(readln().split(" ").map{it.toInt()}.toIntArray())

    println("\nTask 6")
    taskSix(readln().split(" ").map{it.toInt()}.toIntArray())

    println("\nTask 7")
    taskSeven(readln().split(" ").map{it.toInt()}.toIntArray())

    println("\nTask 8")
    taskEight(readln().toCharArray())

    println("\nTask 9")
    taskNine(readln())

    println("\nTask 10")
    println(taskTen(readln().toInt()).contentDeepToString())
}
