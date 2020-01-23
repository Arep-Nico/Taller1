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
}
