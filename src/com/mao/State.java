package com.mao;

import java.awt.*;
import java.util.ArrayList;

public abstract class State {
    ArrayList<Firework> fireworks;
    int time;
    int life = 100;

    public State(int life){
        fireworks = new ArrayList<>();
        time = 0;
        this.life = life;
    }

    public void reset(){
        time = 0;
    }

    public abstract void update(Graphics g);

    int getLife(){
        life--;
        return life;
    }

    public static Firework getRandomFirework(){

        int randomNum = (int)(Math.random() * 15);
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
            case 9:{
                return new Firework9();
            }
            case 10:{
                return new Firework10();
            }
            case 11:{
                return new Firework11();
            }
            case 12:{
                return new Firework12();
            }
            case 13:{
                return new Firework13();
            }
            case 14:{
                return new Firework14();
            }
        }
        return null;
    }

    public static Firework getFireWork(int i){
        int randomNum = i;
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
            case 9:{
                return new Firework9();
            }
            case 10:{
                return new Firework10();
            }
            case 11:{
                return new Firework11();
            }
            case 12:{
                return new Firework12();
            }
            case 13:{
                return new Firework13();
            }
            case 14:{
                return new Firework14();
            }
        }
        return null;
    }

    public void updateFireworks(Graphics g){
        for(int i = 0 ; i < fireworks.size();i++){
            fireworks.get(i).update();
            fireworks.get(i).show(g);
            if(fireworks.get(i).isDeath()){
                fireworks.remove(i);
            }
        }
    }

    public static Firework getFireWork(int i,Vector2 pos){
        int randomNum = i;
        switch (randomNum){
            case 0:{
                return new Firework0(pos);
            }
            case 1:{
                return new Firework1(pos);
            }
            case 2:{
                return new Firework2(pos);
            }
            case 3:{
                return new Firework3(pos);
            }
            case 4:{
                return new Firework4(pos);
            }
            case 5:{
                return new Firework5(pos);
            }
            case 6:{
                return new Firework6(pos);
            }
            case 7:{
                return new Firework7(pos);
            }
            case 8:{
                return new Firework8(pos);
            }
            case 9:{
                return new Firework9(pos);
            }
            case 10:{
                return new Firework10(pos);
            }
            case 11:{
                return new Firework11(pos);
            }
            case 12:{
                return new Firework12(pos);
            }
            case 13:{
                return new Firework13(pos);
            }
            case 14:{
                return new Firework14(pos);
            }
        }
        return null;
    }

    public static Firework getRandomFirework(Vector2 pos){

        int randomNum = (int)(Math.random() * 15);
        switch (randomNum){
            case 0:{
                return new Firework0(pos);
            }
            case 1:{
                return new Firework1(pos);
            }
            case 2:{
                return new Firework2(pos);
            }
            case 3:{
                return new Firework3(pos);
            }
            case 4:{
                return new Firework4(pos);
            }
            case 5:{
                return new Firework5(pos);
            }
            case 6:{
                return new Firework6(pos);
            }
            case 7:{
                return new Firework7(pos);
            }
            case 8:{
                return new Firework8(pos);
            }
            case 9:{
                return new Firework9(pos);
            }
            case 10:{
                return new Firework10(pos);
            }
            case 11:{
                return new Firework11(pos);
            }
            case 12:{
                return new Firework12(pos);
            }
            case 13:{
                return new Firework13(pos);
            }
            case 14:{
                return new Firework14(pos);
            }
        }
        return null;
    }
}
