package gui.awt.culwin

import java.awt.Canvas
import java.awt.Dimension
import java.awt.FontMetrics
import java.awt.Graphics

class MessageCanvas extends Canvas {
    int maximumWidth = 0
    int characterHeight
    String[] message

    MessageCanvas(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, "\n")
        int numberOfLines = tokenizer.countTokens()
        message = new String[numberOfLines]
        for (int i = 0; i < numberOfLines; i++) {
            message[i] = ((String) tokenizer.nextToken()).trim()
        }
    }

    void addNotify() {
        super.addNotify()
        setSizes()
    }

    void setSizes() {
        FontMetrics metrics = getFontMetrics(getFont())
        characterHeight = metrics.getHeight()
        maximumWidth = (message.collect { metrics.stringWidth(it) }).max()
    }

    Dimension getPreferredSize() {
        new Dimension(maximumWidth + 20, (characterHeight * message.length) + 20)
    }

    Dimension getMinimumSize() {
        new Dimension(maximumWidth, characterHeight * message.length)
    }

    void paint(Graphics context) {
        FontMetrics metrics = getFontMetrics(getFont())
        int totalHeight = message.length * characterHeight
        int fromTop = Math.round((this.height - totalHeight) / 2 + characterHeight / 2).intValue()
        for (int i = 0; i < message.length; i++) {
            int leftOffset = this.width - metrics.stringWidth(message[i])
            context.drawString(message[i], leftOffset, fromTop)
            fromTop += characterHeight
        }
    }
}
