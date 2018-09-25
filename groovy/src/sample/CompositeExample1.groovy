package sample

import pattern.structural.Account
import pattern.structural.Bond
import pattern.structural.Fund
import pattern.structural.Portfolio
import pattern.structural.Stock

class CompositeExample1 {
    def apple = new Stock(name:"AAPL", id:"CUSIP32382", quantity:2, price:222.42, sector:"Technology - Devices")
    def amazon = new Stock(name:"AMZN", id:"CUSIP30082", quantity:1, price:1955.95, sector:"Technology - Internet")
    def treasury = new Bond(name:"30 Year", id:"CUSIP997", quantity: 1000, price: 9.324, maturity: 360, type: "US Government")
    def sp500 = new Fund(name:"SP500 Index", id:"CUSIP00021", quantity: 200, price: 32.00, family: "Vanguard", sector: "Index", style: "Large Cap")

    def doIt() {
        def retirement = new Account(name: "IRA", id:"Ret323") .add(treasury) .add(sp500)
        def trading = new Account(name: "Brokerage", id:"Broke323") .add(apple) .add(amazon)
        def portfolio = new Portfolio(name: "Yohan Portfolio") .add(retirement) .add(trading)

        println(portfolio)
        println()
        println(retirement)
        println()
        println(trading)
        println()
        println("Retirement contains SP500: ${retirement.containsSecurity(sp500)}")
        println("Trading contains Amazon: ${trading.containsSecurity(amazon)}")
        println("Trading contains SP500: ${trading.containsSecurity(sp500)}")
        println("Portfolio contains SP500: ${portfolio.containsSecurity(sp500)}")
    }
}
