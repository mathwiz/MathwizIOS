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
            Point itsParentsLocation = itsParentWindow.getLocationOnScreen()
            Dimension itsParentsSize = itsParentWindow.getSize()
            Dimension itsSize = this.getSize()
            Point itsLocation = new Point()

            itsLocation.x = itsParentsLocation.x + itsParentsSize.width/2 - itsSize.width/2
            itsLocation.y = itsParentsLocation.y + itsParentsSize.height/2 - itsSize.height/2
            setLocation(itsLocation)
        }
        super.setVisible(showIt)
    }
}
