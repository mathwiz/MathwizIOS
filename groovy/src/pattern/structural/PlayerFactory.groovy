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
            pool[p .key] = p
        } else {
            pool[p .key] = p
            p .isPersistent = true
        }
        pool[p .key]
    }

    def get(player) {
        if (pool[player .key] == null) {
            player .isPersistent = false
        } else {
            player .isPersistent = true
        }
        pool[player .key]
    }
}
