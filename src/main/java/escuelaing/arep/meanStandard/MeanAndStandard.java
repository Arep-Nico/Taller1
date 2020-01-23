package escuelaing.arep.meanStandard;

/* 
* @author Nicolas Cardenas
* @version: 22/01/2019
*/
public class MeanAndStandard {

    MeanAndStandard() {
    }

    public static double mean(LinkedList<Double> list) {
        double res = 0.0;
        for (double double1 : list) {
            res += double1;
        }
        return res / list.size();
    }

    public static double standard(LinkedList<Double> list) {
        double mean =  MeanAndStandard.mean(list);
        double sum = 0.0;
        for (Double double1 : list) {
            sum += Math.pow((double1 - mean), 2);
        }
        double div = sum / (list.size() - 1);
        return Math.sqrt(div);
    }
}