package gui.awt.culwin.ch9

import java.text.Format
import java.text.MessageFormat

class MessageFormatDemo {
    static void main(String[] args) {
        Date theDate = new GregorianCalendar(1999, 11, 31, 20, 20).getTime()
        Integer numberOfTransactions = 1234
        Double amountTaken = 1234.56
        Object[] arguments = [theDate, numberOfTransactions, amountTaken]

        Locale.setDefault(Locale.GERMANY)
        ResourceBundle resources = ResourceBundle.getBundle("gui.awt.culwin.ch9.MessageDemoResources")
        MessageFormat generator = resources.getObject("generator") as MessageFormat
        Format[] formatters = resources.getObject("formatters") as Format[]

        generator.setFormats(formatters)
        println generator.format(arguments)
    }
}
