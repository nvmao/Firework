package com.mao;

import java.awt.*;
import java.util.ArrayList;

public class Firework {
    protected Particle particle;
    protected ArrayList<Particle> theParticles;
    protected boolean isExplore;
    protected boolean windEffect = false;
    double wind = 0;

    public Firework(){
        this.particle = new Particle();
        this.isExplore = false;
        this.theParticles = new ArrayList<Particle>(50);
        initWin();
    }

    Firework(Vector2 pos){
        this.particle = new Particle(pos);
        this.isExplore = false;
        this.theParticles = new ArrayList<Particle>(50);
        initWin();
    }

    public void canWindEffect(){
        windEffect = true;
    }

    public void update(){
        if(windEffect){
            this.particle.apply_force(new Vector2(wind,0));
        }

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

    public void initWin(){
        int rand = (int)(Math.random() * 5);
        if(rand == 0){
            wind = 0.01;
        }
        else if(rand == 1){
            wind = 0.05;
        }
        else if(rand == 2){
            wind = 0.1;
        }
        else if(rand == 3){
            wind = 0.15;
        }
        else{
            wind = 0.2;
        }

        if((int)(Math.random() * 2)==0){
            wind = -wind;
        }
    }

    public void setWind(double wind){
        this.wind = wind;
    }

    public void setPos(Vector2 pos){
        this.particle.setPos(pos);
    }

}
