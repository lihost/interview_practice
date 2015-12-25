package com.practice.hackerrank;

import java.util.Scanner;

/**
 * Problem Statement - https://www.hackerrank.com/challenges/utopian-tree
 * 
 * Sample Input
 * 3
 * 0
 * 1
 * 5
 * 
 * Sample Output
 * 1
 * 2
 * 14
 *
 */
public class UtopianTree {

         public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        int[] growthCycle = new int[testCases];
        int itr = 0;
        
        while(testCases > 0){
            testCases--;
            growthCycle[itr++] = sc.nextInt();
        }

        itr=0;
        int[] result = new int[growthCycle.length];
        for(int ele : growthCycle) {
            result[itr] = calculateGrowth(ele);
            itr++;
        }
        
        for(int out : result) {
            System.out.println(out);
        }
        sc.close();
    }
    
    public static int calculateGrowth(int nextCycle){
        int result=1;
        if(nextCycle<=0){
            return result;
        } 
        for(int i=1; i<=nextCycle; i++){
            if((i%2) == 0){      
                result++;
            } else {
                result = 2*result;
            }   
        }
        return result;
        
    }
}