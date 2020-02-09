import java.util.ArrayList;
import java.util.LinkedList;

public class LastRemainingNumInCircle {
    /**
     * 首先,让小朋友们围成一个大圈。
     * 然后,随机指定一个数m,让编号为0的小朋友开始报数。
     * 每次喊到m-1的那个小朋友要出列唱首歌,并且不再回到圈中,
     * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友
     * 求最后一个小朋友的编号
     */

    /**
     * 解法一：
     * 25ms
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i<n;i++){
            array.add(i);
        }
        //删除的是位置，最后get的是值
        int index = 0;
        while(array.size()>1){
            //主要是能推出这个公式
            index = (index+m-1)%array.size();
             array.remove(index);
        }
        return array.get(0);
    }

    /**
     * 解法二：这是个约瑟夫环的问题，用java模拟环
     * 第一次删掉的位置是从0开始数m-1个位置，
     * 以后每次从删掉的下一个节点开始取，
     * 所以每次要在bt的索引处加上m-1，因为是环，所以加了以后对链表长度取余
     * 38ms
     */
    public int LastRemaining_Solution2(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    public static void main(String args[]){
        System.out.println(LastRemaining_Solution(5, 3));
    }
}
