fun main(){
    val stephan = Person("Stephan")
    val pieter = Person("Pieter")
    val persons = arrayOf(stephan,pieter)
    val randomPersons = persons.random()
    println(randomPersons.introduce())
}