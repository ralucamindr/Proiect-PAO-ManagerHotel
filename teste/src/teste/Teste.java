/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.Arrays;

/**
 *
 * @author Alexandra-Andreea
 */

public  class Teste{
    static void test(int a[]){
        a[0]=100;
        a=new int[]{10,20,30,40,50};
        a[1]=200;
        System.out.println(Arrays.toString(a));
}
    public static void main(String[]args){
        int[]v={1,2,3,4,5,6,7};
        test(v);
        System.out.println(Arrays.toString(v));
}
}