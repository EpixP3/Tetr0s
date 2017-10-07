package com.filipstraka.tetr0s.Tetrengine;

/**
 * Created by strak on 7.10.2017..
 * OVO JE KLASA KOJA IMA ULOGU DA POMERA PLAYER PIECE
 * NA OSNOVU DELAY-A KOJI SE MOZE PODESITI SA setDelay(long);
 */

public class PlayerThread extends Thread {
    Tetrengine tetrengine;
    boolean running;
    long delay;
    int x=1;

    //konstruktor..
    public PlayerThread(Tetrengine tetrengine){
        this.tetrengine = tetrengine;
    }

    //just cuz i can
    public void setRunning(boolean running){
        this.running = running;
    }
    //just cuz i can
    public void setDelay(long delay){
        this.delay = delay;
    }
    @Override
    public void run(){
        while(running){
            //Ovde je kod koji se izvrsava svakih <delay> sekundi

            //ovo samo simulira blok koji pada
            if(x-1 >= 0) {
                tetrengine.Map[3][x-1].setBitmap(null);
            }
            tetrengine.Map[3][x].setBitmap(tetrengine.blue);
            x++;

            //delay
            try {
                sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
