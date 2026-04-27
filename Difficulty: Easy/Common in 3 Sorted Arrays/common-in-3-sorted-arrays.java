class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int n1 = a.length;
        int n2 = b.length;
        int n3 = c.length;
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < n1 && j < n2 && k < n3){
            if(a[i] == b[j] && b[j] == c[k]){
                res.add(a[i]);
                i++;
                j++;
                k++;
            }
            else if(a[i] <= b[j] && a[i] <= c[k])i++;
            else if(a[i] > b[j] && b[j] <= c[k])j++;
            else k++;
            // System.out.println(i + " " + j + " " + k);
            
        }
        i = 1;
        while(i < res.size()){
            if(res.get(i).equals(res.get(i-1))){
                res.remove(i);
            }else i++;
        }
        
        return res;
    }
}