package fr.uge.poo.simplegraphics;



import java.awt.Color;
import java.awt.Graphics2D;

public class SimpleGraphicsExample {

    private static void drawAll(Graphics2D graphics) {
        int xRectangle = 100, yRectangle = 20, widthRectangle = 40, heightRectangle = 140;
        graphics.setColor(Color.BLACK);
        graphics.drawRect(xRectangle, yRectangle, widthRectangle, heightRectangle);
        graphics.drawLine(xRectangle, yRectangle, xRectangle + widthRectangle, yRectangle + heightRectangle);
        graphics.drawLine(xRectangle + widthRectangle, yRectangle, xRectangle, yRectangle + heightRectangle);
        graphics.drawOval(xRectangle, yRectangle, widthRectangle, heightRectangle);
    }

    public static void main(String[] args) {
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(SimpleGraphicsExample::drawAll);
        //canvas.render(graphics -> drawAll(graphics));
    }
}
