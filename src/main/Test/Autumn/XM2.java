package Autumn;

import java.util.Scanner;

public class XM2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] passwords = line.split(" ");
        for(String password : passwords){
            boolean number = false;
            boolean character = false;
            boolean upper = false;
            boolean lower = false;
            for(char ch : password.toCharArray()){
                if(number && character && upper && lower){
                    break;
                }
                if(Character.isDigit(ch)){
                    number = true;
                }else if(Character.isUpperCase(ch)){
                    upper = true;
                }else if(Character.isLowerCase(ch)){
                    lower = true;
                }else{
                    character = true;
                }
            }
            if(password.length() >= 8&& password.length() < 120){
                if(number && character && upper && lower){
                    System.out.println(0);
                }else{
                    System.out.println(2);
                }
            }else{
                System.out.println(1);
            }
        }
    }

    public static boolean search(){
        return true;
    }
}
