package com.test1;

import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        String s = yanZ();
        System.out.println(s);

    }


    public static String yanZ(){
        char[] cha = new char[5];
        char[] zifu = { 'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m',
                        'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M',
                        '0','1','2','3','4','5','6','7','8','9'};
        Random random = new Random();
        while (true) {
            for (int i1 = 0; i1 < cha.length; i1++) {
                int i = random.nextInt(62);
                cha[i1] = zifu[i];
            }
            int num = 5;
            for (int i = 0; i < cha.length; i++) {
                if(cha[i] >= '0' && cha[i] <= '9'){
                    num -= 1;
                }
            }
            if(num < 4){
                continue ;
            }
            int num1 = 0;
            for (int i = 0; i < cha.length; i++) {
                char c = cha[i];
                if((c >= 'a' && c<= 'z')||(c>='A'&& c<='Z')){
                    num1 += 1;
                }
            }
            if (num1 >4){
                continue ;
            }
            break ;
        }
        return new String(cha);
    }
}
