package homework_1;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = bubbleMethod(new int[]{2,4,7,1,8,44,3,5,9});
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] bubbleMethod(int[] arr){// метод сортировки пузырьком
        boolean sort = false;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                int a = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = a;
                sort = true;
            }
        }
        return sort?bubbleMethod(arr): arr;
    }
}
