import java.util.*;

public class HWTest {

    public ArrayList<Integer> getNewsFeed(int userId){
        ArrayList<Integer> res = new ArrayList<>();
        //堆排序,大顶堆，堆中是最近发送的10条推文
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10);
        //用户关注的人或者用户发的推文
        List<Integer> list = new ArrayList<>();
  //      select id from twitter where userId(select userId from user where followee = uId);
        //如果发送的推文时间 > 堆中的最大值
      for(Integer ele : list){
          if(priorityQueue != null){
              int temp = priorityQueue.poll();
              if(ele > temp){
                  priorityQueue.offer(ele);
              }
          }else{
              priorityQueue.offer(ele);
          }
      }
      for(Integer num : priorityQueue){
          res.add(num);
      }
      Collections.sort(res, new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
              return o2.compareTo(o1);
          }
      });
      return res;
    }

}
