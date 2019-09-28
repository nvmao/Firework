package com.mao;

public class Firework5 extends Firework {

    private int changeDirection = 150;

    public Firework5(Vector2 pos){
        super(pos);
    }

    public Firework5() {
        super();
    }

    @Override
    public void update() {
        super.update();
        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            int totalsParticle = 4;
            Vector2 randomRadius = new Vector2((int)(Random.random(1,5)),(int)(Random.random(1,5)));
            for(int i = 0 ; i < totalsParticle;i++) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                Vector2 vel = Random.random2D();
                vel.mult(randomRadius);
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(300);
                this.theParticles.add(newParticle);
            }
        }
        if(isExplore){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                //this.theParticles.get(i).apply_force(new Vector2(0,0.05));
                this.theParticles.get(i).reduceVel();
                if(changeDirection < 0) {
                    Vector2 vel = Random.random2D();
                    Vector2 randomRadius = new Vector2((int)(Random.random(1,5)),(int)(Random.random(1,5)));
                    vel.mult(randomRadius);
                    this.theParticles.get(i).setVel(vel);
                }
                if(this.theParticles.get(i).getLife() < 0 && !stay){
                    this.theParticles.remove(i);
                }
            }
        }
        if(changeDirection < 0){
            changeDirection = 150;
        }
        changeDirection--;

    }
}
