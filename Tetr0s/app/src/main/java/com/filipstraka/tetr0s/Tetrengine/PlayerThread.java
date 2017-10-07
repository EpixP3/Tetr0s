package com.filipstraka.tetr0s.Tetrengine;

import android.graphics.Point;

/**
 * Created by strak on 7.10.2017..
 * OVO JE KLASA KOJA IMA ULOGU DA POMERA PLAYER PIECE
 * NA OSNOVU DELAY-A KOJI SE MOZE PODESITI SA setDelay(long);
 */

public class PlayerThread extends Thread {
    Tetrengine tetrengine;
    boolean running;
    long delay;
    Point playerBlock = new Point();


    //konstruktor..
    public PlayerThread(Tetrengine tetrengine){
        this.tetrengine = tetrengine;
        playerBlock.set(5,0);
    }

    //just cuz i can
    public void setRunning(boolean running){
        this.running = running;
    }
    //just cuz i can
    public void setDelay(long delay1){
        delay = delay1;
    }
    public void moveLeft(){
        if(playerBlock.x > 0 && tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap == null) {
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
            playerBlock.set(playerBlock.x -1, playerBlock.y);
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
        }
    }
    public void moveRight(){
        if(playerBlock.x < 9 && tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap == null) {
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
            playerBlock.set(playerBlock.x + 1, playerBlock.y);
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
        }
    }
    public void drop(){
        while(true){
            if(playerBlock.y < 21 && tetrengine.Map[playerBlock.x][playerBlock.y+1].bitmap == null) {
                if (playerBlock.y > 0) {
                    tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
                }
                playerBlock.set(playerBlock.x, playerBlock.y + 1);
                tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
            }
            else{
                playerBlock.set(5, 0);
                break;
            }
        }
    }
    @Override
    public void run(){
        while(running){
            //Ovde je kod koji se izvrsava svakih <delay> sekundi
            if(playerBlock.y < 21 && tetrengine.Map[playerBlock.x][playerBlock.y+1].bitmap == null) {
                if (playerBlock.y > 0) {
                    tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
                }
                playerBlock.set(playerBlock.x, playerBlock.y + 1);
                tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
            }
            else{
                playerBlock.set(5, 0);
            }
            //delay
            try {
                sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
