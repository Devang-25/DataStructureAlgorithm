package arithmetic;

/**
 * Created by : Rakesh Gupta on 8/31/17
 * Package : arithmetic
 */
public class SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        System.out.println("Special Type of Pythagorus with condition (a*a+b*b=c*c) and (a+b+c=GivenNumber) ");
        int aPLUSbPLUSc = 1000;

        for (int a = 1; a <= aPLUSbPLUSc/3; a++) {

            for ( int b = a + 1; b <= aPLUSbPLUSc/2; b++) {

                int c = aPLUSbPLUSc - a - b;
                if ( a*a + b*b == c*c )
                    System.out.printf("a = %d, b = %d, c = %d\n",a,b,c);
            }
        }
        ;
    }
}
