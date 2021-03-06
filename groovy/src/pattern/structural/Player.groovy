package pattern.structural

class Player extends Persistable {
    private def name, pos
    def points, salary

    def getKey() {
        name
    }

    boolean equals(player) {
        player?.key == this.key
    }

    int hashCode() {
        this.key .hashCode()
    }
}
