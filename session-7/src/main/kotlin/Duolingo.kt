class Duolingo(
    val roundSize: Int = 5,
    val language: String = "English"
) {
    var words = mutableListOf<Word>(
        EnglishWords("Parents", "Ouders"),
        EnglishWords("Jewel", "Juweel"),
        EnglishWords("Path", "Pad"),
        EnglishWords("Battlefield", "Slagveld"),
        EnglishWords("Tower", "Toren"),
        EnglishWords("Solution", "Oplossing"),
        EnglishWords("Crouch", "Buk"),
        EnglishWords("Speed", "Snelheid"),
        EnglishWords("Bacon", "Spek"),
        EnglishWords("Weight", "Gewicht"),

        SpanishWords("Padres", "Ouders"),
        SpanishWords("Tafel", "Mesa"),
        SpanishWords("Suelo", "Grond"),
        SpanishWords("Helado", "Ijsje"),
        SpanishWords("Tigre", "Tijger"),
        SpanishWords("Queso", "Kaas"),
        SpanishWords("Horno", "Oven"),
        SpanishWords("Jamón", "Hesp"),
        SpanishWords("Mar", "Zee"),
        SpanishWords("Naranja", "Appelsien"),
    )
    init { words = words.filter { it.language == language }.toMutableList()
    }
    fun play(){
        val currentWords = words.shuffled().take(roundSize).toMutableSet()

        println(currentWords.count())

        while (currentWords.isNotEmpty()) {
            val selectedWord = currentWords.random()
            println("Wat is de vertaling van ${selectedWord.original}")
            val userAnswer = readLine()

            if(selectedWord.translated == userAnswer) {
                println("Correct! ${selectedWord.original} vertaald uit het ${selectedWord.language} betekent ${selectedWord.translated}")
                currentWords.remove(selectedWord)
            }else{
                println("Jammer, maar het is fout... ${selectedWord.original} vertaald uit het ${selectedWord.language} betekent ${selectedWord.translated}")
            }
            println("Aantal woorden: ${currentWords.count()}")
        }
    }
}