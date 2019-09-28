package com.mao;

public class Firework3 extends Firework {
    private int life = 150;
    private boolean startFiring = false;
    private Vector2 pos = new Vector2(0,0);
    private Vector2 randomRadius ;


    public Firework3(Vector2 pos){
        super(pos);
        int r = (int)(Random.random(1,3));
        randomRadius = new Vector2(r,r);
    }

    public Firework3() {
        super();
        int r = (int)(Random.random(1,3));
        randomRadius = new Vector2(r,r);
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            startFiring = true;
            int totalsParticle = (int)(Random.random(50,200));
            this.pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
        }
        if(startFiring && life > 0){
            Vector2 vel = Random.random2D();
            vel.mult(this.randomRadius);
            Vector2 pos = new Vector2(this.pos.x,this.pos.y);
            Particle newParticle = new Particle(pos,vel,this.particle.getColor());
            newParticle.setLife(80);
            this.theParticles.add(newParticle);

            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).update();
                this.theParticles.get(i).reduceVel();
                if(this.theParticles.get(i).getLife() < 0 && !stay){
                    this.theParticles.remove(i);
                }
            }
            life--;
        }
        else{
            this.theParticles.removeAll(this.theParticles);
        }

    }
}
