package com.mao;

public class Firework14 extends Firework {

    Firework14(){}
    Firework14(Vector2 pos){
        super(pos);
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;

            for(float i = 0 ; i < Math.PI*2;i += 0.05) {
                    Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                    Vector2 vel;
                    if((int)(Math.random()*2) == 0){
                        vel = new Vector2(Math.random() * 3,-3);
                    }
                    else{
                        vel = new Vector2(-Math.random()*3,-3);
                    }
                    vel.mult(new Vector2((Math.random() * 3),(Math.random() * 3)));
                    Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                    this.theParticles.add(newParticle);
            }
        }
        if(isExplore){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                this.theParticles.get(i).apply_force(new Vector2(0,0.02));
                this.theParticles.get(i).reduceVel(new Vector2(0.95,0.95));
                if(this.theParticles.get(i).getLife() < 0 && !stay){
                    this.theParticles.remove(i);
                }
            }
        }
    }

}
