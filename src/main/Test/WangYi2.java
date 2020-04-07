import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WangYi2 {
  static  class Monsters{
        private int breakD;
        private int injure;
        public Monsters(){

      }
        public int getBreakD() {
            return breakD;
        }
        public void setBreakD(int breakD) {
            this.breakD = breakD;
        }
        public int getInjure() {
            return injure;
        }
        public void setInjure(int injure) {
            this.injure = injure;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
       Monsters[] monsters = new Monsters[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            monsters[i].setBreakD(num);
        }
        for(int j = 0; j<n ; j++){
            int num = sc.nextInt();
            monsters[j].setInjure(num );
        }
        solution(monsters,d);
    }

    public static void solution(Monsters[] monsters, int d){
        for(int i = 0 ; i<monsters.length;i++){
            for(int j = i ; j<monsters.length;j++){
                if(monsters[j].getBreakD() < monsters[i].getBreakD()){
                    Monsters temp = monsters[i];
                    monsters[i] = monsters[j];
                    monsters[j] = temp;
                }
            }
        }
        int res = 0;
        for(int i = 0; i<monsters.length;i++){
            if(monsters[i].getBreakD() > d){
                res += monsters[i].getInjure();
            }
            d++;
        }
        System.out.print(res);
    }
}
