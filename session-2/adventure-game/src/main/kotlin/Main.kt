fun main(){
    println("Do you have what it takes to clutch up in Apex Legends?")
    challengeOne(hasFleed = false)
//    challengeTwo()
    challengeThree()
}

fun challengeOne(hasFleed: Boolean){

    if (hasFleed){
        println("You ran away from a fight, both your teammates followed you, you are low on shields and hp")
    }else{
        println("You just got out a fight, both your teammates are down, you are down to 20HP, and you hear another team approaching ready to 3rd party you.")
    }
        println("What do you do?")
        val optionsMap = mapOf("A" to "I run back to a dead body and swap their armor and take their gun if needed"
            , "B" to "I try to find some heals, I'm sure I'll have enough time until another team shows up."
            ,"C" to "I'll fight on low hp and hope for the best.")
        println("A) ${optionsMap["A"]}")
        println("B) ${optionsMap["B"]}")
        println("C) ${optionsMap["C"]}")

        var userChoice : String
        do {
            println("Please choose between A, B or C")
            userChoice = readLine()!!
        } while (!optionsMap.containsKey(userChoice))
        determineResultChallengeOne(userChoice, hasFleed)

}

fun challengeTwo(){
    println("We will ask you to predict the outcome of a dice roll." +
            "this dice will represent how many teams will be contesting your drop spot.")
    val diceOptions = arrayOf("low","high")
    var userChoice : String
    do {
        println("You get to choose between low (1,2,3) or high (4,5,6)")
        userChoice = readLine()!!
    }while (!diceOptions.contains(userChoice))
    determineResultChallengeTwo(userChoice)
}

fun challengeThree(){
    println("You have just landed in the streamer building in \"Fragment East\"")
    println("On the ground you see an eva-8 and a havoc")

    val optionsGuns = mapOf("A" to "I pick up the havoc", "B" to "I pick up the eva-8", "C" to "I start punching the person 50/50ing me")
    var userChoice : String

    println("You are getting 50/50d, what do you do?")
    println("A) ${optionsGuns["A"]}")
    println("B) ${optionsGuns["B"]}")
    println("C) ${optionsGuns["C"]}")
    
    do {
        println("Choose between A, B or C")
        userChoice = readLine()!!
    } while (!optionsGuns.containsKey(userChoice))
    determineResultChallengeThree(userChoice)
}

fun challengeFour(){}

fun determineResultChallengeOne(choice: String, hasFleed: Boolean){
    when(choice){
        "A" -> if (hasFleed){
            println("It was too risky to get back to a dead body, another team was still looting them, and they killed you.")
        }else{
            println("You shield swapped and were ready to deal the initial damage to the 3rd party and scared them off.")
        }
        "B" -> if (hasFleed){
            println("You got away successfully, and were able to loot a different POI")
        }else{
            println("You didn't have enough time to pop your phoenix kit and get killed in the process.")
        }
        "C" -> println("You tried to fight another team on low hp, but died.")
    }
}

fun determineResultChallengeTwo(choice: String){
    val diceLows = setOf(1,2,3)
    val diceHighs = setOf(4,5,6)
    val randomNr = rollDice()

    println("You chose $choice and the dice rolled $randomNr")

    when(choice){
        "low" -> if (diceLows.contains(randomNr)){
            println("\tYou're correct, which means there is \n\t a low amount of teams contesting your drop spot")
        }else if (diceHighs.contains(randomNr)){
            println("\tYou're wrong, which means there is \n\t a high amount of teams contesting your drop spot")
        }
        "high" -> if (diceHighs.contains(randomNr)){
            println("\tYou're correct, which means there is \n\t a high amount of teams contesting your drop spot")
        }else if (diceLows.contains(randomNr)){
            println("\tYou're wrong, which means there is \n\t a low amount of teams contesting your drop spot")
        }
    }
}

fun determineResultChallengeThree(choice: String){
    when(choice){
        "A" -> {
            println("You picked up the havoc, but because of the havoc's charging time you lose the fight.")
            gameOver() // Failed
        }
        "B" -> {
            println("You picked up the eva-8, you killed the person 50/50ing you because he couldn't shoot back in time")
            challengeFour() // Succeeded
        }
        "C" -> {
            println("You start punching him, but quickly realize you wont be able to kill him, so you run away")
            val hasFleed = true
            challengeOne(hasFleed) // Flee
        }

    }
}

fun rollDice(): Int{
    return (1..6).random()
}

fun gameOver(){

}
