class Teacher(override val name: String): Person(name) {
    override fun talk(){
        funFact()
    }
    private fun funFact(){
        println("Did you know that the first oranges weren't actually orange?")
    }
}