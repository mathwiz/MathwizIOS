package sample

import pattern.behavioral.AndNode
import pattern.behavioral.AttributeNode
import pattern.behavioral.EqualsNode
import pattern.behavioral.OrNode
import pattern.behavioral.ValueNode
import pattern.structural.Bond
import pattern.structural.Fund
import pattern.structural.Stock

class InterpreterExample1 {
    def apple = new Stock(name:"AAPL", id:"CUSIP32382", quantity:2, price:222.42, sector:"Technology")
    def amazon = new Stock(name:"AMZN", id:"CUSIP30082", quantity:1, price:1955.95, sector:"Internet")
    def google = new Stock(name:"GOOG", id:"CUSIP43235", quantity:5, price:1023.62, sector:"Internet")
    def microsoft = new Stock(name:"MSFT", id:"CUSIP43235", quantity:5, price:102.63, sector:"Technology")
    def treasury = new Bond(name:"30 Year", id:"CUSIP997", quantity: 1000, price: 9.324, maturity: 360, type: "US Government")
    def sp500 = new Fund(name:"SP500 Index", id:"CUSIP00021", quantity: 200, price: 32.00, family: "Vanguard", sector: "Index", style: "Large Cap")
    def russell = new Fund(name:"Russell 2000 Index", id:"CUSIP00022", quantity: 200, price: 18.00, family: "Vanguard", sector: "Index", style: "Large Cap")

    def doIt() {
        println(" *** Interpreter")
        println(" ** Retrieving an attribute")
        def result = new AttributeNode(attributeName: "id") .evaluateAgainst(new Bond(name: "30 Treasury", id: "CUSIP0030"))
        println(result)
        println(" ** Query")
        def full_list = [apple, amazon, google, microsoft, sp500, russell, treasury]
        def list = full_list .findAll { it.metaClass.hasProperty(it, 'sector')}

        def internet = new ValueNode(value: "Internet")
        def tech = new ValueNode(value: "Technology")
        def index = new ValueNode(value: "Index")

        def sector = new AttributeNode(attributeName: "sector")

        println("Apple's sector: '${sector .evaluateAgainst(apple)}'")

        def equalsInternet = new EqualsNode(leftChild: sector, rightChild: internet)
        def equalsTech = new EqualsNode(leftChild: sector, rightChild: tech)
        def equalsIndex = new EqualsNode(leftChild: sector, rightChild: index)

        println(" * Technology Stocks")
        list .findAll { equalsTech .evaluateAgainst(it) } .each { println it .name }
        println(" * Internet Stocks")
        list .findAll { equalsInternet .evaluateAgainst(it) } .each { println it .name }
        println(" * Index Funds")
        list .findAll { equalsIndex .evaluateAgainst(it) } .each { println it .name }

        println(" * Technology or Internet Stocks")
        def techOrInternet = new OrNode(leftChild: equalsTech, rightChild: equalsInternet)
        list .findAll { techOrInternet .evaluateAgainst(it) } .each { println it .name }

        println(" * Index Funds or Internet Stocks")
        def indexOrInternet = new OrNode(leftChild: equalsIndex, rightChild: equalsInternet)
        list .findAll { indexOrInternet .evaluateAgainst(it) } .each { println it .name }

        println(" * Index Funds AND Internet Stocks")
        def indexAndInternet = new AndNode(leftChild: equalsIndex, rightChild: equalsInternet)
        list .findAll { indexAndInternet .evaluateAgainst(it) } .each { println it .name }
    }
}
