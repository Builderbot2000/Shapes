package ca.cmpt213.a3.shapes;

import ca.cmpt213.a3.UI.Canvas;

public class TextBox extends Rectangle {
    public TextBox(int xPos, int yPos, int width, int height, String text) {
        super(xPos, yPos, width, height);
    }

    public String getMessage() {
        return "";
    }

    public void setMessage(String message) {

    }

    public void draw(Canvas canvas) {

    }

    protected boolean isBorder(int xPos, int yPos) {
        return false;
    }

    protected boolean isInside(int xPos, int yPos) {
        return false;
    }
}
