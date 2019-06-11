package gui.awt.culwin.ch9

class DatePanelResources extends ListResourceBundle {
    static final String[] monthNames = [
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
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
