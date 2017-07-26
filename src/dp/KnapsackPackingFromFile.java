package dp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rakeshgupta on 7/26/17.
 */
public class KnapsackPackingFromFile {
    public static void main(String[] args) throws IOException {
        List<String> stream = Files.readAllLines(Paths.get("/home/rakeshgupta/Desktop/res.txt"));
        for (String s : stream){
            String[] sArr = s.split("( * )");
            int W = Integer.parseInt(sArr[0]);
            List<PackageItem> packageItemList = new ArrayList<>();

            for (int i=2; i<sArr.length; i++){
                PackageItem packageItem = new PackageItem();
                String[] oneNode = (sArr[i].replace('(',' ').replace(')',' ').replace('$', ' ')).split(",");
                packageItem.index = Integer.parseInt(oneNode[0].substring(1));
                packageItem.weight = Double.parseDouble(oneNode[1]);
                packageItem.price = Integer.parseInt(oneNode[2].substring(1,oneNode[2].length()-1));
               packageItemList.add(packageItem);
            }

            Collections.sort(packageItemList, new Comparator<PackageItem>() {
                @Override
                public int compare(PackageItem o1, PackageItem o2) {
                    if (o1.getWeight() > o2.getWeight())
                        return 1;
                    else
                        return -1;
                }
            });
            System.out.println(Arrays.toString(sArr));
            StringBuilder ans = getKnapsackItems(packageItemList, W);
            if (ans.toString().length() != 0)
                System.out.println(ans.substring(0, ans.length()-1));
            else
                System.out.println(ans);
        }
    }

    private static StringBuilder getKnapsackItems(List<PackageItem> packageItemList, int W) {
        int n = packageItemList.size();
        StringBuilder[][] items = new StringBuilder[n+1][W+1];
        double[][] K = new double[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i ==0 || w == 0) {
                    K[i][w] = 0;
                    items[i][w] = new StringBuilder("");
                } else if (  (packageItemList.get(i-1).weight) <= w ) {

                            if ( ( packageItemList.get(i-1).price + K[i-1][w- (int)(packageItemList.get(i-1).weight)]) > K[i-1][w]){

                                K[i][w] = packageItemList.get(i-1).price + K[i-1][(int) (w-  (packageItemList.get(i-1).weight))];

                                items[i][w] = new StringBuilder( packageItemList.get(i-1).index +  ","+ items[i-1][(w - (int)(packageItemList.get(i - 1).weight))] );

                            }else {
                                K[i][w] = K[i-1][w];
                                items[i][w] = items[i-1][w];
                            }

                }else {
                    K[i][w] = K[i-1][w];
                    items[i][w] = items[i-1][w];
                }
            }
        }
        return items[n][W];
//        return K[n][W];
    }
}
class PackageItem {
    int index;
    double weight;
    int price;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PackageItem{" +
                "index=" + index +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
