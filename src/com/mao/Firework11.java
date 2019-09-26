package com.mao;

public class Firework11 extends Firework {

    public Firework11(){}

    public Firework11(Vector2 pos){
        super(pos);
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            int totalsParticle = (int)(Random.random(50,200));
            for(int i = 0 ; i < totalsParticle;i++) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                Vector2 vel = new Vector2( Math.cos(Math.random()),Math.sin(Math.random()));
                vel.mult(new Vector2(4,4));
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(200);
                this.theParticles.add(newParticle);
            }
            for(int i = 0 ; i < totalsParticle;i++) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                Vector2 vel = new Vector2(-Math.cos(Math.random()),Math.sin(Math.random()));
                vel.mult(new Vector2(4,4));
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(200);
                this.theParticles.add(newParticle);
            }
            for(int i = 0 ; i < totalsParticle;i++) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                Vector2 vel = new Vector2( Math.cos(Math.random()),-Math.sin(Math.random()));
                vel.mult(new Vector2(4,4));
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(200);
                this.theParticles.add(newParticle);
            }
            for(int i = 0 ; i < totalsParticle;i++) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                Vector2 vel = new Vector2(-Math.cos(Math.random()),-Math.sin(Math.random()));
                vel.mult(new Vector2(4,4));
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(200);
                this.theParticles.add(newParticle);
            }
        }
        if(isExplore){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                this.theParticles.get(i).apply_force(new Vector2(0,0.01));
                this.theParticles.get(i).reduceVel();
                if(this.theParticles.get(i).getLife() < 0){
                    this.theParticles.remove(i);
                }
            }
        }
    }

}
