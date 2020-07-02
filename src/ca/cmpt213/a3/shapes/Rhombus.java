package ca.cmpt213.a3.shapes;

public class Rhombus extends ShapeImpl {
    public Rhombus(int xPos, int yPos, int size) {
        super(xPos, yPos, size, size);
    }

    @Override
    public char getBorderChar(char borderChar) {
        return borderChar;
    }

    protected boolean isBorder(int xPos, int yPos) {
        return false;
    }

    protected boolean isInside(int xPos, int yPos) {
        return false;
    }

}
