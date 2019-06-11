package gui.awt.culwin.ch9

class ExitDialogResources extends ListResourceBundle {
    static final Object[][] contents = [
            ["exitDialogTitle", "Exit"],
            ["exitDialogQuestion", "Are you sure\nyou want to exit?"],
            ["exitDialogYes", "Yes"],
            ["exitDialogNo", "No"]
    ]

    @Override
    Object[][] getContents() {
        contents
    }
}
