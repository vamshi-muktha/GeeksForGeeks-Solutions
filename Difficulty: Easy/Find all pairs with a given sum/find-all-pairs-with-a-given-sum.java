// User function Template for Java

/*
class pair  {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
*/

class Solution {
    public pair[] allPairs(int t, int arr1[], int arr2[]) {
        // Your code goes here
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<pair> al = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            hm.put(arr1[i], hm.getOrDefault(arr1[i], 0) + 1);
        }
        for(int i = 0; i < m; i++){
            if(hm.containsKey(t - arr2[i])){
                for(int x = 0; x < hm.get(t - arr2[i]); x++)
                al.add(new pair(t - arr2[i], arr2[i]));
                
            }
        }
        pair[] res = new pair[al.size()];
        for(int i = 0; i < al.size(); i++){
            res[i] = al.get(i);
        }
        Arrays.sort(res, (a, b) -> (int)a.first - (int)b.first);
        return res;
        
        // Arrays.sort(arr2);
        // List<pair> resultList = new ArrayList<>();
        // HashSet<Integer> set = new HashSet<>();
        
        // for (int num : arr1) {
        //     set.add(num);
        // }
        
        // for (int num : arr2) {
        //     if (set.contains(x - num)) {
        //         resultList.add(new pair(x - num, num));
        //         set.remove(x - num); // Remove to avoid duplicates
        //     }
        // }
        // resultList.sort(Comparator.comparingLong(p -> p.first));
        // pair[] res = new pair[resultList.size()];
        // return resultList.toArray(res);
    }
}