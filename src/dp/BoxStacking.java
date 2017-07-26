package dp;

import java.util.Arrays;

/**
 * Created by rakeshgupta on 7/27/17.
 */
public class BoxStacking {
    public static void main(String[] args) {
        BoxDimension input[] = { new BoxDimension(3,2,5), new BoxDimension(1,2,4)};
        int height = boxHeight(input);
        System.out.println("Max Height : " + height);
    }

    private static int boxHeight(BoxDimension[] input) {

        BoxDimension allRotationInput[] = new BoxDimension[input.length*3];
        createAllRotation(input, allRotationInput);
        Arrays.sort(allRotationInput);
        int T[] = new int[allRotationInput.length];
        int result[] = new int[allRotationInput.length];

        for (int i = 0; i < T.length; i++) {
            T[i] = allRotationInput[i].height;
            result[i] = i;
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 0; j < i; j++) {
                if (allRotationInput[i].length < allRotationInput[j].length
                        && allRotationInput[i].width < allRotationInput[j].width) {
                    if( T[j] + allRotationInput[i].height > T[i]){
                        T[i] = T[j] + allRotationInput[i].height;
                        result[i] = j;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i < T.length; i++){
            if(T[i] > max){
                max = T[i];
            }
        }

        return max;
    }

    private static void createAllRotation(BoxDimension[] input, BoxDimension[] allRotationInput) {
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            allRotationInput[index++] = BoxDimension.createDimension(input[i].height, input[i].length, input[i].width);

            allRotationInput[index++] = BoxDimension.createDimension(input[i].length, input[i].height, input[i].width);

            allRotationInput[index++] = BoxDimension.createDimension(input[i].width, input[i].length, input[i].height);

        }
    }

    private static class BoxDimension implements Comparable<BoxDimension>{
        int height, width, length;

        public BoxDimension(int height, int width, int length) {
            this.height = height;
            this.width = width;
            this.length = length;
        }

        public BoxDimension() {
        }

        static BoxDimension createDimension(int height, int side1, int side2){
            BoxDimension boxDimension = new BoxDimension();
            boxDimension.height = height;
            if (side1 >= side2){
                boxDimension.length = side1;
                boxDimension.width = side2;
            }else {
                boxDimension.width = side1;
                boxDimension.length = side2;
            }
            return boxDimension;
        }

        @Override
        public int compareTo(BoxDimension d) {
            if (this.length * this.width >= d.length * d.width) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "BoxDimension{" +
                    "height=" + height +
                    ", width=" + width +
                    ", length=" + length +
                    '}';
        }
    }
}
