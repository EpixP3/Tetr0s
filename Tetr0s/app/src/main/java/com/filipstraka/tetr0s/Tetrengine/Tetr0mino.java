package com.filipstraka.tetr0s.Tetrengine;

import android.graphics.Point;

/**
 * Created by strak on 8.10.2017..
 */

public class Tetr0mino {
    Point[] tetr0mino_normal = new Point[4]; // normalan
    Point[] tetr0mino_90 = new Point[4]; //90 stepeni okrenut
    Point[] tetr0mino_180 = new Point[4]; //180 stepeni okrenut
    Point[] tetr0mino_270 = new Point[4]; //270 stepeni okrenut
    public int type;
    public Tetr0mino(int type){
        this.type = type;
        /*
        TYPE:
        0 - T
        1 - J
        2 - Z
        3 - 0
        4 - S
        5 - L
        6 - I
        http://meatfighter.com/nintendotetrisai/0.png
        */
        if(type == 0){
            //TYPE: T

            //   #
            //  #0#
            tetr0mino_normal[0].set(0,0);
            tetr0mino_normal[1].set(-1,0);
            tetr0mino_normal[2].set(1,0);
            tetr0mino_normal[3].set(0,1);
            //  #
            //  0#
            //  #
            tetr0mino_90[0].set(0,0);
            tetr0mino_90[1].set(0,1);
            tetr0mino_90[2].set(1,0);
            tetr0mino_90[3].set(0,-1);
            //  #0#
            //   #
            tetr0mino_180[0].set(0,0);
            tetr0mino_180[1].set(-1,0);
            tetr0mino_180[2].set(1,0);
            tetr0mino_180[3].set(0,-1);
            //   #
            //  #0
            //   #
            tetr0mino_270[0].set(0,0);
            tetr0mino_270[1].set(-1,0);
            tetr0mino_270[2].set(0,1);
            tetr0mino_270[3].set(0,-1);
        }
        else if(type == 1){
            //TYPE: J
            tetr0mino_normal[0].set(0,0);
            tetr0mino_normal[1].set(0,-1);
            tetr0mino_normal[2].set(0,1);
            tetr0mino_normal[3].set(-1,1);
            //  #
            //  0#
            //  #
            tetr0mino_90[0].set(0,0);
            tetr0mino_90[1].set(-1,0);
            tetr0mino_90[2].set(-1,-1);
            tetr0mino_90[3].set(1,0);
            //  #0#
            //   #
            tetr0mino_180[0].set(0,0);
            tetr0mino_180[1].set(1,-1);
            tetr0mino_180[2].set(0,-1);
            tetr0mino_180[3].set(0,1);
            //   #
            //  #0
            //   #
            tetr0mino_270[0].set(0,0);
            tetr0mino_270[1].set(-1,0);
            tetr0mino_270[2].set(0,1);
            tetr0mino_270[3].set(1,1);




        }else if(type == 2){
            //TYPE: Z

            tetr0mino_normal[0].set(0,0);
            tetr0mino_normal[1].set(-1,0);
            tetr0mino_normal[2].set(0,1);
            tetr0mino_normal[3].set(1,1);
            //  #
            //  0#
            //  #
            tetr0mino_90[0].set(0,0);
            tetr0mino_90[1].set(1,-1);
            tetr0mino_90[2].set(1,0);
            tetr0mino_90[3].set(0,1);
            //  #0#
            //   #

        }else if(type == 3){
            //TYPE: O
            tetr0mino_normal[0].set(0,0);
            tetr0mino_normal[1].set(-1,0);
            tetr0mino_normal[2].set(-1,1);
            tetr0mino_normal[3].set(0,1);

        }else if(type == 4){
            //TYPE: S


            tetr0mino_normal[0].set(0,0);
            tetr0mino_normal[1].set(1,0);
            tetr0mino_normal[2].set(0,1);
            tetr0mino_normal[3].set(-1,1);
            //  #
            //  0#
            //  #
            tetr0mino_90[0].set(0,0);
            tetr0mino_90[1].set(0,-1);
            tetr0mino_90[2].set(1,0);
            tetr0mino_90[3].set(1,1);
            //  #0#
            //   #

        }else if(type == 5){
            //TYPE: L

            //   #
            //  #0#
            tetr0mino_normal[0].set(0,0);
            tetr0mino_normal[1].set(0,-1);
            tetr0mino_normal[2].set(1,1);
            tetr0mino_normal[3].set(0,1);
            //  #
            //  0#
            //  #
            tetr0mino_90[0].set(0,0);
            tetr0mino_90[1].set(-1,0);
            tetr0mino_90[2].set(1,0);
            tetr0mino_90[3].set(-1,1);
            //  #0#
            //   #
            tetr0mino_180[0].set(0,0);
            tetr0mino_180[1].set(-1,-1);
            tetr0mino_180[2].set(0,1);
            tetr0mino_180[3].set(0,-1);
            //   #
            //  #0
            //   #
            tetr0mino_270[0].set(0,0);
            tetr0mino_270[1].set(1,-1);
            tetr0mino_270[2].set(1,0);
            tetr0mino_270[3].set(-1,0);

        }else if(type == 6){
            //TYPE I

//   #
            //  #0#
            tetr0mino_normal[0].set(0,-2);
            tetr0mino_normal[1].set(0,-1);
            tetr0mino_normal[2].set(0,0);
            tetr0mino_normal[3].set(0,1);
            //  #
            //  0#
            //  #
            tetr0mino_90[0].set(-2,0);
            tetr0mino_90[1].set(-1,0);
            tetr0mino_90[2].set(0,0);
            tetr0mino_90[3].set(1,0);
            //  #0#
            //   #
        }


    }
}
