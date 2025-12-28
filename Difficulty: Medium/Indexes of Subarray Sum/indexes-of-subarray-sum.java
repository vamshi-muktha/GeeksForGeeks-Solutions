


class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int t) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        int cs = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            cs += arr[i];
            if(cs == t){
                res.add(j+1);
                res.add(i+1);
                return res;
            }
            else if(cs > t){
                while(cs > t){
                    cs -= arr[j];
                    j++;
                    if(cs == t){
                        res.add(j+1);
                        res.add(i+1);
                        return res;
                    }
                }
                
            }
        }
        res.add(-1);
        return res;
    }
}
