package com.mao;

public class Firework6 extends Firework {


    public Firework6(Vector2 pos){
        super(pos);
    }

    public Firework6() {
        super();
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            Vector2 pos1 = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
            Vector2 pos2 = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
            Vector2 velLeft = new Vector2(-1,0);
            Vector2 velRight = new Vector2(1,0);
            Particle newParticle = new Particle(pos1,velLeft,this.particle.getColor());
            Particle newParticle2 = new Particle(pos2,velRight,this.particle.getColor());
            newParticle.setRadius(6);
            newParticle2.setRadius(6);
            newParticle.setLife(200);
            newParticle2.setLife(200);
            this.theParticles.add(newParticle);
            this.theParticles.add(newParticle2);
        }
        if(isExplore){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                if(i == 0){
                    this.theParticles.get(0).apply_force(new Vector2(-0.3,0));
                }
                else{
                    this.theParticles.get(1).apply_force(new Vector2(0.3,0));
                }
                if(this.theParticles.get(i).getLife() < 0 && !stay){
                    this.theParticles.remove(i);
                }
            }
        }
    }
}
