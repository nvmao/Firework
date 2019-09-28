package com.mao;

import java.awt.*;

public class State9 extends State {

    private int rand;
    private int rand2;
    public State9(int life) {
        super(life);
        rand = (int)(Math.random() * 15);
        rand2 = (int)(Math.random() * 15);

    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 15){
            Firework firework = getFireWork(rand);
            firework.setStay(true);
            fireworks.add(firework);
            reset();
        }

        updateFireworks(g);
    }

    @Override
    public void updateFireworks(Graphics g) {
        for(int i = 0 ; i < fireworks.size();i++){
            Firework currentFirework = fireworks.get(i);
            currentFirework.update();
            currentFirework.show(g);
            if(currentFirework.isExplore() && currentFirework.particleLife() < -10){
                for(int j = 0 ; j < currentFirework.getTheParticles().size();j += 2){
                    Firework firework = getFireWork(rand2,new Vector2(currentFirework.getTheParticles().get(j).getPos()));
                    firework.setVel(new Vector2(0,0));
                    fireworks.add(firework);
                }
                fireworks.remove(i);
            }

        }
    }
}
