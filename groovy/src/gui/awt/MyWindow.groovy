package gui.awt

import java.awt.*
import java.awt.event.*

class MyWindow {
    Frame mainFrame
    Label headerLabel, statusLabel, msgLabel
    Panel controlPanel

    MyWindow() { prepareGUI() }

    def prepareGUI() {
        mainFrame = new Frame("Java AWT Examples")
        mainFrame .setSize(400, 400)
        mainFrame .setLayout(new GridLayout(3, 1))
        mainFrame .addWindowListener({ windowEvent -> System.exit(0) } as WindowListener)

        headerLabel = new Label()
        headerLabel .setAlignment(Label.CENTER)

        statusLabel = new Label()
        statusLabel .setAlignment(Label.CENTER)

        msgLabel = new Label()
        msgLabel .setAlignment(Label.CENTER)
        msgLabel .setText("Welcome to the AWT")

        controlPanel = new Panel()
        controlPanel .setLayout(new FlowLayout())

        mainFrame .add(headerLabel)
        mainFrame .add(controlPanel)
        mainFrame .add(statusLabel)
        mainFrame .setVisible(true)
    }

    def showWindowDemo() {
        headerLabel .setText("Container in action: Window")

        final MessageWindow window = new MessageWindow(mainFrame, "Welcome to my Tutorial")

        def okButton = new Button("Open a Window")
        okButton .addActionListener({ e ->
            window .setVisible(true)
            statusLabel .setText("A window for the user")} as ActionListener)

        controlPanel .add(okButton)
        mainFrame .setVisible(true)
    }
}

class MessageWindow extends Window {
    String message

    MessageWindow(Frame parent, String message) {
        super(parent)
        this.message = message
        setSize(300, 300)
        setLocationRelativeTo(parent)
        setBackground(Color.gray)
    }

    void paint(Graphics g) {
        super.paint(g)
        g.drawRect(0, 0, getSize().width - 1 as int, getSize().height - 1 as int)
        g.drawString(message, 50, 150)
    }
}