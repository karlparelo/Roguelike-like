import javax.sound.sampled.spi.AudioFileReader;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ruum valjak=new Ruum(20,0.38);
            valjak.printRuum();
            valjak.muudaRuum();
            valjak.printRuum();


    }
}
