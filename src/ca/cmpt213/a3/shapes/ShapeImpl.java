package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

import java.awt.*;

/**
 * General model for a shape generator.
 * Contains implementation of basic getters and setters for location, dimension, and appearance.
 * Implements the draw method using the methods isBorder() and isInside() to recognize correct painting action.
 */
public abstract class ShapeImpl implements Shape{

    private final int LocationX, LocationY;
    private final int width, height;
    private char borderChar = '*';
    private Color color = Color.blue;


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

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    /**
     * Draws shapes by going over each tile and determining if it is a part of the shape
     * and if it is a part of the shape's border.
     * Recognizes overlap and layer difference by painting new shapes directly over old ones.
     * @param canvas The canvas upon which all the shapes will be drawn.
     */
    public void draw(Canvas canvas) {
        for (int i = LocationY; i < LocationY + height; i++) {
            for (int j = LocationX; j < LocationX + width; j++) {
                // System.out.println("At: x"+j+" y"+i);
                if (j >= 0&& j < canvas.getSizeX() && i >= 0 && i < canvas.getSizeY()) {
                    if (isInside(j, i)) {
                        canvas.setCellColor(j, i, color);
                        canvas.setCellText(j,i,'\u0000');
                    }
                    if (isBorder(j, i)) {
                        canvas.setCellText(j, i, borderChar);
                    }
                }
            }
        }
    }

    protected abstract boolean isBorder(int xPos, int yPos);

    protected abstract boolean isInside(int xPos, int yPos);
}
