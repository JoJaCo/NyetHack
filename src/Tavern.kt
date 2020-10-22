import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli","Mordoc","Sophie")

fun main(args: Array<String>){
    if(patronList.contains("Eli")){ //checking who is in the tavern
        println("---------------------------------------------------------")
        println("The tavern master says: Eli's in the back playing cards.")
        println("---------------------------------------------------------")
    }else{
        println("the tavern master says: Eli isn't here.")
    }
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))){

        println("The tavern master says: yea, they're seated by the stew kettle.")
    }else{
        println("---------------------------------------------------------")
        println("the tavern master says: Nay, they departed hours ago.")
        println("---------------------------------------------------------")
    }
    placeOrder("shandy,Dragon's Breath,5.91")
    println("---------------------------------------------------------")
    println(patronList)
    patronList.remove("Eli")
    patronList.add("Alex")
    println(patronList)



}
fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("---------------------------------------------------------")
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    println("---------------------------------------------------------")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver =  (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}
private fun displayBalance(){
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")){
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "2"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(menuDate: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")


    val(type,name,price) = menuDate.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath"){
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    }else{
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)

}