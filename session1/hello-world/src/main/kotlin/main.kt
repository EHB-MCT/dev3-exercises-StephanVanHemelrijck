fun main(){
    val classmates: Array<String> = arrayOf("Sam", "Sascha", "Rebecca", "Stephan", "Jens")

    for(classmate in classmates){
        println(greetingClassmates(classmate))
    }

}

fun greetingClassmates(classmate: String): String{
    return "Hello $classmate"
}