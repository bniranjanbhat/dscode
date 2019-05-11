package com.code.general.examples;
//
//0  1  2  3  4  5  6  7  8  9 10 11 12  13
//0 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//1 [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0],
//2 [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0],
//3 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0], 
//4 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0], 
//5 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5],
//6 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//7 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
//8 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//9 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//10[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0], 
//11[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
//12[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
//13[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]

class GFG { 
  
// Returns the longest repeating non-overlapping  
// substring in str  
    static String longestRepeatedSubstring(String str) { 
        int n = str.length(); 
        int LCSRe[][] = new int[n + 1][n + 1]; 
  
        String res = ""; // To store result  
        int res_length = 0; // To store length of result  
  
        // building table in bottom-up manner  
        int i, index = 0; 
        for (i = 1; i <= n; i++) { 
            for (int j = i + 1; j <= n; j++) { 
                // (j-i) > LCSRe[i-1][j-1] to remove  
                // overlapping  
                if (str.charAt(i - 1) == str.charAt(j - 1) 
                        && LCSRe[i - 1][j - 1] < (j - i)) { 
                    LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1; 
                    	boolean var = true;
                    	if(var) {
                    		
                    	}
                    // updating maximum length of the  
                    // substring and updating the finishing  
                    // index of the suffix  
                    if (LCSRe[i][j] > res_length) { 
                        res_length = LCSRe[i][j]; 
                        index = Math.max(i, index); 
                    } 
                } else { 
                    LCSRe[i][j] = 0; 
                } 
            } 
        } 
  
        // If we have non-empty result, then insert all  
        // characters from first character to last  
        // character of String  
        if (res_length > 0) { 
            for (i = index - res_length + 1; i <= index; i++) { 
                res += str.charAt(i - 1); 
            } 
        } 
  
        return res; 
    } 
  
// Driver program to test the above function  
    public static void main(String[] args) { 
        String str = "geeksforgeeks"; 
        System.out.println(longestRepeatedSubstring(str)); 
    } 
} 
// This code is contributed by Rajput-JI  