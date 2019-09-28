package com.mao;

import java.awt.*;
import java.util.ArrayList;

public class State7 extends State {

        ArrayList<ArrayList<Particle>> listParticles;
        int count = 0;
        int exploreTime = 0;
        boolean init = false;
        int maxFireWork = 100;

        public State7(int life) {
            super(life);
            listParticles = new ArrayList<>();
        }

        private void updateParticles(Graphics g){
            if(listParticles == null && count == maxFireWork ){
                return;
            }

            exploreTime++;

            if(exploreTime < 500){
                for(int i = 0 ; i < listParticles.size();i++){
                    ArrayList<Particle> particles = listParticles.get(i);
                    for(int j = 0 ; j < particles.size();j++){
                        Particle p = particles.get(j);
                        p.moveTo(new Vector2(1280/2,720/2));
                        p.update();
                        p.show(g);
                    }
                }
            }
            else{
                if(!init){
                    init = true;
                    double r = 0.05;
                    for(int i = 0 ; i < listParticles.size();i++){
                        ArrayList<Particle> particles = listParticles.get(i);
                        for(int j = 0; j < particles.size();j++){
                            Particle p = particles.get(j);
                            p.setVel(Random.random2D());
                            p.setVel(new Vector2(p.getVel().x * (int)(Random.random(1,4)),p.getVel().y *(int)(Random.random(1,4))));
                            p.update();
                            p.show(g);
                        }
                    }
                }

                for(int i = 0 ; i < listParticles.size();i++){
                    ArrayList<Particle> particles = listParticles.get(i);
                    for(int j = 0 ; j < particles.size();j++){
                        Particle p = particles.get(j);
                        p.update();
                        p.show(g);
                    }
                }
            }
        }

        @Override
        public void update(Graphics g) {
            time++;
            if(time > 1 && count < maxFireWork){
                time = 0;
                count++;
                Firework firework = getFireWork(0);
                firework.setStay(true);
                fireworks.add(firework);
            }
            updateFireworks(g);
            updateParticles(g);
        }

        @Override
        public void updateFireworks(Graphics g) {
            for(int i = 0 ; i < fireworks.size();i++){
                fireworks.get(i).update();
                fireworks.get(i).show(g);
                if(fireworks.get(i).isExplore() && fireworks.get(i).particleLife() < 0 ){
                    ArrayList<Particle> particles = new ArrayList<>(fireworks.get(i).getTheParticles());
                    listParticles.add(particles);
                    fireworks.remove(i);
                }
            }

        }
    }


