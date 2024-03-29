package com.mao;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 123123871923129L;

    public static final int WIDTH = 1280,HEIGHT = 720;
    private Thread thread;
    private boolean running = false;
    private Run run = new Run();

    public Game(){
        this.addKeyListener(new KeyInput(run));

        new Window(WIDTH,HEIGHT,"More Bug",this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        while(running){
            render();
        }

//        long lastTime = System.nanoTime();
//        double amountOfTicks = 60.0;
//        double ns = 1000000000 / amountOfTicks;
//        double delta = 0;
//        long timer = System.currentTimeMillis();
//        int frames = 0;
//        double time = 0;
//        while(running)
//        {
//            long now = System.nanoTime();
//            delta += (now - lastTime) / ns;
//            lastTime = now;
//            while(delta >=1)
//            {
//                tick();
//                delta--;
//            }
//            if(running)
//                render();
//            frames++;
//
//            if(System.currentTimeMillis() - timer > 1000)
//            {
//                timer += 1000;
//                System.out.println("FPS: "+ frames);
//                frames = 0;
//            }
////            time+= 0.1;
////            if(time > 700000){
////                render();
////                time = 0;
////            }
//        }
//        stop();
    }


    private void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(0, 0, 25,30));
        g.fillRect(0,0,WIDTH,HEIGHT);

        run.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String args[]){
        new Game();
    }
}
