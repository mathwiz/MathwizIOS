package pattern.creational

class FordFactory extends CarPartFactory {
    FordFactory() {
        partCatalog["chassis"] = FordChassis
        partCatalog["engine"] = FordEngine
        partCatalog["transmission"] = FordTransmission
    }
}
