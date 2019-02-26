package gui.awt.culwin.c5

import gui.awt.culwin.tuttles.TuttleButton

import javax.swing.Action
import java.applet.Applet
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Panel
import java.awt.event.ActionListener

class SemiDirectTuttleInterface {
    Applet sendToHere
    Panel foregroundPanel, backgroundPanel, screenPanel, penPanel, movementPanel
    def movementButtons = [:]
    def screenButtons = [:]
    def penButtons = [:]
    def backgroundButtons = [:]
    def foregroundButtons = [:]
    def movementButtonNames = ["goForward", "goBackward", "turnLeft", "turnRight" ]
    def screenButtonNames = [ "clear", "reset", "clearAndReset" ]
    def penButtonNames = [ "penUp", "penDown" ]
    def backgroundButtonNames = [ "backgroundRed", "backgroundBlue", "backgroundYellow", "backgroundGreen", "backgroundWhite", "backgroundBlack" ]
    def foregroundButtonNames = [ "foregroundRed", "foregroundBlue", "foregroundYellow", "foregroundGreen", "foregroundWhite", "foregroundBlack" ]

    def tuttleLayout = new GridBagLayout()
    def movementLayout = new GridBagLayout()
    def constraints = new GridBagConstraints()

    SemiDirectTuttleInterface(Applet myApplet) {
        sendToHere = myApplet

        foregroundPanel = new Panel()
        backgroundPanel = new Panel()
        screenPanel = new Panel()
        penPanel = new Panel()
        movementPanel = new Panel()

        doButtons(movementButtonNames, movementButtons)
        doButtons(screenButtonNames, screenButtons)
        doButtons(penButtonNames, penButtons)
        doButtons(backgroundButtonNames, backgroundButtons)
        doButtons(foregroundButtonNames, foregroundButtons)

        movementPanel.setLayout(movementLayout)
    }

    private def doButtons(String names, Map holder) {
        names.each {
            holder[it] = makeButton(it)
        }
    }

    private def makeButton(String name) {
        def btn = new TuttleButton("${name}.gif", sendToHere)
        btn.setActionCommand(name)
        btn.addActionListener(sendToHere as ActionListener)
        btn
    }
}
