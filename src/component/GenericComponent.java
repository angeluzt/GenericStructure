package component;

import interfaces.Drawable;

public class GenericComponent implements Drawable {
    private int x, y;
    private int with, height;

    public GenericComponent() {

    }

    public GenericComponent(int with, int height) {
        this.with = with;
        this.height = height;
    }

    public GenericComponent(int x, int y, int with, int height) {
        this.x = x;
        this.y = y;
        this.with = with;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
