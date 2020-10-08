package Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bigo {

    static class Service{
        int disk;
        int memory;
        int userCount;

        public int getDisk() {
            return disk;
        }

        public int getMemory() {
            return memory;
        }

        public int getUserCount() {
            return userCount;
        }

        public Service(int disk, int memory, int userCount) {
            this.disk = disk;
            this.memory = memory;
            this.userCount = userCount;
        }
    }

    public static String calLoad(String param){
        Scanner sc = new Scanner(System.in);
        int totalDisk = sc.nextInt();
        int totalMemory = sc.nextInt();
        String[] strs = sc.nextLine().split("#");
        List<Service> services = new ArrayList<>();
        for(String str : strs){
            String[] temp = str.split(",");
            Service service = new Service(Integer.valueOf(temp[0]),
                    Integer.valueOf(temp[1]),
                    Integer.valueOf(temp[2]));
            services.add(service);
        }
        return solution(totalDisk,totalMemory,services);
    }

    public static String solution(int totalDisk, int totalMemory, List<Service> services){
        int len = services.size();
        int[][][] maxValue = new int[len+1][totalDisk+1][totalMemory+1];
        for(int i = 1; i<= len ; i++){
            for(int d = 1; d<=totalDisk ; d++){
                for(int m = 1; m<=totalMemory ; m++){
                    if(services.get(i-1).getDisk()<=d && services.get(i-1).getMemory()<=m){
                       maxValue[i][d][m] = Math.max(maxValue[i-1][d][m],
                               maxValue[i-1][d-services.get(i-1).getDisk()][m-services.get(i-1).getMemory()]+services.get(i-1).getUserCount());
                    }else{
                        maxValue[i][d][m] = maxValue[i-1][d][m];
                    }
                }
            }
        }
        return String.valueOf(maxValue[len][totalDisk][totalMemory]);
    }

}
