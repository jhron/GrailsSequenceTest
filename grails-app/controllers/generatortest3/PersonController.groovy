package generatortest3

class PersonController {

    def create() {
        render "Before transaction number of persons=${Person.list().size()}<br/>\n"
        Person.withTransaction { status ->
            for (def i=0; i<=100; i++) {
                def p = new Person(name: "IName${i}")
                p.save(flush: true)
            }
            render "Doing rollback<br/>\n"
            status.setRollbackOnly()
        }
        render "After transaction number of persons=${Person.list().size()}<br/>\n"
    }

    def index() {
        render "Number of persons=${Person.list().size()}"
    }
}