package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

/**
 * Basic template for any shape to be drawn onto canvas.
 * Contains specifications for getters and setters of shape location, border char, and color.
 * Demands the implementation of a draw method for the shape generator.
 */
public interface Shape {
    int getLocationX();

    int getLocationY();

    void setBorderChar(char borderChar);

    char getBorderChar();

    void setColor(Color color);

    Color getColor();

    void draw(Canvas canvas);
}
