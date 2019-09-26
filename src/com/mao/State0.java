package com.mao;

import java.awt.*;

public class State0 extends State {

    int inc_time ;
    int rand;

    public State0(int life) {
        super(life);
        inc_time = 10;
        rand = (int)(Math.random() * 15);

    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > inc_time){
            Firework firework = State.getFireWork(rand);
            firework.setPos(new Vector2(1280/2,720));
            firework.canWindEffect();
            fireworks.add(firework);
            reset();
        }

        for (var firework : fireworks){
            firework.update();
            firework.show(g);
        }
    }
}
