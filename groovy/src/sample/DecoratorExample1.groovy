package sample

import pattern.structural.DrawableAsset
import pattern.structural.EnhancedContainerNameAsset
import pattern.structural.RoundedValueAsset

class DecoratorExample1 extends CompositeExample1 {
    def doIt() {
        println("Decorator")
        portfolio .draw()
        println()

        def enhanced = new DrawableAsset(asset: portfolio)
        enhanced .draw()
        println()

        def better = new RoundedValueAsset(asset: trading)
        println("Class of decorator: " + better .getClass())
        better .draw()
        println(better .value())
        println()

        def morebetter = new DrawableAsset(asset: better)
        println("${better .getClass()} contained in ${better.container.getClass()}")
        println("${morebetter .getClass()} contained in ${morebetter.container.getClass()}")
        println("Value of doubly wrapped: " + morebetter .value())
        morebetter .draw() //does not do rounding. why?
        println()

        def wrapping = new EnhancedContainerNameAsset(asset: trading)
        def morewrapping = new RoundedValueAsset(asset: wrapping)
        def otherway = new EnhancedContainerNameAsset(asset: new RoundedValueAsset(asset: trading))
        println(trading .containerName() + ". value: " + trading .value())
        println(wrapping .containerName() + ". value: " + wrapping .value())
        println(morewrapping .containerName() + ". value: " + morewrapping .value())
        println(otherway .containerName() + ". value: " + otherway .value())
        println()
    }
}
