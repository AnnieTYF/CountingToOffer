package Autumn;

import java.util.*;


public class WY3 {

    static int[] a;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    static int binarySearch(int left,int right,int target) {
        for (int i=left;i<=right;i++) {
            if(a[i] >= target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        a = new int[n];
        String parameter = scanner.nextLine();
        String[] parameters = parameter.split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parameters[i]);
        }
        parameter = scanner.nextLine();
        parameters = parameter.split(" ");
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(parameters[i]));
        }
        int p = Integer.parseInt(scanner.nextLine());
        int right = n-1, ans = 1;
        Arrays.sort(a);
        while (!pq.isEmpty()) {
            int target = pq.poll();
            if (target > a[right]) {
                ans = 0;
                break;
            }
            int index = binarySearch(0, right, target);
            ans = (ans * (right - index + 1)) % p;
            right--;
        }
        System.out.println(ans);
    }


}
