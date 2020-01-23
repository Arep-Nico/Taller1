package escuelaing.arep.meanStandard;

/* 
* @author Nicolas Cardenas
* @version: 22/01/2019
*/
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LinkedList<Double> a = new LinkedList<Double>();
        a.add(1.0);
        a.add(3.0);
        MeanAndStandard.mean(a);
    }
}
