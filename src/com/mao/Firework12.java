package com.mao;

public class Firework12 extends Firework {

    Firework12(){}
    Firework12(Vector2 pos){
        super(pos);
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            for(float i = 0 ; i < Math.PI * 2;i += 0.05) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);

                double x = Math.sin(i) *
                        ( Math.pow(Math.E,Math.cos(i)) - 2*Math.cos(4*i) + Math.pow(Math.sin(i/12),5));

                double y = -Math.cos(i) *
                        ( Math.pow(Math.E,Math.cos(i)) - 2*Math.cos(4*i) + Math.pow(Math.sin(i/12),5));

                Vector2 vel = new Vector2(x,y);

                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
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
