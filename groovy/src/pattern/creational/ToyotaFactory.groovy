package pattern.creational

class ToyotaFactory extends CarPartFactory {
    ToyotaFactory() {
        partCatalog["chassis"] = ToyotaChassis
        partCatalog["engine"] = ToyotaEngine
        partCatalog["transmission"] = GermanTransmission
    }
}
