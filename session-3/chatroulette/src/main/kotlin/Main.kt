fun main(){
    val stephan = Student("Stephan")
    val pieter = Comedian("Pieter")
    val mike = Teacher("Mike")
    val clippy = Chatbot("Clippy")
    val persons = arrayOf(stephan,pieter,mike,clippy)
    val randomPerson = persons.random()
    println("Starting Chatroulette...")
    randomPerson.introduce()
    randomPerson.talk()
}