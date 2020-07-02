package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

public abstract class ShapeImpl implements Shape{

    private final int LocationX, LocationY;
    private final int width, height;
    private char borderChar;
    private Color color;


    public ShapeImpl(int xPos, int yPos, int width, int height) {
        this.LocationX = xPos;
        this.LocationY = yPos;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getLocationX() {
        return LocationX;
    }

    @Override
    public int getLocationY() {
        return LocationY;
    }

    @Override
    public void setBorderChar(char borderChar) {
        this.borderChar = borderChar;
    }

    public char getBorderChar() {
        return borderChar;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(Canvas canvas) {

    }

    protected abstract boolean isBorder(int xPos, int yPos);

    protected abstract boolean isInside(int xPos, int yPos);
}
