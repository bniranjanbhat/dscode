package com.code.map.intermediate;


import java.util.*;
/* Description of the question here
  https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps
*/

public class RansomNotes {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {


    }
    private static boolean getRansom(int m, int n, String[] magazine, String[] ransom) {

        if(m < n)
            return false;

        Map<String, Long> magazineMap = getFrequencyMapFromArray(magazine); //Arrays.stream(magazine).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> ransomMap =  getFrequencyMapFromArray(ransom); //Arrays.stream(ransom).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(magazineMap);
        System.out.println(ransomMap);

        for(String key : ransomMap.keySet()){
            if(!magazineMap.containsKey(key))
                return false;

            if(magazineMap.get(key) < ransomMap.get(key))
                return false;
        }

        return true;

    }

    private static Map<String, Long> getFrequencyMapFromArray(String[] arr) {

        Map<String, Long> map = new HashMap<>();

        for(String key : arr){
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key, new Long("1"));
        }
        return map;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
        
        System.out.println(getRansom(m,n,magazine, note));
//        checkMagazine(magazine, note);

        scanner.close();
    }
}
