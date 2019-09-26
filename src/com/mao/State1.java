package com.mao;

import java.awt.*;

public class State1 extends State {

    public State1(int life) {
        super(life);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 5){
            Firework firework = getRandomFirework();
            firework.canWindEffect();
            firework.setWind(0.1);
            fireworks.add(firework);
            reset();
        }

        for (var firework : fireworks){
            firework.update();
            firework.show(g);
        }
    }
}
