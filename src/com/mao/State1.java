package com.mao;

import java.awt.*;

public class State1 extends State {

    int rand;
    public State1(int life) {
        super(life);
        rand = (int)(Math.random() * 15);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 5){
            Firework firework = getFireWork(rand);
            firework.canWindEffect();
            firework.setWind(0.1);
            fireworks.add(firework);
            reset();
        }

        updateFireworks(g);
    }
}
