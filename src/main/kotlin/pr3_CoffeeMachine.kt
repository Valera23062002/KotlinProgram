class CoffeeMachine(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var beans: Int = 120,
    private var cups: Int = 9,
    private var money: Int = 550
){
    fun remaining(){
        println("The coffee machine has:\n" +
                    "$water of water\n" +
                    "$milk of milk\n" +
                    "$beans of coffee beans\n" +
                    "$cups of disposable cups\n" +
                    "$money of money")
    }
    private fun makingCoffee(wNeed: Int, mNeed: Int, bNeed: Int, cost: Int){
        when{
            water < wNeed -> println("Sorry, not enough water!")
            beans < bNeed -> println("Sorry, not enough coffee beans!")
            milk < mNeed -> println("Sorry, not enough coffee beans!")
            cups < 1 -> println("Sorry, not enough disposable cups!")
            else -> {
                println("I have enough resources, making you a coffee!")
                water -= wNeed
                beans -= bNeed
                milk -= mNeed
                cups --
                money += cost
            }
        }
    }

    fun buy(type: String) {
        when (type) {
            "1" -> makingCoffee(250, 0, 16, 4)
            "2" -> makingCoffee(350, 75, 20, 7)
            "3" -> makingCoffee(200, 100, 12, 6)
            "back" -> return
            else -> println("Invalid choice!")
        }
    }

    fun fill(wAdd: Int, mAdd: Int, bAdd: Int, cAdd: Int){
        water += wAdd
        milk += mAdd
        beans += bAdd
        cups += cAdd
    }

    fun take(){
        println("I gave you $money")
        money = 0
    }
}

fun main(){
    val coffeeMachine = CoffeeMachine()
    while (true){
        println("Write action (buy, fill, take, remaining, exit): ")
        when (readln()) {
            "remaining" -> coffeeMachine.remaining()
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                coffeeMachine.buy(readln())
                }
            "fill" -> {
                try {
                    println("Write how many ml of water you want to add:")
                    val addWater = readln().toInt()
                    println("Write how many ml of milk you want to add:")
                    val addMilk = readln().toInt()
                    println("Write how many grams of coffee beans you want to add:")
                    val addCoffeeBeans = readln().toInt()
                    println("Write how many disposable coffee cups you want to add:")
                    val addCups = readln().toInt()
                    coffeeMachine.fill(addWater, addMilk, addCoffeeBeans, addCups)
                }
                catch (e: NumberFormatException){
                    println("Invalid input! Please enter a number.")
                }
            }
            "take" -> coffeeMachine.take()
            "exit" -> break
        }
    }
}