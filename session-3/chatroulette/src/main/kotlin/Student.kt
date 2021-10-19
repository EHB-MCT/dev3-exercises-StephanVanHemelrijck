class Student(override val name: String): Person(name), ChatPartner {
    override fun talk(){
        gossip()
    }
    private fun gossip(){
        println("This is supposed to be some gossip")
    }
}