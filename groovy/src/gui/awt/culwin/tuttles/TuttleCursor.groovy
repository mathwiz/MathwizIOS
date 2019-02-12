package gui.awt.culwin.tuttles

import java.awt.Color
import java.awt.Component
import java.awt.Image
import java.awt.image.ImageObserver
import java.awt.image.MemoryImageSource
import java.awt.image.PixelGrabber

class TuttleCursor {
    int imageWidth
    int imageHeight
    int[] pixels
    int[] rotatedPixels
    Component component
    Image rotatedImage

    TuttleCursor(Image toRotate, ImageObserver observer) {
        component = observer
        imageWidth = toRotate.getWidth(observer)
        imageHeight = toRotate.getHeight(observer)
        pixels = new int[imageWidth * imageHeight]
        rotatedPixels = new int[imageWidth * imageHeight]

        PixelGrabber grabber = new PixelGrabber(toRotate, 0, 0, imageWidth, imageHeight, pixels, 0, imageWidth)
        try {
            if (!grabber.grabPixels()) {
                throw new InterruptedException("Could not grab pixels")
            }
        } catch (Exception e) {
            System.err.println(e.getMessage())
            System.exit(-1)
        }
    }

    Image rotate(int angle) {
        int fromX, fromY, toX, toY
        final int transparent = 0x00000000
        final double radians = ((-(angle - 180) % 360) / 180) * Math.PI
        final double cosAngle = Math.cos(radians)
        final double sinAngle = Math.sin(radians)

        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                toX = Math.floorDiv(imageWidth, 2) - x
                toY = Math.floorDiv(imageHeight, 2) - y
                fromX = Math.floor((toX * cosAngle) - (toY * sinAngle)) as int
                fromY = Math.floor((toX * sinAngle) - (toY * cosAngle)) as int
                fromX += Math.floorDiv(imageWidth, 2)
                fromY += Math.floorDiv(imageHeight, 2)

                if ((fromX < 0 || fromX >= imageWidth) ||
                        (fromY < 0 || fromY >= imageHeight)) {
                    rotatedPixels[(y * imageWidth) + x] = transparent
                } else {
                    rotatedPixels[(y * imageWidth) + x] = pixels[(fromY * imageWidth) + fromX]
                }
            }
        }

        rotatedImage = component.createImage(
                new MemoryImageSource(imageWidth, imageHeight, rotatedPixels, 0, imageWidth))
        rotatedImage
    }

    void setCursorColor(Color c) {
        final int transparentMask = 0xFF000000
        final int newColorMask =
                transparentMask | (c.getRed() << 16) | (c.getGreen() << 8) | c.getBlue()

        for (int y = 0; y < imageHeight; y++) {
            for (int x = 0; x < imageWidth; x++) {
                if ((pixels[(y * imageWidth) + x] & transparentMask) == transparentMask) {
                    rotatedPixels[(y * imageWidth) + x] = newColorMask
                }
            }
        }
    }


}
