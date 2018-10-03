package pattern.behavioral

class LetterRouter {
    private static instance
    private Map routes = [:]

    static LetterRouter getInstance() {
        if (instance == null) {
            instance = new LetterRouter()
        }
        instance
    }

    def addRoute(obj, letter) {
        def list = routes[obj]
        if (list == null) {
            routes[obj] = new ArrayList<Letter>()
        }
        routes[obj] .add(letter)
    }

    def send(obj, event, details) {
        def list = routes[obj]
        if (list != null) {
            list .each {
                if (it .event == event) {
                    it .block(details)
                }
            }
        }
    }
}
