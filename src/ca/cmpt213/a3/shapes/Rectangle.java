package ca.cmpt213.a3.shapes;

public class Rectangle extends ShapeImpl {
    public Rectangle(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
    }

    protected boolean isBorder(int xPos, int yPos) {
        return false;
    }

    protected boolean isInside(int xPos, int yPos) {
        return false;
    }

    @Override
    public char getBorderChar(char borderChar) {
        return 0;
    }
}
