fun main(){
    println("Do you have what it takes to clutch up in Apex Legends?")
//    challengeOne()
//    challengeTwo()
    challengeThree()
}

fun challengeOne(){
    println("Challenge one initiated")
    println("In this challenge we will be putting you in a 1v3 situation.")
    println("You just got out a fight, both your teammates are down, you are down to 20HP, and you hear another team approaching ready to 3rd party you.")
    println("What do you do first?")

    val optionsMap = mapOf("A" to "I shield swap as fast as possible with someone that got killed in the previous fight"
        , "B" to "I try to take a phoenix kit, I'm sure I'll have enough time until the 3rd party shows up."
        ,"C" to "I'll take a 1v3 on 20HP and hope for the best.")
    println("A) ${optionsMap["A"]}")
    println("B) ${optionsMap["B"]}")
    println("C) ${optionsMap["C"]}")

    var userChoice : String
    do {
        println("Please choose between A, B or C")
        userChoice = readLine()!!
    } while (!optionsMap.containsKey(userChoice))
    determineResultChallengeOne(userChoice)
}

fun challengeTwo(){
    println("For the second challenge, we will ask you to predict the outcome of a dice roll." +
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

    do {
        println("You are getting 50/50d, what do you do?")
        println("Choose between A, B or C")
        userChoice = readLine()!!
    } while (!optionsGuns.containsKey(userChoice))
    determineResultChallengeThree(userChoice)
}

fun challengeFour(){}

fun determineResultChallengeOne(choice: String){
    when(choice){
        "A" -> println("\tYou shield swapped and were ready to deal the \n\t initial damage to the 3rd party and scared them off.")
        "B" -> println("\tYou didn't have enough time to pop your phoenix kit \n\t and get killed in the process.")
        "C" -> println("\tYou tried to 1v3 the 3rd party on 20HP and died almost instantaneously.")
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
            challengeOne() // Flee
        }

    }
}

fun rollDice(): Int{
    return (1..6).random()
}

fun gameOver(){

}
