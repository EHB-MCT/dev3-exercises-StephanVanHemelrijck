fun main(){
    println("Do you have what it takes to clutch up in Apex Legends?")
    challengeOne(hasFleed = false)
}

fun challengeOne(hasFleed : Boolean = false){

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
            "\nThis dice will represent how many teams are currently close to you")
    val diceOptions = arrayOf("low","high")
    var userChoice : String
    do {
        println("You get to choose between low (1,2,3) or high (4,5,6)")
        userChoice = readLine()!!
    }while (!diceOptions.contains(userChoice))
    determineResultChallengeTwo(userChoice)
}

fun challengeThree(){
    println("You hear shots nearby, so you run towards it ready to third party")

    val optionsGuns = mapOf("A" to "Havoc + Sentinel", "B" to "Wingman + R99", "C" to "Eva-8 + Bow")
    var userChoice : String

    println("What loadout are you using?")
    println("\tA) ${optionsGuns["A"]}")
    println("\tB) ${optionsGuns["B"]}")
    println("\tC) ${optionsGuns["C"]}")

    do {
        println("Choose between A, B or C")
        userChoice = readLine()!!
    } while (!optionsGuns.containsKey(userChoice))
    determineResultChallengeThree(userChoice)
}

fun challengeFour(){
    val number = 67
    var userChoice : Int

    do {
        do {
            println("Guess a number between 1 and 100")
            userChoice = readLine()!!.toInt()
            if(userChoice <= 0 || userChoice >= 100 ) {
                println("Think about the damage you did with your wingman")
                println("You didn't choose a number between 1 and 100, you moron!")
            }
        }while (userChoice <= 0 || userChoice >= 100)
            if (userChoice > number){
              println("The number you're trying to guess is smaller")
            }else if(userChoice < number){
              println("The number you're trying to guess is bigger")
            }else if(userChoice == number){
              println("You guessed it right!")
              challengeFive()
            }
    }while (userChoice != number && (userChoice > 0 || userChoice < 101))
}

fun challengeFive(){
    val options = mutableSetOf("xepa","ndlgees","mhapionc")
    val optionsCorrect = mutableSetOf("apex","legends","champion")
    var teller = 0
    do{
        val randomAnagram = options.random()
        println("You have been given this anagram: \n$randomAnagram")
        val indexPos = options.indexOf(randomAnagram)
        val elementAtIndex = optionsCorrect.elementAt(indexPos)
        options.remove(randomAnagram)
        optionsCorrect.remove(elementAtIndex)
        println("Solve it. You have ${3-teller} chances.")
        val userChoice = readLine()!!
       if (userChoice == elementAtIndex){
           teller = 3
           gameWon()
       }else{
           if (teller == 2){
               gameOver()
           }
        teller++
       }
    }while(teller != 3)

}

fun determineResultChallengeOne(choice: String, hasFleed: Boolean){
    when(choice){
        "A" -> if (hasFleed){
            println("It was too risky to get back to a dead body, another team was still looting them, and they killed you.")
            gameOver()
        }else{
            println("You shield swapped and were ready to deal the initial damage to the 3rd party and scared them off.")
            challengeTwo()
        }
        "B" -> if (hasFleed){
            println("You got away successfully, and were able to run to a different POI")
            challengeTwo()
        }else{
            println("You didn't have enough time to pop your phoenix kit and get killed in the process.")
            gameOver()
        }
        "C" -> {
            println("You tried to fight another team on low hp, but died.")
            gameOver()
        }
    }
}

fun determineResultChallengeTwo(choice: String){
    val diceLows = setOf(1,2,3)
    val diceHighs = setOf(4,5,6)
    val randomNr = rollDice()

    println("You chose $choice and the dice rolled $randomNr")

    when(choice){
        "low" -> if (diceLows.contains(randomNr)){
            println("You're correct, which means there is a low amount of teams nearby")
        }else if (diceHighs.contains(randomNr)){
            println("You're wrong, which means there is a high amount of teams nearby")
        }
        "high" -> if (diceHighs.contains(randomNr)){
            println("You're correct, which means there is a high amount of teams nearby")
        }else if (diceLows.contains(randomNr)){
            println("You're wrong, which means there is a low amount of teams nearby")
        }
    }
    challengeThree()
}

fun determineResultChallengeThree(choice: String){
    when(choice){
        "A" -> {
            println("You picked up the Havoc and Sentinel, but because of the havoc's charging time you lose the fight.")
            gameOver() // Failed
        }
        "B" -> {
            println("You picked up the Wingman and R99, you nearly 1 clipped an octane with your R99\n,he launch padded away but you finished him off with a 67dmg headshot with your wingman")
            challengeFour() // Succeeded
        }
        "C" -> {
            println("You picked up the Eva-8 and the Bow, but quickly find yourself running out of shotgun ammo so you run away.")
            challengeOne(hasFleed = true) // Flee
        }
    }
}

fun rollDice(): Int{
    return (1..6).random()
}

fun gameOver(){
    println("You died, Game over!")
    askToPlayAgain()
}

fun gameWon(){
    println("Winner Winner Chicken Dinner!\nDo you want to play again?")
    askToPlayAgain()
}

fun askToPlayAgain(){
    val options = arrayOf("Yes","No")
    var userChoice : String

    do {
        println("Do you want to play again?")
        userChoice = readLine()!!
    }while (!options.contains(userChoice))
    if (userChoice == "Yes"){
        challengeOne()
        println("Restarting the game.")
    }else if (userChoice == "No"){
        print("Thanks for playing!")
    }
}