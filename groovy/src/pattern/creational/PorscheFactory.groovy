package pattern.creational

class PorscheFactory extends CarPartFactory {
    PorscheFactory() {
        partCatalog["chassis"] = PorscheChassis
        partCatalog["engine"] = PorscheEngine
        partCatalog["transmission"] = GermanTransmission
    }
}
