package gui.awt.culwin.ch9

import java.text.*

class MessageDemoResources_de extends ListResourceBundle {
    static final double[] limits = [0, 1, 2]
    static final String[] initialPhrases = ["Gab es", "Gab es", "Gab es"]
    static final ChoiceFormat initialFormatter = new ChoiceFormat(limits, initialPhrases)
    static final String[] finalPhrases = ["Uberweiungen", "Uberwiung", "Uberweiungen"]
    static final ChoiceFormat finalFormatter = new ChoiceFormat(limits, finalPhrases)
    static final Format[] formatters = new Format[5]

    static {
        formatters[0] = DateFormat.getTimeInstance(DateFormat.MEDIUM)
        formatters[1] = DateFormat.getDateInstance(DateFormat.FULL)
        formatters[2] = NumberFormat.getInstance()
        formatters[3] = finalFormatter
        formatters[4] = NumberFormat.getCurrencyInstance()
    }

    static final MessageFormat generator = new MessageFormat("Am {0} on {0} \ngab es {1} {1} totaliert {2}.")

    static final Object[][] contents = [
            ["formatters", formatters],
            ["generator", generator]
    ]

    @Override
    Object[][] getContents() {
        contents
    }

}
