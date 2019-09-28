package com.mao;

import java.awt.*;

public class State8 extends State {

    public State8(int life) {
        super(life);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 5){
            Firework firework = getRandomFirework();
            fireworks.add(firework);
            reset();
        }
        updateFireworks(g);

    }

}
