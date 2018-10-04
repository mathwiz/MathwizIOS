package pattern.creational

abstract class CarPartFactory {
    def partCatalog = [:]

    def make(part) {
        def partClass = partCatalog[part]
        if (partClass == null) {
            throw new IllegalArgumentException("Unknown part: ${part}")
        }
        partClass .newInstance()
    }
}
