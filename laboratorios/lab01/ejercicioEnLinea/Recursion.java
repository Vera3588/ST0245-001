/**
 * Solution of recusion's excersices 1 & 2 
 * 
 * @author (Tomas Marin - Juan Vera) 
 * @version (23/08/2020)
 */
public class Recursion
{
    /**Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
     * factorial(1) → 1
     * factorial(2) → 2
     * factorial(3) → 6
     */
    public int factorial(int n){
        if(n == 1){  
            return 1;  //c1 = 3
        }
        return n*factorial(n-1);  //T(n)=c2 + T(n-1)  donde c2 es 3
        //T(n) = (c1 - c2) Γ(n + 1) + e c2 Γ(n + 1, 1) 
    }

    /**
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     * bunnyEars2(0) → 0
     * bunnyEars2(1) → 2
     * bunnyEars2(2) → 5
     */
    public int bunnyEars(int bunnies) {
        if(bunnies == 0){
            return 0;     //T(n) = c1 donde c1 es 3
        }
        return bunnies*2; //T(n)=c2 donde c2 es 2     T(n)= c2 + n*2 

    }

    /** The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
     * fibonacci(0) → 0
     * fibonacci(1) → 1
     * fibonacci(2) → 1
     */
    public int fibonacci(int n) {
        if(n == 0){  
            return 0;  //C_1 donde es 3
        }
        if(n == 1){   
            return 1;  //C_2, donde es 3
        }
        if(n ==2){  
            return 1;  //C_3, donde es 3
        }
        return fibonacci(n-1)+fibonacci(n-2);  //T(n)=C_4 + T(n-1)+T(n-2)    
        // wolfram alfa  T(n) = -C_4 + c_1 F_n + c_2 L_n
    }

    /** We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even 
     * bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     * bunnyEars2(0) → 0
     * bunnyEars2(1) → 2
     * bunnyEars2(2) → 5
     */
    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0; // c1 = 3
        } else if (bunnies % 2 == 0) {
            return bunnyEars2(bunnies - 1) + 3;  //T(0)=c2, dende c es 7// T(n)=c2 + T(n-1) 
        } else {
            return bunnyEars2(bunnies-1) + 2; //T(0)=c3, dende c3 es 4 // T(n)=c3 + T(n-1)
            //T(n) = c_3 n + c_1 
        }
    }

    /**We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
     * triangle(0) → 0
     *triangle(1) → 1
     *triangle(2) → 3
     */
    public int triangle(int rows) {
        if (rows == 0){ 
            return 0; //T(n) = c1 donde c1 = 3
        }
        return rows + triangle(rows-1);  // T(n) = c2 = 3        
        //T(n)= C2 + T(n-1)
        //T(n) = c2*n + c1
    }

    // Recurcion 2

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target? This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem, you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array, our convention is to consider the part of the array starting at index start and continuing to the end of the array. The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.
     * groupSum(0, [2, 4, 8], 10) → true
     * groupSum(0, [2, 4, 8], 14) → true
     * groupSum(0, [2, 4, 8], 9) → false
     */
    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length){
            return (target == 0);    // T(0) = c1, donde c1 = 5
        }
        if (groupSum(start + 1, nums, target - nums[start])){
            return true;  // T(n) = c2 + T(n-1) + T(n-1), c2 = 7
        }
        if (groupSum(start + 1, nums, target)){ 
            return true;  // T(n) = c2(2^n - 1) + c1.2^(n-1)
        }
        return false;   //T(n) = (c2 + c1/2)2^n - c2
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this additional constraint: If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)
     * groupNoAdj(0, [2, 5, 10, 4], 12) → true
     * groupNoAdj(0, [2, 5, 10, 4], 14) → false
     * groupNoAdj(0, [2, 5, 10, 4], 7) → false
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;     // T(0) = c1, donde c1 = 4
        }
        if(groupNoAdj(start+2, nums, target - nums[start])){
            return true;    //T(n)= c2+T(n-1)+T(n-2), c2 = 6
        }

        if(groupNoAdj(start+1, nums, target)){
            return true;   //T(n)= -c2+c1*Fn+c2Ln
        }
        return false;   //Fn = numero Fibonacci, Ln= numero lucas 
    }

    /**
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with these additional constraints: all multiples of 5 in the array must be included in the group. If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
     * groupSum5(0, [2, 5, 10, 4], 19) → true
     * groupSum5(0, [2, 5, 10, 4], 17) → true
     * groupSum5(0, [2, 5, 10, 4], 12) → false
     */
    public boolean groupSum5(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;                     //T(0)=c1, donde c1 = 5
        }
        if((nums[start] % 5 == 0)
        ||(groupSum5(start+1, nums, target - nums[start])))
        {
            if(start <= nums.length - 2 && nums[start+1] == 1){
                return groupSum5(start+2, nums, target - nums[start]);
            }
            //T(n)= c2 + T(n-1)+T(n-2), donde c2 = 12
            return groupSum5(start+1, nums, target - nums[start]);
        } 
        // T(n)=c3 + T(n-1), donde c3 = 11
        if(groupSum5(start+1, nums, target)){
            return true;
        }               
        return false;         //T(n)= c4 + T(n-1), donde c4 = 4
        //T(n)= c4*n + c1
    }

    /**
     *  Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, with this additional constraint: if there are numbers in the array that are adjacent and the identical value, they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group. (one loop can be used to find the extent of the identical values).
     *  groupSumClump(0, [2, 4, 8], 10) → true
     *  groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
     *  groupSumClump(0, [2, 4, 4, 8], 14) → false
     */
    public boolean groupSumClump(int start, int[] nums, int target) {
        if(start >= nums.length){
            return target == 0;       //T(0)= c1, siendo c1 = 4
        }
        int i = start;                
        int sum = 0;
        while(i < nums.length && nums[start] == nums[i]) {
            sum += nums[i];
            i++;                     //T(n)= c2 + T(n), siendo c2= 10
        }
        if(groupSumClump(i, nums, target - sum)){
            return true;              //T(n)= c3+ T(n-2), siendo c3= 4
        }                         
        if(groupSumClump(i, nums, target)){
            return true;
        }                                          
        return false;                 //T(n)= c4+ T(n-1) =  4
        //T(n)= c4*n + c1
    }                                    

    /** Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)
     * splitArray([2, 2]) → true
     * splitArray([2, 3]) → false
     * splitArray([5, 2, 3]) → true
     */
    public boolean splitArray(int[] nums) {
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return recArray(nums, index, sum1, sum2);
    }

    private boolean recArray ( int[] nums, int index, int sum1, int sum2 ) {
        if ( index >= nums.length ) {
            return sum1 == sum2;           // T(0)= c1, siendo c1 = 5
        }
        int value = nums[index];
        return (recArray(nums, index + 1, sum1 + value, sum2) ||
            recArray(nums, index + 1, sum1, sum2 + value));      
        //T(n)= c2 + T(n-1) + T(n-1), siendo c2 = 7
        //T(n)= c2((2^n)-1)+c1*2^n-1
    }
}
