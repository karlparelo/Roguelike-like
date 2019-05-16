import javax.sound.sampled.spi.AudioFileReader;
import java.awt.event.KeyListener;
import java.io.Console;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Roguelike on mängužanr, mis sai alguse 1980. aastal mänguga Rogue. Sina oled sümbol @ ning vaenlased on K.");
        System.out.println("Kasuta W-A-D-S, et jõuda kaardi lõpus olevasse auku.");
        Ruum valjak=new Ruum(10,0.38);
        Mangija mangija = new Mangija();
        Koletis koletis = new Koletis();
        Koletis koletis1 = new Koletis();
        Koletis koletis2 = new Koletis();
        Koletis koletis3 = new Koletis();

        valjak.muudaRuum();
        char[][] field = valjak.getRuum();

        mangija.Spawn(field);
        int[] koletisKordinaadid = koletis.Spawn(field);
        int[] koletisKordinaadid1 = koletis1.Spawn(field);
        int[] koletisKordinaadid2 = koletis2.Spawn(field);
        int[] koletisKordinaadid3 = koletis3.Spawn(field);

        valjak.Exit();
        valjak.printRuum();

        int suund = koletis.setsuund();
        int suund1 = koletis1.setsuund();
        int suund2 = koletis2.setsuund();
        int suund3 = koletis3.setsuund();


        while(mangija.win(valjak.getRuum())){
            /*Writer writer = new PrintWriter(System.out);*/
            mangija.Liigu(field);
            suund = koletis.Move(koletisKordinaadid, field, suund);
            suund1 = koletis1.Move(koletisKordinaadid1, field, suund1);
            suund2 = koletis2.Move(koletisKordinaadid2, field, suund2);
            suund3 = koletis3.Move(koletisKordinaadid3, field, suund3);
            /*writer.flush();*/
            valjak.printRuum();
        }
    }

    static void End(){
        System.out.println("Kaotasid!");
        System.exit(0);
    }
}
