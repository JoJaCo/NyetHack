package com.bignerdranch.nyethack

fun main(args: Array<String>) {



    val player = PLayer("Madrigal")
    player.castFireball()

//    //anonymous aka lambdas
//    runSimulation()

    //Aura
    val auraColor = player.auraColor()

    //Player status
    printPlayerStatus(player)
    //Aura
    player.auraColor()


    }




    //simLife functions

//    fun runSimulation(){
//        val greetingFunction = configureGreetingFunction()
//        println(greetingFunction("Guyal"))
//        println(greetingFunction("Guyal"))
//    }
//
//    fun configureGreetingFunction(): (String) -> String{
//        val structureType = "hospitals"
//        var numBuildings = 5
//        return{playerName: String ->
//            val currentYear = 2018
//            numBuildings += 1
//            println("Adding $numBuildings $structureType ")
//                    " Welcome to SimVillage, $playerName! (copyright $currentYear)"
//        }

 //   }





    ///Functions
    private fun printPlayerStatus(player: PLayer) {
      println("(Aura: ${player.auraColor()}) " +
           "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
      )
         println("${player.name} ${player.formatHealthStatus()}")

    }





