import javax.sound.sampled.spi.AudioFileReader;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //loe("base.txt");
        muudaRuum(muudaRuum(muudaRuum(teeRuum(20))));
    }

    public static void loe(String failinimi) throws Exception {
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

    public static char[][] teeRuum(int suurus) {
        char[][] ruum = new char[suurus][suurus*3];
        for (int i = 0; i < suurus; i++) {
            for (int j = 0; j < suurus*3; j++) {
                if(i>0&&i<ruum.length-1&&j>0&&j<ruum[1].length-1) {
                    if (Math.random() > 0.40) {
                        ruum[i][j] = ' ';
                    } else {
                        ruum[i][j] = '#';
                    }
                }
                else{
                    ruum[i][j] = '#';
                }
                System.out.print(ruum[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        return ruum;
    }
    public static int loeNaabreid(int i,int j,char[][] ruum,int kaugus) {
        int x = 0;
        for (int a = 1; a < kaugus + 1; a++) {
            for (int c = -kaugus; c < kaugus + 1; c++) {
                for (int d = -kaugus; d < kaugus + 1; d++) {
                    if (c == 0 && d == 0) {
                        continue;
                    }
                    else {
                        if (ruum[i + c][j + d] == '#') {
                            x++;
                        }
                    }
                }
            }
        }
        return x;
    }
    public static char[][] muudaRuum(char[][] ruum) {
        for (int i = 1; i < ruum.length-1; i++) {
            for (int j = 0; j < ruum[1].length-1; j++) {
                if(i>1&&i<ruum.length-2&&j>1&&j<ruum[1].length-2){
                    if(loeNaabreid(i,j,ruum,2)<1){
                        ruum[i][j] = '#';
                    }
                }
                if(i>0&&i<ruum.length-1&&j>0&&j<ruum[1].length-1){
                    if((loeNaabreid(i,j,ruum,1)>3&&ruum[i][j]=='#')||(loeNaabreid(i,i,ruum,1)>4&&ruum[i][j]==' ')){
                        ruum[i][j] = '#';
                    }
                    else{
                        ruum[i][j] = ' ';
                    }
                }
                System.out.print(ruum[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        return ruum;
    }
    public static char[][] muudaaared(char[][] ruum) {
        for (int i = 0; i < ruum.length; i++) {
            for (int j = 0; j < ruum[1].length; j++) {
                if(i>0&&i<ruum.length-1&&j>0&&j<ruum[1].length-1){
                    int x=0;
                    if(ruum[i-1][j-1]=='#'){x++;}
                    if(ruum[i-1][j]=='#'){x++;}
                    if(ruum[i-1][j+1]=='#'){x++;}

                    if(ruum[i][j-1]=='#'){x++;}
                    if(ruum[i][j+1]=='#'){x++;}

                    if(ruum[i+1][j-1]=='#'){x++;}
                    if(ruum[i+1][j]=='#'){x++;}
                    if(ruum[i+1][j+1]=='#'){x++;}

                    if(x<4){
                        ruum[i][j] = ' ';
                    }
                }
                System.out.print(ruum[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        return ruum;
    }
}
