package dp;

/**
 * Created by rakeshgupta on 8/1/17.
 */
public class EggDroppingProblem {
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 36;

        int minNumberOfTrials = getMinTrialsInWorstCaseToBreakEgg(floors, eggs);
        System.out.println("Min no of trials in worst case with " + eggs + " eggs and " + floors + " floor is : " + minNumberOfTrials);
    }

    private static int getMinTrialsInWorstCaseToBreakEgg(int floors, int eggs) {
        int eggFloor[][] = new int[eggs+1][floors+1];
        int res = 0;

        for (int i = 1; i <=eggs; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (int i = 1; i <= floors; i++) {
            eggFloor[1][i] = i;
        }

        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {

                eggFloor[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                        res = 1 + Math.max(eggFloor[i-1][k-1], eggFloor[i][j-k]);
                        if (res < eggFloor[i][j])
                            eggFloor[i][j] = res;
                }
            }
        }
        return eggFloor[eggs][floors];
    }
}
