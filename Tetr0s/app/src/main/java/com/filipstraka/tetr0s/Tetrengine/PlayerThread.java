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
    Tetr0mino Tetr0mino;
    int orientation = 0;



    //konstruktor..
    public PlayerThread(Tetrengine tetrengine){
        this.tetrengine = tetrengine;
        playerBlock.set(5,8);
        this.Tetr0mino=new Tetr0mino(6);
    }

    //just cuz i can
    public void setRunning(boolean running){
        this.running = running;
    }
    //just cuz i can
    public void setDelay(long delay){
        this.delay = delay;
    }
    public void moveLeft(){
        /*if(playerBlock.x > 0 && tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap == null) {
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
            playerBlock.set(playerBlock.x -1, playerBlock.y);
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
        }
        */
        //GORE JE STARI KOD SAMO ZA JEDAN BLOK
        //TODO
    }
    public void moveRight(){
        /*
        if(playerBlock.x < 9 && tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap == null) {
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
            playerBlock.set(playerBlock.x + 1, playerBlock.y);
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
        }
        */
        //GORE JE STARI KOD SAMO ZA JEDAN BLOK
        //TODO
    }
    public void drop(){
        /*
        while(true){
            if(playerBlock.y < 21 && tetrengine.Map[playerBlock.x][playerBlock.y+1].bitmap == null) {
                if (playerBlock.y > 0) {
                    tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
                }
                playerBlock.set(playerBlock.x, playerBlock.y + 1);
                tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
            }
            else{
                playerBlock.set(5, 2);
                break;
            }
        }
        */
        //GORE JE STARI KOD SAMO ZA JEDAN BLOK
        //TODO
    }
    @Override
    public void run(){
        while(running){
            //Ovde je kod koji se izvrsava svakih <delay> sekundi
            
            /*
            if(playerBlock.y < 21 && tetrengine.Map[playerBlock.x][playerBlock.y+1].bitmap == null) {
                if (playerBlock.y > 0) {
                    tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
                }
                playerBlock.set(playerBlock.x, playerBlock.y + 1);
                tetrengine.Map[playerBlock.x+Tetr0mino.tetr0mino_90[0].x][playerBlock.y+Tetr0mino.tetr0mino_90[0].y].setBitmap(tetrengine.cyan);
                tetrengine.Map[playerBlock.x+Tetr0mino.tetr0mino_90[1].x][playerBlock.y+Tetr0mino.tetr0mino_90[1].y].setBitmap(tetrengine.cyan);
                tetrengine.Map[playerBlock.x+Tetr0mino.tetr0mino_90[2].x][playerBlock.y+Tetr0mino.tetr0mino_90[2].y].setBitmap(tetrengine.cyan);
                tetrengine.Map[playerBlock.x+Tetr0mino.tetr0mino_90[3].x][playerBlock.y+Tetr0mino.tetr0mino_90[3].y].setBitmap(tetrengine.cyan);
            }
            else{
                playerBlock.set(5, 2);
            }
            */
            //GORE JE STARI KOD SAMO ZA JEDAN BLOK
            //TODO
            //ostavite ovo gospodinu faplu da sredi
            boolean pass=true;
                switch(orientation){
                    case 0:
                        switch(Tetr0mino.type){
                            case 0:
                                if()
                            case 1:
                                
                            case 2:
                                
                            case 3:
                                
                            case 4:
                                
                            case 5:
                                
                            case 6:
                                
                        }
                    case 1:
                        switch(Tetr0mino.type){
                            case 0:
                                
                            case 1:
                                
                            case 2:
                                
                            case 3:
                                
                            case 4:
                                
                            case 5:
                                
                            case 6:
                                
                        }
                    case 2:
                        switch(Tetr0mino.type){
                            case 0:
                                
                            case 1:
                                
                            case 2:
                                
                            case 3:
                                
                            case 4:
                                
                            case 5:
                                
                            case 6:
                                
                        }
                    case 3:
                        switch(Tetr0mino.type){
                            case 0:
                                
                            case 1:
                                
                            case 2:
                                
                            case 3:
                                
                            case 4:
                                
                            case 5:
                                
                            case 6:
                                
                        }
            }
            //ako nista nema ispod tetr0mina
            if(pass){
                
            }
            else{
                
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
