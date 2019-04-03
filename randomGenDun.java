import java.io.FileNotFoundException;
import java.util.*;

public class randomGenDun {
    public static void main(String[] args) throws FileNotFoundException {
        openFile("base.txt");
    }

    private static String gen(String str) {
        StringBuilder sb = new StringBuilder(str);
        //int i = 0;
        for (int j = 0; j < str.length(); j++) {
            double a = Math.random() * 0.75;
                if(a > 0.60){
                    sb.insert(j,'#');
                    sb.deleteCharAt(j+1);
                }
            }
        str = sb.toString();
        System.out.println(str);
        return str;
    }

    private static void openFile(String filename) throws FileNotFoundException {
        java.io.File file = new java.io.File("base.txt");
        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] rida2 = rida.split("\n");
                for (String elem: rida2
                     ) {
                    gen(elem);
                }
            }
        }
    }
}
