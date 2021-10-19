open abstract class Person(open val name: String): ChatPartner {
    override fun introduce(){
        println("Hi! I am $name")
    }
    override fun talk(){}
}