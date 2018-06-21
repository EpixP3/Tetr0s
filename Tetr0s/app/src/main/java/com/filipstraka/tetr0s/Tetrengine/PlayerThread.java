package com.filipstraka.tetr0s.Tetrengine;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Vibrator;

import com.filipstraka.tetr0s.R;

import java.io.IOException;

/**
 * Created by strak on 7.10.2017..
 * OVO JE KLASA KOJA IMA ULOGU DA POMERA PLAYER PIECE
 * NA OSNOVU DELAY-A KOJI SE MOZE PODESITI SA setDelay(long);
 */

public class PlayerThread extends Thread {
    private Tetrengine tetrengine;
    private boolean running;
    private long delay;
    private Point playerBlock = new Point();
    private Tetr0mino tetr0mino;
    private int orientation=0; //0 = 0, 1 = 90, 2 = 180, 3 = 270

    //konstruktor..
     PlayerThread(Tetrengine tetrengine){
        this.tetrengine = tetrengine;
        playerBlock.set(5,2);
        //tetr0mino = new Tetr0mino((int)(Math.random()*7));
        tetr0mino = new Tetr0mino(1, tetrengine);
    }

    //just cuz i can
    void setRunning(boolean running){
        this.running = running;
    }
    //just cuz i can
    void setDelay(long delay){
        this.delay = delay;
    }
    public void rotateLeft(){
        //TODO                       KOD ZA ROTATE LEFT
    }
    public void rotateRight(){
        //TODO                       KOD ZA ROTATE RIGHT
    }
    void moveLeft(){
        /*if(playerBlock.x > 0 && tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap == null) {
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
            playerBlock.set(playerBlock.x -1, playerBlock.y);
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
        }
        */
        //GORE JE STARI KOD SAMO ZA JEDAN BLOK

        boolean canMove = true;
        switch (orientation){
            case 0:
                if( playerBlock.x+tetr0mino.tetr0mino_normal[0].x > 0 && playerBlock.x+tetr0mino.tetr0mino_normal[1].x > 0 && playerBlock.x+tetr0mino.tetr0mino_normal[2].x > 0 && playerBlock.x+tetr0mino.tetr0mino_normal[3].x > 0){
                    //Nije Van granica
                    switch (tetr0mino.type){
                        case 0:
                            if(tetrengine.Map[playerBlock.x-2][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 1:
                            if(tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x-2][playerBlock.y+1].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y-1].bitmap != null){
                                canMove=false;
                            }break;
                        case 2:
                            if(tetrengine.Map[playerBlock.x-2][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 3:
                            if(tetrengine.Map[playerBlock.x-2][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x-2][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 4:
                            if(tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x-2][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 5:
                            if(tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y+1].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y-1].bitmap != null){
                                canMove=false;
                            }break;
                        case 6:
                            if(tetrengine.Map[playerBlock.x-1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y-1].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y-2].bitmap != null || tetrengine.Map[playerBlock.x-1][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                    }
                }else{
                    canMove=false;
                }break;
        }
        if(canMove) {
            //Play sound
            tetrengine.soundPool.play(tetrengine.soundID_move,1,1,1,0,1);
            //delete
            for (int i = 0; i < 4; i++) {
                tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_normal[i].x][playerBlock.y + tetr0mino.tetr0mino_normal[i].y].setBitmap(null);
            }
            playerBlock.set(playerBlock.x - 1, playerBlock.y);
            for (int i = 0; i < 4; i++) {
                tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_normal[i].x][playerBlock.y + tetr0mino.tetr0mino_normal[i].y].setBitmap(tetr0mino.typeImage);
            }
        }
        //TODO                       KOD ZA MOVE LEFT
    }
    void moveRight(){
        /*
        if(playerBlock.x < 9 && tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap == null) {
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(null);
            playerBlock.set(playerBlock.x + 1, playerBlock.y);
            tetrengine.Map[playerBlock.x][playerBlock.y].setBitmap(tetrengine.cyan);
        }
        */
        //GORE JE STARI KOD SAMO ZA JEDAN BLOK
        boolean canMove = true;
        switch (orientation){
            case 0:
                if( playerBlock.x+tetr0mino.tetr0mino_normal[0].x < 9 && playerBlock.x+tetr0mino.tetr0mino_normal[1].x < 9 && playerBlock.x+tetr0mino.tetr0mino_normal[2].x < 9 && playerBlock.x+tetr0mino.tetr0mino_normal[3].x < 9){
                    //Nije Van granica
                    switch (tetr0mino.type){
                        case 0:
                            if(tetrengine.Map[playerBlock.x+2][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 1:
                            if(tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y+1].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y-1].bitmap != null){
                                canMove=false;
                            }break;
                        case 2:
                            if(tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x+2][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 3:
                            if(tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 4:
                            if(tetrengine.Map[playerBlock.x+2][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                        case 5:
                            if(tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x+2][playerBlock.y+1].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y-1].bitmap != null){
                                canMove=false;
                            }break;
                        case 6:
                            if(tetrengine.Map[playerBlock.x+1][playerBlock.y].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y-1].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y-2].bitmap != null || tetrengine.Map[playerBlock.x+1][playerBlock.y+1].bitmap != null){
                                canMove=false;
                            }break;
                    }
                }else{
                    canMove=false;
                }break;
        }
        if(canMove) {
            //Play sound
            tetrengine.soundPool.play(tetrengine.soundID_move,1,1,1,0,1);
            //delete
            for (int i = 0; i < 4; i++) {
                tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_normal[i].x][playerBlock.y + tetr0mino.tetr0mino_normal[i].y].setBitmap(null);
            }
            playerBlock.set(playerBlock.x + 1, playerBlock.y);
            for (int i = 0; i < 4; i++) {
                tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_normal[i].x][playerBlock.y + tetr0mino.tetr0mino_normal[i].y].setBitmap(tetr0mino.typeImage);
            }
        }
        //TODO                       KOD ZA MOVE RIGHT
    }
    void drop(){
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
        //TODO                        KOD ZA DROP KADA SE STISNE STRELICA DOLE
    }
    void updateBlock(){
        switch(orientation){
            case 0:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_normal[i].x][playerBlock.y + tetr0mino.tetr0mino_normal[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_normal[i].x][playerBlock.y+tetr0mino.tetr0mino_normal[i].y].setBitmap(tetr0mino.typeImage);}break;
            case 1:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_90[i].x][playerBlock.y + tetr0mino.tetr0mino_90[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_90[i].x][playerBlock.y+tetr0mino.tetr0mino_90[i].y].setBitmap(tetr0mino.typeImage);}break;
            case 2:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_180[i].x][playerBlock.y + tetr0mino.tetr0mino_180[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_180[i].x][playerBlock.y+tetr0mino.tetr0mino_180[i].y].setBitmap(tetr0mino.typeImage);}break;
            case 3:for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x + tetr0mino.tetr0mino_270[i].x][playerBlock.y + tetr0mino.tetr0mino_270[i].y].setBitmap(null);}playerBlock.set(playerBlock.x, playerBlock.y + 1);
                for(int i=0; i<4; i++) {tetrengine.Map[playerBlock.x+tetr0mino.tetr0mino_270[i].x][playerBlock.y+tetr0mino.tetr0mino_270[i].y].setBitmap(tetr0mino.typeImage);}break;
        }
    }
    @Override
    public void run(){
        while(running){
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
            //pass = true;

            if(pass){
                updateBlock();
            }
            else{
                //Tetr0mino se ostavlja i generise se novi
                tetrengine.soundPool.play(tetrengine.soundID_drop,1,1,1,0,1);
                playerBlock.set(5, 2);
                tetr0mino = new Tetr0mino((int)(Math.random()*7), tetrengine);
                //tetr0mino = new Tetr0mino(1);
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
