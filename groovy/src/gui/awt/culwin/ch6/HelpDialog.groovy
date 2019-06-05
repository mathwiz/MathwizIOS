package gui.awt.culwin.ch6

import gui.awt.culwin.MessageCanvas

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class HelpDialog extends Dialog implements ActionListener, ItemListener {
    private static final FILE = "File"
    private static final MOVE = "Move"
    private static final TURN = "Turn"
    private static final COLOR = "Color"
    private static final SCREEN = "Screen"

    private static final FILE_MESSAGE = "The File menu contains a single option Exit...\n" +
            "which will post a dialog to the screen when \n" +
            "it is selected.\n\n" +
            "The dialog asks if you are sure? If you press no\n" +
            "the dialog will disappear. If you press yes the\n" +
            "program will terminate."
    private static final MOVE_MESSAGE = ""
    private static final TURN_MESSAGE = ""
    private static final COLOR_MESSAGE = ""
    private static final SCREEN_MESSAGE = ""

    Panel helpControl
    CheckboxGroup theGroup
    Checkbox fileHelp
    Checkbox moveHelp
    Checkbox turnHelp
    Checkbox colorHelp
    Checkbox screenHelp

    Panel helpPanel
    CardLayout manager
    MessageCanvas fileHelpMessage
    MessageCanvas moveHelpMessage
    MessageCanvas turnHelpMessage
    MessageCanvas colorHelpMessage
    MessageCanvas screenHelpMessage

    Window parentWindow
    Panel buttonPanel
    Button okButton

    HelpDialog(Frame frame) {
        super(frame, "Help", false)
        this.setFont(parent.getFont())
        this.setBackground(parent.getBackground())
        parentWindow = parent as Window

        helpControl = new Panel()
        helpControl.setBackground(Color.WHITE)

        theGroup = new CheckboxGroup()
        fileHelp = new Checkbox(FILE, theGroup, true)
        fileHelp.addItemListener(this)
        helpControl.add(fileHelp)

        moveHelp = new Checkbox(MOVE, theGroup, false)
        moveHelp.addItemListener(this)
        helpControl.add(moveHelp)

        turnHelp = new Checkbox(TURN, theGroup, false)
        turnHelp.addItemListener(this)
        helpControl.add(turnHelp)

        colorHelp = new Checkbox(COLOR, theGroup, false)
        colorHelp.addItemListener(this)
        helpControl.add(colorHelp)

        screenHelp = new Checkbox(SCREEN, theGroup, false)
        screenHelp.addItemListener(this)
        helpControl.add(screenHelp)

        manager = new CardLayout()
        helpPanel = new Panel()
        helpPanel.setBackground(Color.WHITE)
        helpPanel.setLayout(manager)

        fileHelpMessage = new MessageCanvas(FILE_MESSAGE)
        helpPanel.add(fileHelpMessage, FILE)

        moveHelpMessage = new MessageCanvas(MOVE_MESSAGE)
        helpPanel.add(moveHelpMessage, FILE)

        turnHelpMessage = new MessageCanvas(TURN_MESSAGE)
        helpPanel.add(turnHelpMessage, FILE)

        colorHelpMessage = new MessageCanvas(COLOR_MESSAGE)
        helpPanel.add(colorHelpMessage, FILE)

        screenHelpMessage = new MessageCanvas(SCREEN_MESSAGE)
        helpPanel.add(screenHelpMessage, FILE)

        buttonPanel = new Panel()
        buttonPanel.setBackground(Color.WHITE)

        okButton = new Button("ok")
        okButton.setActionCommand("ok")
        okButton.addActionListener(this)
        buttonPanel.add(okButton)

        this.add(buttonPanel, "South")
        this.pack()
    }


    void setVisible(boolean showIt) {
        Point loc = new Point()
        Point parentLoc = parentWindow.getLocationOnScreen()
        Dimension parentSize = parentWindow.getSize()
        if (showIt) {
            loc.x = parentLoc.x + parentSize.width / 2 - this.getSize().width / 2
            loc.y = parentLoc.y + parentSize.height / 2 - this.getSize().height / 2
            this.setLocation(loc)
        }
        super.setVisible(showIt)
    }

    @Override
    void actionPerformed(ActionEvent actionEvent) {
        this.setVisible(false)
    }

    @Override
    void itemStateChanged(ItemEvent itemEvent) {

    }
}
