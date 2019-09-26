package com.mao;

import java.awt.*;
import java.util.ArrayList;

public class Run {
    ArrayList<State> states;
    int time;
    boolean next = false;

    public Run(){
        states = new ArrayList<>();
        time = 0;
        states.add(new State4(1000));
    }

    public void render(Graphics g){
        time++;

        if(states != null && states.size() > 0){
            if(time > states.get(0).getLife()){
                next = true;
                time = 0;
            }

            if(next){
                next = false;
                states.add(getRandomState());
                states.remove(0);
            }else {
                states.get(0).update(g);
            }
        }
    }

    public State getRandomState(){
        int life = 1000;
        int rand = (int)(Math.random() * 5);
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
        }
        return null;
    }

}
