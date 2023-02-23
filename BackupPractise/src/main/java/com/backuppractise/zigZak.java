package com.backuppractise;

public class zigZak {

    public static void main(String[] args) {
        String str = "dinesh";
        int row=3;
        int len=str.length();
        StringBuilder stringBuilder=new StringBuilder();
        System.out.println(len);
        char temp = 0;
        for(int i=0;i<len; i++){
            char ch =str.charAt(i);
            if(i==2){
                temp = str.charAt(i);
                System.out.println(temp);
            }
            stringBuilder.append(str.charAt(i));
        }

        String newStr=str.replace(str.charAt(0),temp);
        System.out.println(newStr);

    }
}
