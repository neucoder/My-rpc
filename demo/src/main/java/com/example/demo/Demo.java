package com.example.demo;

public class Demo {
    public static void main(String[] args) {
        //计算1到100 的和
        long sum = 0;
        for (int i = 0; i < 100; i++) {
           sum += i;
        }
        System.out.println(sum);
    }
}
