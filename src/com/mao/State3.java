package com.mao;

import java.awt.*;

public class State3 extends State {

    int rand;

    public State3(int life) {
        super(life);
        rand = (int)(Math.random() * 15);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 3){
            Firework firework = State.getFireWork(rand);
            fireworks.add(firework);
            reset();
        }

        for (var firework : fireworks){
            firework.update();
            firework.show(g);
        }
    }
}
