package gui.awt.culwin.ch9

import java.text.ChoiceFormat
import java.text.Format
import java.text.MessageFormat

class ChoiceFormatDemo {
    static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY)
        ResourceBundle resources = ResourceBundle.getBundle("gui.awt.culwin.ch9.ChoiceDemoResources")
        ChoiceFormat initialPhrase = resources.getObject("initialFormatter") as ChoiceFormat
        ChoiceFormat finalPhrase = resources.getObject("finalFormatter") as ChoiceFormat

        Integer numberOfTransactions = 0
        println initialPhrase.format(numberOfTransactions) + " " + numberOfTransactions + " " + finalPhrase.format(numberOfTransactions)

        numberOfTransactions = 1
        println initialPhrase.format(numberOfTransactions) + " " + numberOfTransactions + " " + finalPhrase.format(numberOfTransactions)

        numberOfTransactions = 10
        println initialPhrase.format(numberOfTransactions) + " " + numberOfTransactions + " " + finalPhrase.format(numberOfTransactions)
    }
}
