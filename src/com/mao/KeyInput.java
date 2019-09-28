package com.mao;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Run run;
    int count = 0;

    public KeyInput(Run run) {
        this.run = run;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == 39){
            run.nextState(count);
            if(count > 15){
                count = 0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }
}
