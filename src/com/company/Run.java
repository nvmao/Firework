package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Run {

    ArrayList<Firework> fireworks;
    int change = -1000;
    int changeSmall = 0;
    int posX = 10;
    int max = 8;
    boolean right = true;

    public Run(){
        fireworks = new ArrayList<Firework>();
    }

    public void render(Graphics g){
        change++;
        if(change < 0){
            if(changeSmall % 10 == 0){
                fireworks.add(new Firework4(new Vector2(posX,720)));
                if(right){
                    posX += 50;
                }
                else{
                    posX -= 50;
                }
                if(posX > 1280){
                    right = false;
                }
                else if(posX < 0){
                    right = true;
                }
            }
            changeSmall++;
        }
        else if(change < 500) {
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework4());
            }
        }
        else if(change > 500 && change < 1000){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework0());
            }
        }
        else if(change > 1000 && change < 1500){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework1());
            }
        }
        else if(change > 1500 && change < 2000){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework2());
            }
        }
        else if(change > 2000 && change < 2500){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework3());
            }
        }
        else if(change > 2500 && change < 3000){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework5());
            }
        }
        else if(change > 3000 && change < 3500){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework6());
            }
        }
        else if(change > 3500 && change < 4000){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework7());
            }
        }
        else if(change > 4000 && change < 5000){
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(new Firework8());
            }
        }
        else if(change > 5000) {
            if ((int) (Random.random(0, max)) == 1) {
                fireworks.add(getRandomFirework());
            }
        }

        for(int i = 0 ; i < fireworks.size();i++){
            fireworks.get(i).update();
            fireworks.get(i).show(g);
            if(fireworks.get(i).isDeath()){
                fireworks.remove(i);
            }
        }
    }

    public static Firework getRandomFirework(){

        int randomNum = (int)(Math.random() * 9);
        switch (randomNum){
            case 0:{
                return new Firework0();
            }
            case 1:{
                return new Firework1();
            }
            case 2:{
                return new Firework2();
            }
            case 3:{
                return new Firework3();
            }
            case 4:{
                return new Firework4();
            }
            case 5:{
                return new Firework5();
            }
            case 6:{
                return new Firework6();
            }
            case 7:{
                return new Firework7();
            }
            case 8:{
                return new Firework8();
            }
        }
        return null;
    }

}
