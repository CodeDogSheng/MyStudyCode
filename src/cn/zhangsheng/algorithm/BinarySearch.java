package cn.zhangsheng.algorithm;

/**
 * @author 张胜
 * @date 2021年07月01日14时42分创建
 * @description
 */
public class BinarySearch {

    public static boolean binarySearch(int[] numberArray,int target){
        int left = 0;
        int right = numberArray.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == numberArray[mid]){
                return true;
            }else if(target > numberArray[mid]){
                left = mid + 1;
            }else if(target < numberArray[mid]){
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] numberArray = new int[]{1,2,3,4,5,6,7,8};
        System.out.println("result is " + BinarySearch.binarySearch(numberArray,8));
    }
}
