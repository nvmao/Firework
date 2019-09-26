package com.mao;

public class Firework4 extends Firework {



    public Firework4(Vector2 pos){
        super(pos);


    }

    public Firework4(){
        super();
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;
            double r = 0;
            if((int)(Math.random() * 2) == 0){
                r = 0.1;
            }
            else{
                r = 0.2;
            }
            for(double i = 0 ; i < Random.PI()*2;i += 0.1) {
                Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                double x = r*16*Math.pow(Math.sin(i),3);
                double y = -r *(13*Math.cos(i) - 5*Math.cos(2*i) - 2*Math.cos(3*i) - Math.cos(4*i));
                Vector2 vel = new Vector2(x,y);
                Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                newParticle.setLife(50);
                newParticle.setRadius(2);
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
