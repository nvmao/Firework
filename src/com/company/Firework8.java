package com.company;

public class Firework8 extends Firework {

    @Override
    public void update() {
        super.update();
        int k = (int)(Random.random(1,10));

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            double d  = Random.random(1,3);
            for(double i = 0 ; i < Random.PI()*2;i+=0.05) {
                double r = Math.cos(k * i) * d;
                double x = Math.cos(i) * r;
                double y = Math.sin(i) * r;
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                Vector2 vel = new Vector2(x,y);
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(100);
                this.theParticles.add(newParticle);
            }
        }
        if(isExplore){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                //this.theParticles.get(i).apply_force(new Vector2(0,0.05));
                this.theParticles.get(i).reduceVel();
                if(this.theParticles.get(i).getLife() < 0){
                    this.theParticles.remove(i);
                }
            }
        }


    }
}
