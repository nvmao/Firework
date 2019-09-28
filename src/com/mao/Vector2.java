package com.mao;

public class Vector2 {
    public double x = 0;
    public double y = 0;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2(Vector2 v){
        this.x = v.x;
        this.y = v.y;
    }

    public void add(Vector2 a){
        this.x += a.x;
        this.y += a.y;
    }

    public void mult(Vector2 a){
        this.x *= a.x;
        this.y *= a.y;
    }

    public void normalize(){
        double m = Math.sqrt(this.x*this.x + this.y*this.y);
        this.x = this.x/m;
         this.y = this.y/m;
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
