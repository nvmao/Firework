package com.mao;

import java.awt.*;

public class Firework2 extends Firework {
    public Firework2(Vector2 pos){
        super(pos);
    }

    public Firework2(){}

    @Override
    public void update() {
        super.update();


        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
        }

        if(this.particle.getPos().y < 730) {

            Vector2 pos = new Vector2(this.particle.getPos().x, this.particle.getPos().y);
            Vector2 vel = Random.random2D();
            Particle newParticle = new Particle(pos, vel, this.particle.getColor());
            newParticle.setLife(100);
            this.theParticles.add(newParticle);
        }
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                this.theParticles.get(i).reduceVel();
                if(this.theParticles.get(i).getLife() < 0 && !stay){
                    this.theParticles.remove(i);
                }
            }
//        }
//        else{
//            //this.theParticles.removeAll(this.theParticles);
//        }

    }

    @Override
    public void show(Graphics g) {
        this.particle.show(g);
        if(this.theParticles != null){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).show(g);
            }
        }

    }
}
