package ca.cmpt213.a3.shapes;

/**
 * A standard rectangle of specified width and height at specified location defined by x, y.
 * Marked by a thickness 1 border to specified character around its borders.
 */
public class Rectangle extends ShapeImpl {
    // private static final int BORDER_THICKNESS = 2;

    public Rectangle(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
    }

    protected boolean isBorder(int xPos, int yPos) {
        if (xPos == this.getLocationX()) return true;
        else if (xPos == getLocationX() + getWidth() - 1) return true;
        else if (yPos == getLocationY()) return true;
        else return yPos == getLocationY() + getHeight() - 1;
    }

    /* Quiz Question Modifications
    protected boolean isBorder(int xPos, int yPos) {
        if (xPos >= this.getLocationX() && xPos < this.getLocationX() + BORDER_THICKNESS) return true;
        else if (xPos <= getLocationX() + getWidth() - 1 && xPos >= getLocationX() + getWidth() - BORDER_THICKNESS) return true;
        else if (yPos >= getLocationY() && yPos < getLocationY() + BORDER_THICKNESS) return true;
        else if (yPos <= getLocationY() + getHeight() - 1 && yPos >= getLocationY() + getHeight() - BORDER_THICKNESS) return true;
        else return false;
    }
    */

    protected boolean isInside(int xPos, int yPos) {
        return true;
    }

}
