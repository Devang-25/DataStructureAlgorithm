package math;

public class PowerOfTwoInteger {
    public int isPower(int num) {
        if (num == 1) return 1;

        int power = 2;
        int base = 2;
        boolean flag = false;

        while (true) {
            power = 2;
            while (true) {
                if (Math.pow(base, power) == num) {
                    flag = true;
                    break;
                } else if (Math.pow(base, power) > num) {
                    break;
                }
                power++;
            }
            base++;
            if (flag) break;
            else if (base > num) {
                break;
            }
        }
        return flag ? 1 : 0;
    }
}
