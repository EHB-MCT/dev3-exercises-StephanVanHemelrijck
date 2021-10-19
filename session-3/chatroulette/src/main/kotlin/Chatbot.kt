class Chatbot(name: String): Person(name) {
    override fun introduce(){
        println("Hi! I'm Clippy!")
    }
    override fun talk(){
        println("...Beep boop...")
    }
}