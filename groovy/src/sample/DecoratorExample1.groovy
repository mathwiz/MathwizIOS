package sample

import pattern.structural.DrawableAsset

class DecoratorExample1 extends CompositeExample1 {
    def doIt() {
        portfolio .draw()

        def enhanced = new DrawableAsset(asset: portfolio)
        enhanced .draw()
    }
}
