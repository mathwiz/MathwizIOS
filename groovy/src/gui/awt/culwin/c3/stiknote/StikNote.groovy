package gui.awt.culwin.c3.stiknote


import java.applet.Applet
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class StikNote extends Applet implements ActionListener {
    StikNoteWindow mainWindow
    ArrayList<NoteWindow> notes = new ArrayList<NoteWindow>()

    @Override
    void actionPerformed(ActionEvent e) {
        String contents = mainWindow.getMessage()
        if (contents.length()>0){
            notes.add(new NoteWindow(contents, this))
            mainWindow.clearMessage()
        }
    }

    void init() {
        mainWindow = new StikNoteWindow(this)
        setFont(new Font("Sans-Serif", Font.PLAIN, 20))
        setBackground(Color.YELLOW)
        setForeground(Color.BLUE)
    }

    static void main(String[] args) {
        def frame = new Frame("StikNote")
        def theInterface = new StikNote()

        theInterface.init()
        frame.add(theInterface, "Center")

        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
