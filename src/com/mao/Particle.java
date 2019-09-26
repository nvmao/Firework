package com.mao;

import java.awt.*;

public class Particle {
    private Vector2 pos;
    private Vector2 vel;
    private Vector2 acc;
    private int life = 50;
    private Color color;
    private int radius = 5;

    public Particle(){
        //pos = new Vector2(500,720);
        pos = new Vector2((int)(Math.random() * 1280),720);
        vel = new Vector2(0,-Random.random(9,16));
        acc = new Vector2(0,0);
        life    = 100;
        color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
//        color = Color.RED;
    }

    public Particle(Vector2 pos) {
        this.pos = pos;
        vel = new Vector2(0,-Random.random(9,16));
        acc = new Vector2(0,0);
        life    = 100;
        color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
//        color = Color.RED;
    }

    public Particle(Vector2 pos,Vector2 vel,Color color){
        this.pos = pos;
        this.vel = vel;
        this.color = color;
        this.acc = new Vector2(0,0);
//        this.radius = (int)(Random.random(1,2));
        this.radius = 1;
    }

    public void apply_force(Vector2 force){
        this.acc.add(force);
    }

    public void reduceVel(){
        this.vel.mult(new Vector2(0.97,0.97));
    }

    public void reduceVel(Vector2 value){
        this.vel.mult(value);

    }


    public void update(){
        this.vel.add(this.acc);
        this.pos.add(this.vel);
        this.acc.mult(new Vector2(0,0));
        this.life--;
    }

    public void show(Graphics g){
        g.setColor(this.color);
        g.fillRect((int)this.pos.x,(int)this.pos.y,this.radius,this.radius);
//        int x = (int)(this.pos.x);
//        int y = (int)(this.pos.y);
//        g.drawOval(x,y,radius,radius);
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getVel() {
        return vel;
    }

    public void setVel(Vector2 vel) {
        this.vel = vel;
    }

    public Vector2 getAcc() {
        return acc;
    }

    public void setAcc(Vector2 acc) {
        this.acc = acc;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
