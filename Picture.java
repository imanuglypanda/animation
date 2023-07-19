public class Picture {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int width;
    private int height;
    private int ufoWidth;
    private int ufoHeight;

    public Picture(int x, int y, int ufoWidth, int ufoHeight, int width, int height, int dx, int dy) {
        setX(x);
        setY(y);
        setDx(dx);
        setDy(dy);
        setWidth(width);
        setHeight(height);
        setUFOWidth(ufoWidth);
        setUFOHeight(ufoHeight);
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    
    public void setDx(int dx) { this.dx = dx; }
    public void setDy(int dy) { this.dy = dy; }
    
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }

    public void setUFOWidth(int ufoWidth) { this.ufoWidth = ufoWidth; }
    public void setUFOHeight(int ufoHeight) { this.ufoHeight = ufoHeight; }

    public void animate() {
        if (x < 0 || x > width - ufoWidth) {
            dx = -dx;
        }
        if (y < 0 || y > height - ufoHeight) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }
}
