package pattern.structural

class PlayerFactory {
    private static PlayerFactory instance
    private Map pool = [:]

    def static getInstance() {
        if (instance == null) {
            instance = new PlayerFactory()
        }
        instance
    }

    def fromMap(map) {
        def p = new Player(map)
        if (pool[p .key] == null) {
            p .isPersistent = false
        }
        pool[p .key] = p
        pool[p .key]
    }
}
