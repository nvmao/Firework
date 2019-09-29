package com.mao;

import java.awt.*;

public class State10 extends State {

    private int rand;
    private double wind;
    boolean shootContinously = false;

    public State10(int life) {
        super(life);
        wind = 0.3;
        rand = (int)(Math.random() * 15);
        if((int)(Math.random() * 2) == 0){
            shootContinously = true;
        }
    }

    @Override
    public void update(Graphics g) {
        time++;
        if(shootContinously){
            if(time > 1){
                Firework firework = getFireWork(rand,new Vector2(0,720));
                firework.canWindEffect();
                firework.setWind(wind);

                Firework firework2 = getFireWork(rand,new Vector2(1280,720));
                firework2.canWindEffect();
                firework2.setWind(-wind);
                fireworks.add(firework);
                fireworks.add(firework2);
                reset();
            }
        }
        else{
            if(time > 50){
                for(int i = 0 ; i < 100;i++){
                    Firework firework = getFireWork(rand,new Vector2(0,720));
                    firework.canWindEffect();
                    firework.setWind(wind);

                    Firework firework2 = getFireWork(rand,new Vector2(1280,720));
                    firework2.canWindEffect();
                    firework2.setWind(-wind);
                    fireworks.add(firework);
                    fireworks.add(firework2);
                }
                reset();
            }
        }

        updateFireworks(g);
    }

    @Override
    public void updateFireworks(Graphics g) {
        super.updateFireworks(g);
    }
}
