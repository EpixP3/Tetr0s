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
    Tetr0mino tetr0mino;
    int orientation=0; //0 = 0, 1 = 90, 2 = 180, 3 = 270



    //konstruktor..
    public PlayerThread(Tetrengine tetrengine){
        this.tetrengine = tetrengine;
        playerBlock.set(5,2);
        //tetr0mino = new Tetr0mino((int)(Math.random()*7));
        tetr0mino = new Tetr0mino(1);
    }

    //just cuz i can
    public void setRunning(boolean running){
        this.running = running;
    }
    //just cuz i can
    public void setDelay(long delay){
        this.delay = delay;
    }
    public void rotateLeft(){
        //TODO                       KOD ZA ROTATE LEFT
    }
    public void rotateRight(){
        //TODO                       KOD ZA ROTATE RIGHT
    }
    public void moveLeft(){
        /*if(playerBlock.x > 0 && tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap == null) {
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
            playerBlock.set(playerBlock.x -1, playerBlock.y);
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
        }
        */
        //GORE JE STARI KOD SAMO ZA JEDAN BLOK
        //TODO                       KOD ZA MOVE LEFT
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
        //TODO                       KOD ZA MOVE RIGHT

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
        //TODO                        KOD ZA DROP
    }

    public void updateBlock(){
        switch(orientation){
            case 0:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_normal[i].x][playerBlock.y + tetr0mino.tetr0mino_normal[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                switch(tetr0mino.type){
                    case 0:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetrengine.magenta);}break;
                    case 1:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetrengine.blue);}break;
                    case 2:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetrengine.red);}break;
                    case 3:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetrengine.yellow);}break;
                    case 4:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetrengine.green);}break;
                    case 5:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetrengine.orange);}break;
                    case 6:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetrengine.cyan);}break;
                }break;
            case 1:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_90[i].x][playerBlock.y + tetr0mino.tetr0mino_90[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                switch(tetr0mino.type){
                    case 0:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetrengine.magenta);}break;
                    case 1:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetrengine.blue);}break;
                    case 2:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetrengine.red);}break;
                    case 3:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetrengine.yellow);}break;
                    case 4:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetrengine.green);}break;
                    case 5:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetrengine.orange);}break;
                    case 6:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetrengine.cyan);}break;
                }break;
            case 2:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_180[i].x][playerBlock.y + tetr0mino.tetr0mino_180[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                switch(tetr0mino.type){
                    case 0:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetrengine.magenta);}break;
                    case 1:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetrengine.blue);}break;
                    case 2:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetrengine.red);}break;
                    case 3:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetrengine.yellow);}break;
                    case 4:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetrengine.green);}break;
                    case 5:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetrengine.orange);}break;
                    case 6:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetrengine.cyan);}break;
                }break;
            case 3:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_270[i].x][playerBlock.y + tetr0mino.tetr0mino_270[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                switch(tetr0mino.type){
                    case 0:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetrengine.magenta);}break;
                    case 1:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetrengine.blue);}break;
                    case 2:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetrengine.red);}break;
                    case 3:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetrengine.yellow);}break;
                    case 4:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetrengine.green);}break;
                    case 5:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetrengine.orange);}break;
                    case 6:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetrengine.cyan);}break;
                }break;
        }
    }
    @Override
    public void run(){
        while(running){
            //TODO      Ostavite gospodinu faplu da sredi
            orientation = 0;
            boolean pass=true;
                switch(orientation){
                    case 0:
                        switch(tetr0mino.type){
                            case 0:
                                if(playerBlock.y == 20 || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[1].x][playerBlock.y+tetr0mino.tetr0mino_normal[1].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 1:
                                if(playerBlock.y == 20 || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 2:
                                if(playerBlock.y == 20 || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[1].x][playerBlock.y+tetr0mino.tetr0mino_normal[1].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 3:
                                if(playerBlock.y == 20 ||tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 4:
                                if(playerBlock.y == 20 || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[1].x][playerBlock.y+tetr0mino.tetr0mino_normal[1].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 5:
                                if(playerBlock.y == 20 || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 6:
                                if(playerBlock.y == 20 || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                        }
                        break;
                    case 1:
                        switch(tetr0mino.type){
                            case 0:
                                if(playerBlock.y == 20 ||tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[1].x][playerBlock.y+tetr0mino.tetr0mino_90[1].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[2].x][playerBlock.y+tetr0mino.tetr0mino_90[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                if(playerBlock.y == 20 ||tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                        }
                        break;
                    case 2:
                        switch(tetr0mino.type){
                            case 0:
                                if(playerBlock.y == 21 ||tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[0].x][playerBlock.y+tetr0mino.tetr0mino_180[0].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[1].x][playerBlock.y+tetr0mino.tetr0mino_180[1].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[2].x][playerBlock.y+tetr0mino.tetr0mino_180[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                if(playerBlock.y == 20 ||tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                        }
                        break;
                    case 3:
                        switch(tetr0mino.type){
                            case 0:
                                if(playerBlock.y == 20 ||tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[1].x][playerBlock.y+tetr0mino.tetr0mino_270[1].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[2].x][playerBlock.y+tetr0mino.tetr0mino_270[2].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                if(playerBlock.y == 20 ||tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[2].x][playerBlock.y+tetr0mino.tetr0mino_normal[2].y+1].bitmap != null || tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[3].x][playerBlock.y+tetr0mino.tetr0mino_normal[3].y+1].bitmap != null){
                                    pass = false;
                                }
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                        }
                        break;
            }
            //ako nista nema ispod tetr0mina
            //pass= true;
            if(pass){
                updateBlock();
            }
            else{
                playerBlock.set(5, 2);
                //tetr0mino = new Tetr0mino((int)(Math.random()*7));
                tetr0mino = new Tetr0mino(1);
                orientation = 0;
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
