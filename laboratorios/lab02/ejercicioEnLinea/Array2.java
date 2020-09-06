public class Array2 {

    public int countEvens(int[] nums) {
        int count = 0;//        c1
        for (int n : nums) {//  c2 + c3*n
            if (n % 2 == 0) {// c4 + c5*n
                count++;    //  c6
            }
        }
        return count;       //c7
        //c1+c2+c3*n+c4+c5*n+c6+c7
        //Complejidad O(n)
    }

    public int[] post4(int[] nums) {
        for (int i = nums.length-1; i >= 0; i--) {  //c1 + c2*n + c3*n 
            if (nums[i] == 4) {  // c4 + c5*n
                int[] foo; // c6
                foo = new int[nums.length-i-1]; //c7*n

                for (int j = 0; j < foo.length; j++) { //c8 + c9*n + c10*n 
                    foo[j] = nums[i+j+1]; //c11*n + c12*n
                }
                return foo; //c13
            }   
        }

        int[] bar;  // c14
        bar = new int[0]; //c15*n
        return bar;   //c16
        //c1+c2*n+c3*n+c4+c5*n+c6+c7*n+c8 + c9*n + c10*n+ c11*n + c12*n+ c13+c14+c15*n+c16
        //Complejidad O(n^2)
    }

    public boolean only14(int[] nums) {
        boolean T = true; //c1

        for(int i = 0; i<nums.length; i++){ //c2+c3*n+c4*n
            if(nums[i] != 1 && nums[i] != 4) //c5+c6*n + c7*n
                T = false;    //c8
        }
        return T; //c9
        //c1 +c2 + c3*n + c4*n + c5 + c6*n + c7*n + c8 + c9
        //Complejidad O(n)
    }

    public String[] fizzArray2(int n) {
        String[] r = new String[n]; // c1*n + c2*n
        for(int i = 0; i<n ; i++){      //c3+c4*n
            r[i] = String.valueOf(i);   // c5*n + c6*n
        }
        return r; //c7
        //c1*n + c2*n + c3 + c4*n + c5*n + c6*n + c7
        //Complejidad O(n)
    }

    public boolean has12(int[] nums) {
        boolean f = false; //c1
        boolean f1 = false; //c2

        for(int i = 0; i<nums.length; i++){ //c3+c4*n
            if(nums[i] == 1) // c5 + c6*n
                f = true;   //c7

            if(nums[i] == 2 && f) // c8 + c9*n + c10
                f1 = true;    //c11
        }
        return f1;  //c12
        //c1 + c2 + c3 + c4*n + c5 + c6*n + c7 + c8 + c9*n + c10 + c11 + c12
        //Complejidad O(n)
    }
}

