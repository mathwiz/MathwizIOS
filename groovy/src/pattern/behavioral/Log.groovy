package pattern.behavioral

class Log {
    private log = new ArrayList()

    def append(message) {
        log .add(message)
    }

    def replay() {
        log .each { println("Log: $it") }
    }
}
