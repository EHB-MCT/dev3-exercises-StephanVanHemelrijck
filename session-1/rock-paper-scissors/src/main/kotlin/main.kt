fun main(){
    val options: Array<String> = arrayOf("Rock", "Paper", "Scissors")
    val computerChoice = options.random()
    val userChoice = getUserChoice(options)

    println("User picked \"$userChoice\"")
    println("Computer picked \"$computerChoice\"")
    determineWinner(computerChoice, userChoice)
}

fun getUserChoice(options: Array<String>): String {
    var userChoiceObtained:String = ""
    do {
        println("Chose between Rock / Paper / Scissors")
        userChoiceObtained = readLine().toString()
    }while (!options.contains(userChoiceObtained))
    return  userChoiceObtained
}

fun determineWinner(computerChoice: String, userChoice: String){

    // Tied game
    if(computerChoice == userChoice){
        print("You tied!")
    }

    // Win or lose
    when(computerChoice){
        "Rock" -> if (userChoice == "Paper"){
            println("You won!")
        }else if (userChoice == "Scissors"){
            println("You lost!")
        }
        "Paper" -> if (userChoice == "Rock") println("You lost!") else if (userChoice == "Scissors") println("You won!")
        "Scissors" -> if (userChoice == "Paper") println("You lost!") else if (userChoice == "Rock") println("You won!")
    }
}