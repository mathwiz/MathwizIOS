package gui.awt.culwin.ch9

import java.text.ChoiceFormat

class ChoiceDemoResources_de extends ListResourceBundle {
    static final double[] limits = [0.0, 0.1, 2.0]
    static final String[] initialPhrases = ["Gab es", "Gab es", "Gab es"]
    static final ChoiceFormat initialFormatter = new ChoiceFormat(limits, initialPhrases)
    static final String[] finalPhrases = ["Uberweiungen", "Uberwiung", "Uberweiungen"]
    static final ChoiceFormat finalFormatter = new ChoiceFormat(limits, finalPhrases)

    static final Object[][] contents = [
            ["initialFormatter", initialFormatter],
            ["finalFormatter", finalFormatter]
    ]

    @Override
    Object[][] getContents() {
        contents
    }

}
