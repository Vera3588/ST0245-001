
import javax.tools.Diagnostic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scan {

    public Scan() {
    }

    public void readBicolor() throws FileNotFoundException {

        Scanner read = new Scanner(new File("Entrada.txt"));
        String line = read.nextLine();
        Scanner scanLine = new Scanner(line);
        DigraphAM1 am = null;
        //Tree t = new Tree();
        Algorithm A = new Algorithm();

        int nodos = scanLine.nextInt();
        while (nodos != 0) {
            am = new DigraphAM1(nodos);
            line = read.nextLine();
            scanLine = new Scanner(line);
            int aris = scanLine.nextInt();
            for (int i = 0; i < aris; i++) {
                line = read.nextLine();
                scanLine = new Scanner(line);
                am.addArc(scanLine.nextInt() + 1, scanLine.nextInt() + 1, 1);
            }
            line = read.nextLine();
            scanLine = new Scanner(line);
            nodos = scanLine.nextInt();
            //t.genTree(am);
            am.imprimir();
            if (Algorithm.DFSColorFC(am)){
                System.out.println("BICOLORABLE");
            }else{
                System.out.println("NO BICOLORABLE");
            }
        }
    }
}

