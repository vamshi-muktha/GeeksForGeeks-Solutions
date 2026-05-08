// class Solution {
//     public ArrayList<Integer> findOrder(int n, int[][] arr) {
//         // code here
//         // int n = V;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i = 0; i < n; i++){
//             adj.add(new ArrayList<Integer>());
//         }
//         for(int i = 0; i < arr.length; i++){
//             adj.get(arr[i][0]).add(arr[i][]);
//         }
//         int[] in = new int[n];
//         for(int i = 0; i < arr.length; i++){
//             in[arr[i][1]]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
        
//         for(int i = 0; i < n; i++){
//             if(in[i] == 0){
//                 q.add(i);
//             }
//         }
//         ArrayList<Integer> res = new ArrayList<>();
//         while(!q.isEmpty()){
//             int x = q.remove();
//             res.add(x);
//             for(int i : adj.get(x)){
                
//                 in[i]--;
//                 if(in[i] == 0){
//                     q.add(i);
//                 }
//             }
                
//         }
//         System.out.println(res);
//         if(res.size() != n)return new ArrayList<Integer>();
        
//         return res;
//     }
// }



class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] arr) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] in = new int[n];

        // prerequisite -> course
        for (int i = 0; i < arr.length; i++) {

            int course = arr[i][0];
            int prereq = arr[i][1];

            adj.get(prereq).add(course);
            in[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();
            res.add(node);

            for (int nei : adj.get(node)) {

                in[nei]--;

                if (in[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (res.size() != n)
            return new ArrayList<>();

        return res;
    }
}