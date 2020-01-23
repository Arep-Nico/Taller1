package escuelaing.arep.meanStandard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
* @author Nicolas Cardenas
* @version: 22/01/2019
*/
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkedList<Double> a = new LinkedList<Double>();
        a.add(186.0);
        a.add(699.0);
        a.add(132.0);
        a.add(272.0);
        a.add(291.0);
        a.add(331.0);
        a.add(199.0);
        a.add(1890.0);
        a.add(788.0);
        a.add(1601.0);
        System.out.println(MeanAndStandard.mean(a));
        System.out.println(MeanAndStandard.standard(a));
        // MeanAndStandard.mean(a);
    }

    public static LinkedList<Double> reader(String path) throws IOException {
        LinkedList<Double> l = new LinkedList<Double>();
        File file = new File(path);
        BufferedReader buf = new BufferedReader(new FileReader(file));

        String line = buf.readLine();
        while (line != null || line.length() != 0) {
            l.add(Double.parseDouble(line));
            line = buf.readLine();
        }
        buf.close();
        return l;
    }
}
