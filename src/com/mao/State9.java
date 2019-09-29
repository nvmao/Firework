package com.mao;

import java.awt.*;

public class State9 extends State {

    private int rand;
    private int rand2;
    public State9(int life) {
        super(life);
        rand = (int)(Math.random() * 15);
        rand2 = (int)(Math.random() * 15);

        int r = (int)(Math.random() * 10);
        switch (r){
            case 0:{
                rand = 1;
                rand2 = 1;
                break;
            }
            case 1:{
                rand = 0;
                rand2 = 0;
                break;
            }
            case 3:{
                rand = 4;
                rand2 = 0;
                break;
            }
            case 4:{
                rand = 8;
                rand2 = 1;
                break;
            }
            case 5:{
                rand = 9;
                rand2 = 0;
                break;
            }
            case 6:{
                rand = 10;
                rand2 = 4;
                break;
            }
            case 7:{
                rand = 10;
                rand2 = 8;
                break;
            }
            case 8:{
                rand = 2;
                rand2 = 4;
                break;
            }
            case 9:{
                rand = 9;
                rand2 = 9;
                break;
            }
        }

    }

    @Override
    public void update(Graphics g) {
        time++;
        if(time > 15){
            Firework firework = getFireWork(rand);
            firework.setStay(true);
            fireworks.add(firework);
            reset();
        }

        updateFireworks(g);
    }

    @Override
    public void updateFireworks(Graphics g) {
        for(int i = 0 ; i < fireworks.size();i++){
            Firework currentFirework = fireworks.get(i);
            currentFirework.update();
            currentFirework.show(g);
            if(currentFirework.isExplore() && currentFirework.particleLife() < -10){
                for(int j = 0 ; j < currentFirework.getTheParticles().size();j += 2){
                    Firework firework = getFireWork(rand2,new Vector2(currentFirework.getTheParticles().get(j).getPos()));
                    firework.setVel(new Vector2(0,0));
                    fireworks.add(firework);
                }
                fireworks.remove(i);
            }

        }
    }
}
