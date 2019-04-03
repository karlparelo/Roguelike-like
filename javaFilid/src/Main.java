import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        loe("base.txt");
    }

    public static void loe(String failinimi) throws Exception {
        List<String> teosed = new ArrayList<>();
        File fail = new File(failinimi);
        try (Scanner scan = new Scanner(fail, "UTF-8")) {
            while (scan.hasNextLine()) {
                String rida = scan.nextLine();
                char[] ridaMasiiv=rida.toCharArray();
                for(char taht:ridaMasiiv){
                    if(Math.random()>0.10){
                        taht='a';
                    }
                    System.out.print(taht);
                }
                System.out.println();
            }
        }
    }
}
