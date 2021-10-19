fun main(){
    val stephan = Student("Stephan")
    val pieter = Comedian("Pieter")
    val mike = Teacher("Mike")
    val persons = arrayOf(stephan,pieter,mike)
    val randomPerson = persons.random()
    randomPerson.introduce()
    randomPerson.talk()
}