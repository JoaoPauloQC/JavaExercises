package Sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static List<Double> BubbleSort (List<Double> nums){
        List<Double> ordeneredNums = new ArrayList<>();
        ordeneredNums.add(nums.get(0));

        return (ordering(nums,ordeneredNums));
    }
    public static List<Double>  ordering(List<Double> nums, List<Double> orderedNums ) {

        for (int index = 1; index < nums.size(); index++) {
            double currentnum = nums.get(index);
            double numberBehind = orderedNums.get(index - 1);
            if (currentnum > orderedNums.get(index - 1)) {
                orderedNums.add(nums.get(index));
            } else {
                List<Double> higherNums = new ArrayList<>();
                int indexOfOrdenered = orderedNums.size()-1;
                while(true){

                    if (orderedNums.isEmpty()){
                        orderedNums.add(nums.get(index));
                        if (!higherNums.isEmpty()){
                            for (int j = higherNums.size()-1; j >= 0; j--){
                                orderedNums.add(higherNums.get(j));
                            }
                        }
                        break;
                    }

                    if(orderedNums.get(indexOfOrdenered) > nums.get(index) ){
                        double currentOrdenered = orderedNums.get(indexOfOrdenered);
                        higherNums.add(orderedNums.get(indexOfOrdenered));
                        orderedNums.remove(orderedNums.get(indexOfOrdenered));

                        indexOfOrdenered = indexOfOrdenered-1;
                    }
                    else{

                        orderedNums.add(nums.get(index));
                        if (!higherNums.isEmpty()){
                            for (int j = higherNums.size()-1; j >= 0; j--){
                                orderedNums.add(higherNums.get(j));
                            }
                        }
                        index = orderedNums.size()-1;
                        break;
                    }

                }


            }
        }
        return orderedNums;
    }

}
