package sample

import pattern.structural.DrawableAsset
import pattern.structural.RoundedValueAsset

class DecoratorExample1 extends CompositeExample1 {
    def doIt() {
        portfolio .draw()
        println()

        def enhanced = new DrawableAsset(asset: portfolio)
        enhanced .draw()
        println()

        def better = new RoundedValueAsset(asset: trading)
        println(better .getClass())
        better .draw()
        println(better .value())
        println()

        def morebetter = new DrawableAsset()
        println(better .getClass())
        println(morebetter .getClass())
        morebetter.asset = better
        morebetter .draw() //does not do rounding. why?
        println()
    }
}
