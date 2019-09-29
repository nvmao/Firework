package com.mao;

import java.awt.*;
import java.util.ArrayList;

public class State11 extends State {

    ArrayList<Particle> particles = new ArrayList<>();

    public State11(int life) {
        super(life);
    }

    @Override
    public void update(Graphics g) {

        for(int i = 0 ; i < 10;i++){
            Particle newParticle = new Particle(new Vector2(1280/2,720/2));
            newParticle.setRadius(2);
            newParticle.setVel(Random.random2D());
            particles.add(newParticle);
        }


        for(int i = 0 ; i < particles.size();i++){
            Particle p = particles.get(i);
            p.update();
            p.show(g);
        }
    }

}
