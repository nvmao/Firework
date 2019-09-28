package com.mao;

import java.awt.*;

public class State5 extends State {

    Vector2 pos;
    boolean right = true;
    int rand;

    public State5(int life) {
        super(life);
        pos = new Vector2(10,720);
        rand = (int)(Math.random() * 15);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 1){
            time = 0;
            Firework firework = getFireWork(rand,new Vector2(pos.x,pos.y));
            firework.setVel(new Vector2(0,-Random.random(12,15)));
            fireworks.add(firework);

            if(pos.x > 1280){
                right = false;
            }
            else if(pos.x < 0){
                right = true;
            }

            if(right){
               pos.setX(pos.getX() + 50);
            }
            else{
                pos.setX(pos.getX() - 50);
            }
        }
        updateFireworks(g);

    }
}
