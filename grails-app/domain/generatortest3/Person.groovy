package generatortest3

class Person {
    String name

    static constraints = {
    }

    static mapping = {
        id(generator: 'sequence')
    }
}