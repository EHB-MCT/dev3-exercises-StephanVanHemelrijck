import kotlin.random.Random

fun main(){
    var options: Array<String> = arrayOf("Rock", "Paper", "Scissors")

    val randomNumber = Random.nextInt(0,2)
    println("Random number is $randomNumber")
    var randomChoiceComputer = ""
    var stringPC = "Computer randomly chose"

    println("Pick an option between Rock, Paper or Scissors")
    val userChoice = readLine()
    println("You chose $userChoice")

    when(randomNumber){
        0 -> {
            print("$stringPC ${options[0]}" )
            randomChoiceComputer == options[0]
        }
        1 ->     {
            print("$stringPC ${options[1]}" )
            randomChoiceComputer == options[1]
        }
        2 -> {
            print("$stringPC ${options[2]}")
            randomChoiceComputer == options[2]
        }
    }

        /*
        Win scenarios:
        Result = 0

        Paper > Rock
        Rock > Scissors
        Scissors > Paper

        Loss scenarios:
        Result = 1

        Rock < Paper
        Scissors < Rock
        Paper < Scissors

        Draw scenarios:
        Result = 2

        Rock = Rock
        Scissors = Scissors
        Paper = Paper
        */

    if (randomChoiceComputer == "Paper" && userChoice == "Rock") {
        printWinner(0)
    }else if (randomChoiceComputer == "Rock" && userChoice == "Scissors") {
        printWinner(0)
    }else if (randomChoiceComputer == "Scissors" && userChoice == "Paper"){
        printWinner(0)
    }else if (randomChoiceComputer == "Paper" && userChoice == "Scissors"){
        printWinner(1)
    }else if (randomChoiceComputer == "Rock" && userChoice == "Paper"){
        printWinner(1)
    }else if (randomChoiceComputer == "Scissors" && userChoice == "Rock"){
        printWinner(1)
    }else if (randomChoiceComputer == "Paper" && userChoice == "Paper"){
        printWinner(2)
    }else if (randomChoiceComputer == "Rock" && userChoice == "Rock"){
        printWinner(2)
    }else if (randomChoiceComputer == "Scissors" && userChoice == "Scissors"){
        printWinner(2)
    }
    print("test")
}

private fun printWinner(result: Int){

    when (result) {
        0 -> print("You lost!")
        1 -> print("You won!")
        2 -> print("You drew!")
    }

}