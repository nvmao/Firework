package com.mao;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Run {
    ArrayList<State> states;
    int time;
    boolean next = false;
    public int count = 0;

    public Run(){
        states = new ArrayList<>();
        time = 0;
        states.add(getRandomState());
    }


    public void render(Graphics g){
        time++;
        if(states != null && states.size() > 0){
            if(time > states.get(0).getLife()){
                next = true;
                time = 0;
            }
            if(next){
                nextState(count);
                count++;
                if(count > 11){
                    count = 0;
                }
            }else {
                states.get(0).update(g);
            }
        }
    }

    public void nextState(){
        next = false;
        time = 0;
        states.add(getRandomState());
        states.remove(0);
    }
    public void nextState(int i){
        next = false;
        time = 0;
        states.add(getState(i));
        states.remove(0);
    }

    public State getRandomState(){
        int life = 1000;
        int rand = (int)(Math.random() * 12);
        switch (rand){
            case 0:{
                return new State0(life);
            }
            case 1:{
                return  new State1(life);
            }
            case 2:{
                return  new State2(life );
            }
            case 3:{
                return new State3(life );
            }
            case 4:{
                return new State4(life);
            }
            case 5:{
                return new State5(life);
            }
            case 6:{
                return new State6((int)(life * 2.5));
            }
            case 7:{
                return new State7((int)(life * 2.5));
            }
            case 8:{
                return  new State8(life * 2);
            }
            case 9:{
                return new State9(life * 2);
            }
            case 10:{
                return  new State10(life);
            }
            case 11:{
                return new State11(life);
            }

        }
        return null;
    }

    public State getState(int i){
        int life = 1000;
        int rand = i;
        switch (rand){
            case 0:{
                return new State0(life);
            }
            case 1:{
                return  new State1(life);
            }
            case 2:{
                return  new State2(life );
            }
            case 3:{
                return new State3(life );
            }
            case 4:{
                return new State4(life);
            }
            case 5:{
                return new State5(life);
            }
            case 6:{
                return new State6((int)(life * 2.5));
            }
            case 7:{
                return new State7((int)(life * 2.5));
            }
            case 8:{
                return  new State8(life );
            }
            case 9:{
                return new State9(life*2);
            }
            case 10:{
                return new State10(life);
            }
            case 11:{
                return new State11(life);
            }
        }
        return null;
    }

}
