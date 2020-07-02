package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

public interface Shape {
    int getLocationX();

    int getLocationY();

    void setBorderChar(char borderChar);

    char getBorderChar(char borderChar);

    void setColor(Color color);

    Color getColor();

    void draw(Canvas canvas);
}
