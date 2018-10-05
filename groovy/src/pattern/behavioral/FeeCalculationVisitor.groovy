package pattern.behavioral

import pattern.behavioral.AssetVisitor

class FeeCalculationVisitor extends AssetVisitor {

    def visitBond(asset) {
        super.visitBond(asset)
        asset.value() * 0.0001
    }

    def visitFund(asset) {
        super.visitFund(asset)
        asset.value() * 0.004
    }

    def visitStock(asset) {
        super.visitStock(asset)
        asset.value() * 0.0005
    }

    def visitAccount(asset) {
        super.visitAccount(asset)
        0.0
    }

    def visitPortfolio(asset) {
        super.visitPortfolio(asset)
        0.0
    }

}
