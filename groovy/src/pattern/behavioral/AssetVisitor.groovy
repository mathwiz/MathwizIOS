package pattern.behavioral

abstract class AssetVisitor {

    def visitBond(asset) {
        println("visitBond " + asset)
    }

    def visitFund(asset) {
        println("visitFund " + asset)
    }

    def visitStock(asset) {
        println("visitStock " + asset)
    }

    def visitAccount(asset) {
        println("visitAccount " + asset)
    }

    def visitPortfolio(asset) {
        println("visitPortfolio " + asset)
    }

}
