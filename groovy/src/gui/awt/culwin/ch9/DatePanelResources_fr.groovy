package gui.awt.culwin.ch9

class DatePanelResources_fr extends ListResourceBundle {
    static final String[] monthNames = [
            "Jan", "Fev", "Mar", "Avr", "Mai", "Jun", "Jul", "Auo", "Sep", "Oct", "Nov", "Dec"
    ]

    static final String[] dayNames = [
            "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
    ]

    static final Object[][] contents = [
            ["monthNames", monthNames],
            ["dayNames", dayNames]
    ]

    @Override
    Object[][] getContents() {
        contents
    }
}
