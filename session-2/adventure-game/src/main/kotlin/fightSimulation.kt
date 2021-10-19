import java.security.Key

class fightSimulation(
    val optionsMap: Map<String, out String>,
    val hasFleed: Boolean = false
) {
    fun run(){
        printChallenge(optionsMap)
        val userInput = getUserInput(optionsMap)
        determineResult(userInput, hasFleed)
    }
    fun printChallenge(optionsMap: Map<String, out String>){
        if (hasFleed){
            println("You ran away from a fight, both your teammates followed you, you are low on shields and hp")
        }else{
            println("You just got out a fight, both your teammates are down, you are down to 20HP, and you hear another team approaching ready to 3rd party you.")
        }
        println("What do you do?")
        println("A) ${optionsMap["A"]}")
        println("B) ${optionsMap["B"]}")
        println("C) ${optionsMap["C"]}")
    }
    fun getUserInput(optionsMap: Map<String, out String>): String{
        var userChoice: String
        do {
            println("Please choose between A, B or C")
            userChoice = readLine()!!
        } while (!optionsMap.containsKey(userChoice))
        return userChoice
    }
    fun determineResult(userChoice: String, hasfleed: Boolean){
        when(userChoice){
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
}