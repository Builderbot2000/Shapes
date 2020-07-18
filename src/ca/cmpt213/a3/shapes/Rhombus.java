package ca.cmpt213.a3.shapes;

/**
 * A rhombus of specified side length at specified location defined by x, y.
 * Marked by a thickness 1 border to specified character around its borders.
 */
public class Rhombus extends ShapeImpl {
    public Rhombus(int xPos, int yPos, int size) {
        super(xPos, yPos, 2 * size - 1, 2 * size - 1);
    }

    protected boolean isBorder(int xPos, int yPos) {
        return helper(0,xPos,yPos);
    }

    protected boolean isInside(int xPos, int yPos) {
        return helper(1,xPos,yPos);
    }

    /**
     * Helper method that determines whether a tile is inside or outside the shape.
     * @param opFlag Control variable that sets the mode to either check for border or all inside areas.
     * @param xPos Column position of the tile.
     * @param yPos Row position of the tile.
     * @return Whether the tile is inside the shape as a border or otherwise.
     */
    private boolean helper (int opFlag, int xPos, int yPos) {
        int boundSize = getWidth();
        int centerX = getLocationX() + boundSize/2, centerY = getLocationY() + boundSize/2;
        int totalDistance = Math.abs(xPos - centerX) + Math.abs(yPos - centerY);
        if (opFlag == 0) { return totalDistance == boundSize / 2; }
        if (opFlag == 1) { return totalDistance <= boundSize / 2; }
        return false;
    }
}
