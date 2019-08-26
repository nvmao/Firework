package com.company;

public class Vector2 {
    public double x = 0;
    public double y = 0;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 a){
        this.x += a.x;
        this.y += a.y;
    }

    public void mult(Vector2 a){
        this.x *= a.x;
        this.y *= a.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
