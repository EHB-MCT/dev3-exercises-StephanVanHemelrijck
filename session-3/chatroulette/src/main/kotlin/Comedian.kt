class Comedian(override val name: String): Person(name) {
    override fun talk(){
        tellJoke()
    }
    private fun tellJoke(){
        println("What's the best thing about Switzerland? I don't know, but the flag is a big plus")
    }
}