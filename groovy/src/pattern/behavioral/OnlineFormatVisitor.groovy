package pattern.behavioral

import pattern.behavioral.AssetVisitor

class OnlineFormatVisitor extends AssetVisitor {

    def visitBond(asset) {
        super.visitBond(asset)
        "Bond ${asset.name} ${asset.type}"
    }

    def visitFund(asset) {
        super.visitFund(asset)
        "${asset.name} ${asset.sector}"
    }

    def visitStock(asset) {
        super.visitStock(asset)
        "${asset.name} ${asset.sector}"
    }

    def visitAccount(asset) {
        super.visitAccount(asset)
        "${asset.name} ${asset.id}"
    }

    def visitPortfolio(asset) {
        super.visitPortfolio(asset)
        "${asset.name}"
    }

}
