package bitmanipulation;

public class DivideIntegerWithoutOperator {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;

        System.out.println("Ans : " + divide(a,b));
    }

    public static int divide(int dividend, int divisor) {

        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int result = 0;
        while(pDividend>=pDivisor){

            int numShift = 0;
            while(pDividend>=(pDivisor<<numShift)){
                numShift++;
            }


            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }

        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }else{
            return -result;
        }
    }
}
