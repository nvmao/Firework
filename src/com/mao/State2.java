package com.mao;

import java.awt.*;

public class State2 extends State {

    public State2(int life) {
        super(life);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 3){
            Firework firework = new Firework13();
            fireworks.add(firework);
            reset();
        }

        for (var firework : fireworks){
            firework.update();
            firework.show(g);
        }
    }
}
