package com.mao;

import java.awt.*;

public class State2 extends State {

    private int exploreTime = 0;
    int rand;

    Particle particle;

    public State2(int life) {
        super(life);
        particle = new Particle(new Vector2(1280,720));
        particle.setRadius(10);
        particle.setVel( new Vector2(0,-32));
        rand = (int)(Math.random() * 15);
    }

    @Override
    public void update(Graphics g) {
        time++;
        exploreTime++;
        if(time > 10){
            Vector2 pos = new Vector2(particle.getPos().x+particle.getRadius()/2,particle.getPos().y + particle.getRadius()/2);
            Firework firework = getFireWork(rand,pos);
            firework.canWindEffect();
            fireworks.add(firework);
            reset();
        }

        particle.apply_force(new Vector2(-10, 0.2));
        particle.reduceVel(new Vector2(0,0.96));
        particle.update();
        if(particle.getPos().y > 720){
           particle.setVel( new Vector2(0,-28));
        }
        if(particle.getPos().x < 0){
            particle.setPos(new Vector2(1280,720));
            particle.setVel( new Vector2(0,-28));
        }
            for (int i = 0 ; i < fireworks.size();i++){
                var firework = fireworks.get(i);
                if(exploreTime > 2){
                    firework.setExplore(false);
                }
                firework.update();
                firework.show(g);
                if(firework.isFallDown()){
                    fireworks.remove(firework);
                }
            }
            if(exploreTime > 2){
                exploreTime = 0;
            }
        particle.show(g);


    }
}
