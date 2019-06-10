package gui.awt.culwin.ch8


import java.awt.*
import java.awt.event.ActionListener

abstract class TuttleBaseDialog extends Dialog implements ActionListener {
    protected Window itsParentWindow
    protected ActionListener itsListener

    TuttleBaseDialog(Frame parentFrame, ActionListener listener, String title) {
        super(parentFrame, title, true)
        setFont(parentFrame.getFont())
        setBackground(parentFrame.getBackground())
        itsParentWindow = parentFrame as Window
        itsListener = listener
    }

    @Override
    void setVisible(boolean showIt) {
        if (showIt) {
            Point itsParentsLocation

        }
        super.setVisible(showIt)
    }
}
