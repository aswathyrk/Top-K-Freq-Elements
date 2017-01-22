class Pair{
    int num;
    int count;
    Pair(int num,int count){
        this.num=num;
        this.count=count;
    }
}
    
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        
        PriorityQueue<Pair> q=new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count-b.count;
            }
            });
            
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Pair p= new Pair(entry.getKey(),entry.getValue());
            q.offer(p);
            if(q.size()>k){
                q.poll();
            }
        }
        
        List<Integer> result= new ArrayList<Integer>();
        while(!q.isEmpty()){
            result.add(q.poll().num);
        }
        
        Collections.reverse(result);
        return result;
    }
}