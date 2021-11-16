package com.example.differentcolor.object;

import java.util.Random;

public class DinhNghia {

    public int soCot = 8;
    public int soO = 7;
    public  String mauNhieu = "#FF0000";
    public  String mauIt = "#FA5858";

    private String arrMauNhieu[] = new String[]{
            "#FF0000",
            "#FFFF00",
            "#40FF00",
            "#00FFFF",
            "#0000FF",
            "#FF00FF",
    };

    private String arrMauIt[] = new String[]{
            "#F78181",
            "#F3F781",
            "#9FF781",
            "#A9F5F2",
            "#2E64FE",
            "#F781D8",
    };

    public int leverl = 1;



    public void layMauNgauNhien(){
        Random r = new Random();
        int vt = r.nextInt(arrMauNhieu.length);
        mauNhieu = arrMauNhieu[vt];
        mauIt = arrMauIt[vt];

    }

    public void setLeverl(){
        if (leverl < 3){
            soCot = 2;
        }else if(leverl<10){
            soCot = 3;
        }
        else if(leverl<20){
            soCot = 4;
        }
        else if(leverl<35){
            soCot = 5;
        }
        else {
            soCot = 7;
        }

        soO = soCot*soCot;
    }
}
