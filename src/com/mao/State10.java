package com.mao;

import java.awt.*;

public class State10 extends State {

    public State10(int life) {
        super(life);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 0){
            Firework firework = new Firework6();
            fireworks.add(firework);
        }
        updateFireworks(g);
    }

    @Override
    public void updateFireworks(Graphics g) {
        super.updateFireworks(g);
    }
}
