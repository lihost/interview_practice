package practice;

import java.util.Scanner;

/**
 * Find if given integer number is power of 2.
 * 
 * e.g. pw=4, => (0100 & 0011) => 0000
 *
 */
public class PowerOf2 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer pw = sc.nextInt();
        sc.close();

        
        if((pw & (pw-1)) == 0){
            System.out.println(pw+" is power of 2");
        } else {
            System.out.println(pw+" is not a power of 2");
        }
    }
    
}
