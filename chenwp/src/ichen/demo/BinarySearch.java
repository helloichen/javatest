package ichen.demo;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 23, 34, 45, 56, 67, 77, 89, 90};
        System.out.println(doSearch(arr, 12));
        System.out.println(doSearch(arr, 45));
        System.out.println(doSearch(arr, 67));
        System.out.println(doSearch(arr, 89));
        System.out.println(doSearch(arr, 99));
    }

    public static int doSearch(int[] arr, int key) {
        //查询区间起止位置
        int start = 0;
        int end = arr.length - 1;
        //循环判断起止是否是同一位置
        while (start <= end) {
            //选择中轴位置
            int middle = (start + end) / 2;
            if (key < arr[middle]) {
                //中轴位置小于目标值，则在右侧继续查询
                end = middle - 1;
            } else if (key > arr[middle]) {
                //中轴位置大于目标值，则在左侧继续查询
                start = middle + 1;
            } else {
                //返回目标值所在下标
                return middle;
            }
        }
        //未查询到目标值返回-1
        return -1;
    }
}
