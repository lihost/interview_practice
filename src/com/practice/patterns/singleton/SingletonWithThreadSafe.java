package com.practice.patterns.singleton;

/**
 *
 * @author sohil
 */

//Thread safe singleton - double checked locking
class SingletonWithDoubleCheckedLocking {
 private static volatile SingletonWithDoubleCheckedLocking SingletonWithDCL_instance;
 
 private SingletonWithDoubleCheckedLocking(){}
 
 public static SingletonWithDoubleCheckedLocking getInstance(){
     if(SingletonWithDCL_instance == null){
         synchronized(SingletonWithDoubleCheckedLocking.class){
             if(SingletonWithDCL_instance == null){
                 SingletonWithDCL_instance = new SingletonWithDoubleCheckedLocking();
             }
         }
     }
     return SingletonWithDCL_instance;
 }
}


public class SingletonWithThreadSafe {
    
     public static void main(String[] args){                
        // Thread safe singleton pattern check
        SingletonWithDoubleCheckedLocking firstObject = SingletonWithDoubleCheckedLocking.getInstance();
        SingletonWithDoubleCheckedLocking secondObject = SingletonWithDoubleCheckedLocking.getInstance();
        
        System.out.println("----------- Thread safe singleton pattern check --------------\n");
        System.out.printf("firstObject hashcode: %d\n\n", firstObject.hashCode());
        System.out.printf("secondObject hashcode: %d", secondObject.hashCode());
    }

    
}
