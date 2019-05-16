public class Koletis {
    int setsuund() {
        int x = (int) Math.round((Math.random() * 2) + 1);
        return x;
        /*2 on "liigub paremale, 1 on "liigub vasakule"*/
    }

    int[] Spawn(char[][] field) throws ArrayIndexOutOfBoundsException {
        int[] koletisKordinaadid = new int[2];
        while (true) {
            try {
                int x = (int) Math.round(Math.random() * field[1].length);
                int y = (int) Math.round(Math.random() * field[1].length);
                if (field[x][y] == ' ') {
                    field[x][y] = 'K';
                    koletisKordinaadid[0] = x;
                    koletisKordinaadid[1] = y;
                    return koletisKordinaadid;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    void End() {
        System.out.println("Kaotasid!");
        System.exit(0);
    }

    int Move(int[] koletisKordinaadid, char[][] field, int suund){
        if (suund == 2) { /*paremale*/
            if (field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] == '@') {
                field[koletisKordinaadid[0]][koletisKordinaadid[1]] = ' ';
                field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] = 'K';
                End();
            }
            if (field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] == '#' || field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] == 'K') {
                field[koletisKordinaadid[0]][koletisKordinaadid[1]] = ' ';
                field[koletisKordinaadid[0]][koletisKordinaadid[1] - 1] = 'K';
                koletisKordinaadid[1] = koletisKordinaadid[1] - 1;
                return 1;
            }
            if (field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] == ' ') {
                field[koletisKordinaadid[0]][koletisKordinaadid[1]] = ' ';
                field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] = 'K';
                koletisKordinaadid[1] = koletisKordinaadid[1] + 1;
            }
        } else { /*vasakule*/
            if (field[koletisKordinaadid[0]][koletisKordinaadid[1] - 1] == '@') {
                field[koletisKordinaadid[0]][koletisKordinaadid[1]] = ' ';
                field[koletisKordinaadid[0]][koletisKordinaadid[1] - 1] = 'K';
                End();
            }
            if (field[koletisKordinaadid[0]][koletisKordinaadid[1] - 1] == '#' || field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] == 'K') {
                field[koletisKordinaadid[0]][koletisKordinaadid[1]] = ' ';
                field[koletisKordinaadid[0]][koletisKordinaadid[1] + 1] = 'K';
                koletisKordinaadid[1] = koletisKordinaadid[1] + 1;
                return 2;
            }
            if (field[koletisKordinaadid[0]][koletisKordinaadid[1] - 1] == ' ') {
                field[koletisKordinaadid[0]][koletisKordinaadid[1]] = ' ';
                field[koletisKordinaadid[0]][koletisKordinaadid[1] - 1] = 'K';
                koletisKordinaadid[1] = koletisKordinaadid[1] - 1;
            }
        }
        return suund;
    }
}
