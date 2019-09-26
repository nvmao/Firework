package com.mao;

public class Firework13 extends Firework {

    private float a_arr[] = new float[] {-0.5f,0,0.5f,1,2,3,4};

    Firework13(){}
    Firework13(Vector2 pos){
        super(pos);
    }

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            isExplore = true;

            for(float i = 0 ; i < Math.PI*3.5;i += 0.05) {

                for (int a = 0; a < a_arr.length; a++) {
                    Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
                    double y	= -((1/Math.cos(i))+ a_arr[a] * i * Math.cos(i)) * Math.cos(i);
                    double x	= ((1/Math.cos(i))+ a_arr[a] * i * Math.cos(i)) * Math.sin(i);
                    Vector2 vel = new Vector2(x,y);
                    vel.mult(new Vector2(0.2,0.2));
                    Particle newParticle = new Particle(pos,vel,this.particle.getColor());
                    this.theParticles.add(newParticle);
                }


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
