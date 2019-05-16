import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ruum  {
    private char[][] valjak;

    public Ruum(int suurus,double protsent){
        teeRuum(suurus,protsent);
    }
    public Ruum(char[][] ruum){
        valjak=ruum;
    }
    private void teeRuum(int suurus,double protsent) {//teeb ja prindib antud suurusega ruudu
        valjak = new char[suurus][suurus*3];//laius on 3 korda suurem et oleks rohkem ruudu kuju
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus*3; j++) {
                if(i>0&&i<valjak.length-1&&j>0&&j<valjak[1].length-1) {
                    if (Math.random() > protsent)
                        valjak[i][j] = ' ';
                    else
                        valjak[i][j] = '#';
                }
                else{
                    valjak[i][j] = '#';
                }
            }
        }
    }


    private boolean KontrolliPunkt(int kaugus,int i,int j) {
        return(i>kaugus-1&&i<valjak.length-kaugus&&j>kaugus-1&&j<valjak[1].length-kaugus);
    }
    public void muudaRuum(){

        char[][] uusValjak = new char[valjak.length][valjak[0].length];//teen uue valjaku nagu originaal
        for(int i=0; i<valjak.length; i++) {
            for (int j = 0; j < valjak[0].length; j++) {
                uusValjak[i][j] = valjak[i][j];
            }
        }


        for(int g=0;g<2;g++) {
            for (int i = 0; i < valjak.length - 1; i++) {
                for (int j = 0; j < valjak[1].length - 1; j++) {

                    if (KontrolliPunkt(2, i, j)){
                        if (loeNaabreid(i, j, 1) > 4 || loeNaabreid(i, j, 2) <= 2)//teeb korraparasekmaks ja taidab augud
                            uusValjak[i][j] = '#';
                        else
                            uusValjak[i][j] = ' ';
                    }
                }
            }
            for(int i=0; i<valjak.length; i++) {
                for (int j = 0; j < valjak[0].length; j++) {
                    valjak[i][j] = uusValjak[i][j];
                }
            }
        }
        for(int g=0;g<1;g++) {
            for (int i = 0; i < valjak.length - 1; i++) {
                for (int j = 0; j < valjak[1].length - 1; j++) {
                    if(KontrolliPunkt(1, i, j)) {
                        if (loeNaabreid(i, j, 1) > 4)//teeb veel korraparasemaks
                            uusValjak[i][j] = '#';
                        else
                            uusValjak[i][j] = ' ';
                    }
                }
            }
            for(int i=0; i<valjak.length; i++) {
                for (int j = 0; j < valjak[0].length; j++) {
                    valjak[i][j] = uusValjak[i][j];
                }
            }
        }
    }

    private int loeNaabreid(int i,int j,int kaugus) {//loeb kokku selle punkti umber olevad '#' margid antud kauguses
        int x = 0;
        //for (int a = 1; a < kaugus + 1; a++) {
            for (int c = -kaugus; c < kaugus + 1; c++) {
                for (int d = -kaugus; d < kaugus + 1; d++) {
                    if (!(c == 0 && d == 0)) {
                        if (valjak[i + c][j + d] == '#') {
                            x++;
                        }
                    }
                }
            }
        //}
        return x;
    }

    public void loeSisse(String failinimi) throws Exception {//loeb failist sisse erinevad mapid kui vaja salvestada
        List<String> teosed = new ArrayList<>();
        File fail = new File(failinimi);
        try (Scanner scan = new Scanner(fail, "UTF-8")) {
            while (scan.hasNextLine()) {
                String rida = scan.nextLine();
                char[] ridaMasiiv = rida.toCharArray();
                for (char taht : ridaMasiiv) {
                    if (Math.random() > 0.10) {
                        taht = 'O';
                    }
                    System.out.print(taht);
                }
                System.out.println();
            }
        }
    }
    public char[][] getRuum(){
        return valjak;
    }
    public void printRuum(){
        for (int i = 0; i < valjak.length; i++) {
            for (int j = 0; j < valjak[0].length; j++) {
                System.out.print(valjak[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void Exit() {
        while(true){
            try{
            int koht = (int)Math.round(Math.random() * valjak[1].length);
            if((koht != 0) || (koht != valjak[1].length)) {
                if (valjak[valjak.length - 2][koht] == ' ') {
                    valjak[valjak.length - 1][koht] = ' ';
                    break;
                }
            }
        } catch(ArrayIndexOutOfBoundsException e){
            }
        }
    }
}
