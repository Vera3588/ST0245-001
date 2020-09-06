public class Array3 {

    public int maxSpan(int[] nums) {
        int max = 0;//c1
        for (int i = 0; i < nums.length; i++) {//c2+c3*n+c4*n

            int j = nums.length - 1;// c5*n
            for (;; j--) {//c6+ c7*n
                if (nums[j] == nums[i]) {//c8+c9*n
                    break;// c10
                }
            }

            int span = j - i + 1;//c11*n

            if (span > max) {//c12+c13*n
                max = span;// c14*n
            }
        }
        return max;//c15
        // c1+c2+c3*n+c4*n+c5*n+c6+c7*n+c8+c9*n+c10+c11*n+c12+c13*n+c14*n+c15
        //Complejidad O(n^2)
    }

    public int[] fix45(int[] nums) {
        for(int i = 0; i<nums.length;i++){ //c1+c2*n
            if(nums[i] == 4){  //c3 +c4*n
                for(int j = 0; j<nums.length; j++){ //c5 +c6*n
                    if(nums[j] == 5){ //c7 +c8*n
                        if(j > 0 && nums[j-1] != 4){ //c9 +c10*n+c11*n
                            int num = nums[i+1]; //c12 +c13*n
                            nums[i+1] = 5; //c14*n + c15
                            nums[j] = num;//c16*n +c17 
                        } 
                        else if(j == 0){ //c18 + c19
                            int num = nums[i+1]; //c20+c21*n
                            nums[i+1] = 5;// c22*n+ c23
                            nums[j] = num;//c24*n+c25
                        }
                    }
                }
            }
        }
        return nums; //c26
        //c1+c2*n+c3+c4*n+c5+c6*n+c7+c8*n+c9+c10*n+c11*n+c12+c13*n+c14*n+c15 +c16*n +c17+c18+c19+c20+c21*n+c22*n+c23+c24*n+c25+c26
        //Complejidad O(n^2)
    }

    public boolean canBalance(int[] nums) {
        int t = 0; //c1
        for(int i = 0; i<nums.length;i++){ //c2+c3*n
            t += nums[i]; //c4+c5*n
            int r = 0; //c6
            for(int j = nums.length-1; j > i; j--){ //c7+c8*n
                r +=nums[j];   //c9+c10*n
            }
            if(r == t) //c11+c12*n
                return true; //c13
        }
        return false; //c14
        //c1+c2+c3*n+c4+c5*n+c6+c7+c8*n+c9+c10*n+c11+c12*n+c13+c14
        //Complejidad O(n^2)
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int num = 0; //c1
        int p = 0;//c2
        if(inner.length == 0){ //c3+c4*n
            return true; //c5
        }
        for(int i = 0; i< outer.length; i++){ //c6+c7*n
            if(outer[i] == inner[p]){ //c8+c9*n+c10*n
                num++; //c11
                p++;  //c12
            }else if(outer[i] > inner[p]){ //c13+ c14*n+c15*n
                return false; //c16
            }
            if(inner.length == num){ //c17+c18*n
                return true; //c19
            }
        }
        return false; //c20
        //c1+c2+c3+c4*n+c5+c6+c7*n+c8+c9*n+c10*n+c11+c12+c13+c14*n+c15*n+c16+c17+c18*n+c19+c20
        //Complejidad O(n)
    }

    public int[] seriesUp(int n) {
        int []formula = new int[n*(n+1)/2];   //c1*n +c2*n^2
        int i = 0; //c3
        for(int j = 1;j <= n; j++) //c4+c5*n
            for(int p = 1; p <= j ; p++) // c6+c7*n
                formula[i++] = p; //c8*n+c9
        return formula; //c10
        // c1*n+c2*n^2+c3+c4+c5*n+c6+c7*n+c8*n+c9+c10
        //Complejidad O(n^2)
    }
}
