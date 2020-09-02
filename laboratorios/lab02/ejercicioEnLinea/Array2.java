public class Array2 {

    public int countEvens(int[] nums) {
        int count = 0;//        C
        for (int n : nums) {//  n
            if (n % 2 == 0) {// n
                count++;    //  n
            }
        }
        return count;       //C
        //Complejidad O(n)
    }

    public int[] post4(int[] nums) {
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == 4) {
                int[] foo;
                foo = new int[nums.length-i-1];

                for (int j = 0; j < foo.length; j++) {
                    foo[j] = nums[i+j+1];
                }
                return foo;
            }
        }

        int[] bar;
        bar = new int[0];
        return bar;
    }

    public boolean only14(int[] nums) {
        boolean T = true;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 1 && nums[i] != 4)
                T = false;
        }
        return T;
    }

    public String[] fizzArray2(int n) {
        String[] r = new String[n];
        for(int i = 0; i<n ; i++){
            r[i] = String.valueOf(i);
        }
        return r;
    }

    public boolean has12(int[] nums) {
        boolean f = false;
        boolean f1 = false;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1)
                f = true;

            if(nums[i] == 2 && f)
                f1 = true;
        }
        return f1;
    }
}

