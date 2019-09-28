package com.mao;

import java.awt.*;

public class Firework9 extends Firework {

    public Firework9() {
        super();
    }

    Firework9(Vector2 pos){
        super();
        this.particle.setPos(pos);
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            int totalsParticle = (int)(Random.random(50,200));
            int radius = (int)Random.random(2,3);
            for(float i = 0 ; i < 6.28 ;i += 0.1) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                Vector2 vel = new Vector2(radius* Math.pow(Math.cos(i),3),radius * Math.pow(Math.sin(i),3));
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(150);
                this.theParticles.add(newParticle);
            }
        }
        if(isExplore){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                this.theParticles.get(i).apply_force(new Vector2(0,0.01));
                this.theParticles.get(i).reduceVel();
                if(this.theParticles.get(i).getLife() < 0 && !stay){
                    this.theParticles.remove(i);
                }
            }
        }
    }
}
