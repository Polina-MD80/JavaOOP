package PointPnRectangle;

public
class Point {
    private int x;
    private int y;

    public
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public
    int getX () {
        return x;
    }

    public
    int getY () {
        return y;
    }

    public
    boolean isBigger (Point point) {
        return point.x >= this.x && point.y >= this.y;
    }

    public
    boolean isSmaller (Point point) {
        return point.x <= this.x && point.y <= this.y;
    }
}
