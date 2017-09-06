package bitmanipulation;

public class ReverseBit {
    public static void main(String[] args) {
        long n = 0L;
        String nBit = Long.toBinaryString(n);
        StringBuffer reverseBit = new StringBuffer(nBit).reverse();

        for (int i = reverseBit.length(); i < 32; i++) {
            reverseBit.append(0);
        }
        long ans = Long.parseLong(reverseBit.toString(), 2);
    }
}
