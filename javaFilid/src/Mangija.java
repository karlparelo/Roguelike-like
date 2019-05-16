import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mangija {
    int[] kordinaadid = new int[2];

    void Spawn(char[][] field){
        while(true){
        try{
            int koht = (int)Math.round(Math.random() * field[1].length);
            if(field[1][koht] == ' '){
                field[1][koht] = '@';
                kordinaadid[0] = 1;
                kordinaadid[1] = koht;
                break;
            }
        } catch(ArrayIndexOutOfBoundsException e){
        }
        }
    }

    boolean win(char[][] valjak){
        if(kordinaadid[0] == valjak.length-1){
            System.out.println("Võitsid!");
            return false;
        }
        return true;
    }

    void Kontrolli(char[][] field, int i, int[] kordinaadid) throws Exception, ArrayIndexOutOfBoundsException {
        if (i == 0) { /*yles*/
            if (field[(kordinaadid[0] - 1)][kordinaadid[1]] == ' ') {
                field[kordinaadid[0]][kordinaadid[1]] = ' ';
                field[(kordinaadid[0] - 1)][kordinaadid[1]] = '@';
                kordinaadid[0] = kordinaadid[0] - 1;
            }
            if (field[(kordinaadid[0] - 1)][kordinaadid[1]] == 'K') {
                field[kordinaadid[0]][kordinaadid[1]] = ' ';
                Main.End();
            }
        }
        if (i == 1) { /*vasakule*/
            if (field[kordinaadid[0]][(kordinaadid[1] - 1)] == ' ') {
                field[kordinaadid[0]][kordinaadid[1]] = ' ';
                field[kordinaadid[0]][(kordinaadid[1] - 1)] = '@';
                kordinaadid[1] = kordinaadid[1] - 1;
            }
            if (field[(kordinaadid[0] - 1)][kordinaadid[1] - 1] == 'K') {
                field[kordinaadid[0]][kordinaadid[1]] = ' ';
                Main.End();
            }
        }
        if (i == 2) { /*alla*/
            if (field[(kordinaadid[0] + 1)][kordinaadid[1]] == ' ') {
                field[kordinaadid[0]][kordinaadid[1]] = ' ';
                field[kordinaadid[0] + 1][kordinaadid[1]] = '@';
                kordinaadid[0] = kordinaadid[0] + 1;
            }
            try {
                if (field[(kordinaadid[0] + 1)][kordinaadid[1]] == 'K') {
                    field[kordinaadid[0]][kordinaadid[1]] = ' ';
                    Main.End();
                }
            } catch(ArrayIndexOutOfBoundsException e) {
            }
        }
        if (i == 3) { /*paremale*/
            if (field[kordinaadid[0]][(kordinaadid[1] + 1)] == ' ') {
                field[kordinaadid[0]][kordinaadid[1]] = ' ';
                field[kordinaadid[0]][kordinaadid[1] + 1] = '@';
                kordinaadid[1] = kordinaadid[1] + 1;
            }
            try{
            if (field[(kordinaadid[0])][kordinaadid[1] + 1] == 'K') {
                field[kordinaadid[0]][kordinaadid[1]] = ' ';
                Main.End();
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        }

    }

    void Liigu(char[][] field) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        if (in.equals("w")) {
            Kontrolli(field, 0, kordinaadid);
        }
        if (in.equals("a")) {
            Kontrolli(field, 1, kordinaadid);
        }
        if (in.equals("s")) {
            Kontrolli(field, 2, kordinaadid);
        }
        if (in.equals("d")) {
            Kontrolli(field, 3, kordinaadid);
        }
    }
}
