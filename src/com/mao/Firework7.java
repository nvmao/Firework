package com.mao;

import java.awt.*;

public class Firework7 extends Firework {

    public Firework7(Vector2 pos){
        super(pos);
    }

    public Firework7() {
        super();
    }

    @Override
    public void update() {
        super.update();

        if(this.particle.getVel().y < 0) {
            Vector2 pos = new Vector2(this.particle.getPos().x + 10, this.particle.getPos().y);
            Vector2 pos2 = new Vector2(this.particle.getPos().x - 5, this.particle.getPos().y);
            Vector2 vel = new Vector2(0, -5);
            Vector2 vel2 = new Vector2(0, -5);
            Particle newParticle = new Particle(pos, vel, this.particle.getColor());
            Particle newParticle2 = new Particle(pos2, vel2, this.particle.getColor());
            newParticle.setLife(300);
            newParticle2.setLife(300);
            this.theParticles.add(newParticle);
            this.theParticles.add(newParticle2);
        }
        if(this.theParticles != null){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                if(this.particle.getVel().y < 0) {
                    this.theParticles.get(i).apply_force(new Vector2(0, -0.05));
                }
                else{
                    this.theParticles.get(i).apply_force(new Vector2(0,0.05));
                }
                //this.theParticles.get(i).reduceVel();
                if(this.theParticles.get(i).getLife() < 0 && !stay){
                    this.theParticles.remove(i);
                }
            }
        }
    }

    @Override
    public void show(Graphics g) {
        for(int i = 0 ; i < this.theParticles.size();i++){
            this.theParticles.get(i).show(g);
        }
        this.particle.show(g);
    }
}
