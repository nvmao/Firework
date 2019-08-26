package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Firework {
    protected Particle particle;
    protected ArrayList<Particle> theParticles;
    protected boolean isExplore;

    public Firework(){
        this.particle = new Particle();
        this.isExplore = false;
        this.theParticles = new ArrayList<Particle>(50);
    }

    Firework(Vector2 pos){
        this.particle = new Particle(pos);
        this.isExplore = false;
        this.theParticles = new ArrayList<Particle>(50);
    }

    public void update(){
        this.particle.apply_force(new Vector2(0, 0.2));
        this.particle.update();
    }

    public boolean isDeath(){
        if(isExplore){
            return this.theParticles.size() <= 0;
        }
        return false;
    }

    public void show(Graphics g){

        if(isExplore){
            for(int i = 0 ; i < this.theParticles.size();i++){
                this.theParticles.get(i).show(g);
            }
        }
        else{
            this.particle.show(g);
        }
    }

}
