import java.io.File
import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli","Mordoc","Sophie")
val lastName = listOf("Ironfoot", "Fernsworth","Baggins")
val uniquePatrons = mutableListOf<String>()

val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String,Double>()



fun main(args: Array<String>){
    //checking if person is here
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
    //placeOrder("shandy,Dragon's Breath,5.91")
   //Naming the people
    (0..9).forEach{

        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons +=(name)
    }
    //adding the amount ot each person
    uniquePatrons.forEach { patronGold[it] = 6.0 }

    var orderCount = 0
    while (orderCount <= 9){
       placeOrder(uniquePatrons.shuffled().first(),menuList.shuffled().first())
        orderCount++
    }
    displayPatronBalances()

}
private fun displayPatronBalances(){
    patronGold.forEach{patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

fun performPurchase(price: Double, patronName: String){

    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price

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

private fun placeOrder(patronName: String, menuDate: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")


    val(type,name,price) = menuDate.split(',')
    val message = "$patronName tries to buy a $name ($type) for $price"

    println(message)

    performPurchase(price.toDouble(), patronName)


    val phrase = if (name == "Dragon's Breath"){
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    }else{

        "$patronName says: thanks for the $name"
    }
    println(phrase)

}