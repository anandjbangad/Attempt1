package com.codenotfound.kafka;

public class Test {
    public static void main(String[] args) {
        String mno = "${kafka.topic.cloudNode}";
        System.out.println(mno);
        System.out.println(Config.TEST123);
    }
}
