package pattern.structural

class Stock extends Security {
    def sector

    def description() {
        "${super.description()}: ${sector}"
    }
}
