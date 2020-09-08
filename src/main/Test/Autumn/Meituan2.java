package Autumn;

import java.util.Scanner;

public class Meituan2 {

    public static void main(String[] args) {
          String currentStart = null;
          int res = 0;
          Scanner sc = new Scanner(System.in);
          int tickets = Integer.parseInt(sc.nextLine());
          for(int i = 0; i<tickets;i++){
              String param = sc.nextLine();
              String[] params = param.split(" ");
              if(currentStart == null){
                  currentStart = params[0];
                  if(params[1].equals(currentStart)){
                      currentStart=null;
                  }
              }else{
                  if(params[1].equals(currentStart)){
                      res++;
                      currentStart=null;
                  }
              }
          }
          System.out.println(res);
    }
}
