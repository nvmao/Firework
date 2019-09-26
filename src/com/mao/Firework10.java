package com.mao;

import java.awt.*;
import java.util.Hashtable;
import java.util.Map;

public class Firework10 extends Firework {
    private Vector2 center;
    private Map<Particle,Double> angles = new Hashtable<>();
    private Map<Particle,Double> radius = new Hashtable<>();

    public Firework10(Vector2 pos) {
        super(pos);
    }

    public Firework10(){}

    @Override
    public void update() {
        super.update();

        if(!isExplore && this.particle.getVel().y >= 0){
            center = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
            isExplore = true;
            int totalsParticle = 1;

            addNewParticle();
        }
        if(isExplore){

            for(int i = 0 ; i < this.theParticles.size();i++){
                double a = angles.get(this.theParticles.get(i));
                double r = radius.get(this.theParticles.get(i));

                double x = center.x + r * Math.cos(a);
                double y = center.y + r * Math.sin(a);
                this.theParticles.get(i).setPos(new Vector2(x,y));

                angles.replace(this.theParticles.get(i),a + 0.1);
                if(r < 100){
                    radius.replace(this.theParticles.get(i),r + 0.2);
                }

                if(this.theParticles.get(i).getLife() < 0){
                    this.theParticles.remove(i);
                }
                else{
                    this.theParticles.get(i).setLife(this.theParticles.get(i).getLife() - 1);
                }
            }

        }
    }

    private void particleMoveCircle(Particle p){

    }

    private void addNewParticle(){
        double a = 0;
        for(float i = 0 ; i < 6.28;i += 0.1){
            Vector2 pos = new Vector2(this.particle.getPos().x,this.particle.getPos().y);
            Vector2 vel = Random.random2D();
            vel.mult(new Vector2(Random.random(0.1,5),Random.random(0.1,5)));
            Color randomColor = new Color((int)(Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
            Particle newParticle = new Particle(pos,vel,randomColor);
            newParticle.setRadius(3);
            newParticle.setLife(300);
            this.theParticles.add(newParticle);

            angles.put(newParticle,(double)i);
            radius.put(newParticle,0d);
        }
    }

}
