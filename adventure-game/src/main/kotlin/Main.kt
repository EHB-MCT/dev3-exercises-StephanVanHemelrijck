fun main(){
    println("Do you have what it takes to clutch up in Apex Legends?")
    challengeOne()
}

fun challengeOne(){
    println("Challenge one initiated")
    println("In this challenge we will be putting you in a 1v3 situation.")
    println("You just got out a fight, both your teammates are down, \n\t you are down to 20HP, and you hear another team \n\t approaching ready to 3rd party you.")
    println("What do you do first?")

    val optionsMap = mapOf("A" to "I shield swap as fast as possible with someone \n\t that got killed in the previous fight"
        , "B" to "I try to take a phoenix kit, I'm sure I'll have enough \n\t time untill the 3rd party shows up."
        ,"C" to "I'll take a 1v3 on 20HP and hope for the best.")
    println("A) ${optionsMap["A"]}")
    println("B) ${optionsMap["B"]}")
    println("C) ${optionsMap["C"]}")

    var userChoice : String?
    do {
        println("Please chose between A, B or C")
        userChoice = readLine()
    } while (!optionsMap.containsKey(userChoice))
        determineResult(userChoice)
}

fun determineResult(choice: String?){
    println("Je hebt voor situatie ${choice} gekozen.")
}