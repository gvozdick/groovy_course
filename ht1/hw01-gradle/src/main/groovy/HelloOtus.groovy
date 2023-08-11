import com.google.common.collect.Lists

class Main {
    static void main(String[] args) {
        println "Hello world!"
        println "good!"
        List<Character> chars = Lists.charactersOf("hello")
        println(chars.size())
        println(chars)
    }
}