class Chatbot(name: String): ChatPartner {
    override fun introduce(){
        println("Hi! I'm Clippy!")
    }
    override fun talk(){
        println("...Beep boop...")
    }
}