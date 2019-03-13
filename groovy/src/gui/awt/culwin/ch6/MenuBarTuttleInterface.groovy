package gui.awt.culwin.ch6


import java.awt.*
import java.awt.event.ActionListener
import java.util.List

class MenuBarTuttleInterface {
    ActionListener sendToHere
    Frame myFrame
    MenuBar mainMenuBar = new MenuBar()
    Menu fileMenu = new Menu("File")
    MenuItem exitButton = new MenuItem("Exit ...")

    def movementMenus = [:]
    def screenMenus = [:]
    def penMenus = [:]
    def backgroundMenus = [:]
    def foregroundMenus = [:]
    def movementCommands = ["goForward", "goBackward", "turnLeft", "turnRight"]
    def screenCommands = ["clear", "reset", "clearAndReset"]
    def penCommands = ["penUp", "penDown"]
    def backgroundCommands = ["backgroundRed", "backgroundBlue", "backgroundYellow", "backgroundGreen", "backgroundWhite", "backgroundBlack"]
    def foregroundCommands = ["foregroundRed", "foregroundBlue", "foregroundYellow", "foregroundGreen", "foregroundWhite", "foregroundBlack"]

    MenuBarTuttleInterface(Frame frame, ActionListener listener) {
        sendToHere = listener
        myFrame = frame

        myFrame.setMenuBar(mainMenuBar)

        mainMenuBar.add(fileMenu)
        fileMenu.add(exitButton)

        exitButton.setActionCommand("exit show")
        exitButton.addActionListener(sendToHere)

        doCreatControls(movementCommands, movementMenus)
        doCreatControls(screenCommands, screenMenus)
        doCreatControls(penCommands, penMenus)
        doCreatControls(backgroundCommands, backgroundMenus)
        doCreatControls(foregroundCommands, foregroundMenus)
    }

    private def doCreatControls(List names, Map holder) {
        names.each {
            holder[it] = makeButton(it)
        }
    }

    private def makeButton(String name) {
        def btn = new MenuItem(name)
        btn.setActionCommand(name)
        btn.addActionListener(sendToHere as ActionListener)
        btn
    }
}
