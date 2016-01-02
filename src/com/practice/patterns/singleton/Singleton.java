package com.practice.patterns.singleton;

/**
 *
 * @author sohil
 */

// General singleton pattern - lazy loading with static
public class Singleton {
    
    private static Singleton single;
    
    private Singleton(){};
    
    public static Singleton getInstance(){
        
        if(single == null){
            single = new Singleton();
        }
        return single;
    };

    
     public static void main(String[] args){
        Singleton firstInstance = Singleton.getInstance();
        Singleton secondInstance = Singleton.getInstance();
        
        System.out.println("----------- singleton pattern check [non-thread safe ] --------------\n");
        System.out.printf("firstInstance hashcode: %d \n\n", firstInstance.hashCode());
        System.out.printf("secondInstance hashcode is %d \n\n\n", secondInstance.hashCode());
        
    }

    
}