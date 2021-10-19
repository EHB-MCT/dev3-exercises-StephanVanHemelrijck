open abstract class Person(open val name: String) {
    fun introduce(){
        println("Hi! I am $name")
    }
    open fun talk(){}
}