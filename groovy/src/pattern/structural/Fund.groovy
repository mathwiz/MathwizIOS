package pattern.structural

class Fund extends Security {
    def family, sector, style

    def description() {
        "${family} ${super.description()}: ${sector} - ${style}"
    }
}
