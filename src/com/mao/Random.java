package com.mao;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static double random(double start,double end){
        double randomNum = ThreadLocalRandom.current().nextDouble(start, end + 1);
        return randomNum;
    }

    public static double PI(){
        return 3.14159265359;
    }

    public static Vector2 random2D(){
        double angle = Random.random(0,Random.PI()*2);
        Vector2 vel = new Vector2(Math.cos(angle),Math.sin(angle));
        return vel;
    }
}
