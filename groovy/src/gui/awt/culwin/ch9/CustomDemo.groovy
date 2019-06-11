package gui.awt.culwin.ch9

import java.applet.Applet
import java.applet.AppletContext
import java.awt.*

class CustomDemo extends Applet {
    OutputStream out = System.out

    String fontName = "Times"
    String fontStyle = "PLAIN"
    String fontSize = "14"
    String foregroundColorName = "black"
    String backgroundColorName = "white"

    void init() {
        Properties preset = System.getProperties()
        String userName = preset.getProperty("user.name")
        AppletContext context = null
        Label demoLabel = new Label()

        try {
            context = getAppletContext()
            fontName = getParameter("FONTNAME")
            fontStyle = getParameter("FONTSTYLE")
            fontSize = getParameter("FONTSIZE")
            backgroundColorName = getParameter("BACKGROUND")
            foregroundColorName = getParameter("FOREGROUND")
        } catch (Exception e) {
            System.err.println(e)
        }

        setResources()
        demoLabel.setText("Hello ${userName}")
        this.add(demoLabel)
    }

    void setResources() {
        int theFontStyle = Font.PLAIN
        if (fontStyle == "ITALIC") {
            theFontStyle = Font.ITALIC
        } else if (fontStyle == "BOLD") {
            theFontStyle = Font.BOLD
        }

        int theFontSize = 12
        try {
            theFontSize = Integer.parseInt(fontSize)
        } catch (NumberFormatException e) {
            // ignore
        }

        setFont(new Font(fontName, theFontStyle, theFontSize))
        setBackground(identifyColor(backgroundColorName))
        setForeground(identifyColor(foregroundColorName))
    }


    Color identifyColor(String color) {
        Color c = null
        if (color == "black") {
            c = Color.BLACK
        } else if (color == "white") {
            c = Color.WHITE
        } else if (color == "yellow") {
            c = Color.YELLOW
        } else if (color == "green") {
            c = Color.GREEN
        } else if (color == "red") {
            c = Color.RED
        } else if (color == "blue") {
            c = Color.BLUE
        }
        return c
    }

    static void main(String[] args) {
        Frame frame = new Frame("Demo")
        CustomDemo demo = new CustomDemo()

        args.each {
            String s = it.toLowerCase()
            String parameter = s.substring(it.indexOf("=") + 1)
            if (s.startsWith("fontname")) {
                demo.fontName = parameter
            } else if (s.startsWith("fontstyle")) {
                demo.fontStyle = parameter
            } else if (s.startsWith("fontsize")) {
                demo.fontSize = parameter
            } else if (s.startsWith("foreground")) {
                demo.foregroundColorName = parameter
            } else if (s.startsWith("background")) {
                demo.backgroundColorName = parameter
            }
        }

        demo.init()
        frame.add(demo, "Center")
        frame.setVisible(true)
        frame.setSize(frame.getPreferredSize())
    }
}
