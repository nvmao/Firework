package com.mao;

import java.awt.*;

public class State4 extends State {

    int count;

    public State4(int life) {
        super(life);
        count = (int)(Math.random() * 15);
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 100){
            count = (int)(Math.random() * 15);
            for(int i = 0 ; i < 50;i++){
                Firework firework = State.getFireWork(count);
                fireworks.add(firework);
            }
            reset();
        }

        for (var firework : fireworks){
            firework.update();
            firework.show(g);
        }
    }
}
