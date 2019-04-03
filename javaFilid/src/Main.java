import javax.sound.sampled.spi.AudioFileReader;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Automata tester = new Automata();
        //loe("base.txt");
        //tester.run();
        muudaRuum(muudaRuum(muudaRuum(teeRuum(25))));
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
                if (Math.random() > 0.70) {
                    ruum[i][j] = ' ';
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

    public static char[][] muudaRuum(char[][] ruum) {
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
