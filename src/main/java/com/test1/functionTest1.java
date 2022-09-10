package com.test1;
import java.util.Scanner;

public class functionTest1 {

    public static void main(String[] args) {
        System.out.println("----------欢迎访问系统----------");
        isGoOn:while (true) {
            System.out.println("请选择操作方式：1、登陆 2、注册 3、忘记密码");
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            switch (next){
                case "1" :{
                    System.out.println("登陆系统");
                    break;
                }
                case "2" :{
                    System.out.println("注册用户");
                    inputInfo();

                    break;
                }
                case "3" :{
                    System.out.println("忘记密码");
                    break;
                }
                default:{
                    System.out.print("输入无效");
                    break;
                }
            }
        }
    }
    public static void inputInfo(){
        Scanner sc = new Scanner(System.in);
        User user = new User();
        isGo:while (true) {
            isName:while (true) {
                System.out.print("请输入账户：");
                String username = sc.next();
                int yiShu = isYiShu(username);
                if(yiShu == 1){
                    user.setUsername(username);
                    break isName;
                }
            }
            System.out.print("请输入密码：");
            String password = sc.next();
            isPassWord(password);
            user.setPassword(password);
            isphone:while (true) {
                System.out.print("请输入手机号：");
                String phone = sc.next();
                int phone1 = isPhone(phone);
                if (phone1 ==1){
                    user.setPhone(phone);
                    break isphone;
                }
            }

            isId:while (true) {
                System.out.print("请输入身份证号：");
                String idNumber = sc.next();
                int idNumber1 = isIdNumber(idNumber);
                if (idNumber1 == 1){
                    user.setIdNumber(idNumber);
                    break isId;
                }
            }
            break isGo;
        }
    }

    public static void loginSystem(){
        /*
         * @Param
         * @Return
         */
    }

    public static void regUser(){}

    public static void forgetPassword(){}

    public static int isYiShu(String username){
        /*
         * return 1 数据正常
         * return 2 数据错误，长度不满足
         * return 3 数据错误，仅允许英文加数字
         * return 4 数据错误，不能全部都是数字
         */
        if (username.length() >=3 && username.length() <= 15){
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);
                if((c > '9' || c < '0') && (c > 'z' || c < 'a') && (c < 'A' || c > 'Z')){
                    System.out.println("数据错误，仅允许英文加数字");
                    return 3;
                }
            }
            int number = 0;
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);
                if(c <= '9' && c >= '0'){
                    number ++;
                }
            }
            if (number == username.length()){
                System.out.println("数据错误，不能全部都是数字");
                return 4;
            }else {
                return 1;
            }
        }else {
            System.out.println("数据错误，长度不满足");
            return 2;
        }
    }

    public static void isPassWord(String password){
        /*
         * @Params  前后两次输入的密码
         * @Return  无返回值
         */
        Scanner sc = new Scanner(System.in);
        isGoOn : while (true) {
            System.out.print("请再次输入密码：");
            String password_cp = sc.next();
            if(password_cp.equals(password)){
                break isGoOn;
            }else {
                System.out.print("重复校验错误！");
            }
        }
    }
    public static int isPhone(String phone){
        /*
         * @Params  手机号
         * @Return 1 数据正常
         * @Return 2 数据错误，长度错误
         * @Return 3 数据错误，以0开头
         * @Return 4 数据错误，非全数字
         */
        if (phone.length() == 11){
            if(phone.charAt(0) == '0'){
                System.out.println("数据错误，以0开头");
                return 3;
            }else {
                for (int i = 0; i < phone.length(); i++) {
                    char c = phone.charAt(i);
                    if(c > '9' || c < '0'){
                        System.out.println("数据错误，非全数字 ");
                        return 4;
                    }
                }
                return 1;
            }
        }else {
            System.out.println("数据错误，长度错误");
            return 2;
        }
    }

    public static int isIdNumber(String idNumber){
        /*
         * @Params 身份证号
         * @Return 1 数据正常
         * @Return 2 数据错误，长度错误
         * @Return 3 数据错误，以0开头
         * @Return 4 数据错误，前17位非数字
         * @Return 5 数据错误，最后一位非数字非x\X
         */
        if (idNumber.length() == 18){
            if (idNumber.charAt(0) == '0'){
                System.out.println("数据错误，以0开头");
                return 3;
            }
            for (int i = 0; i < idNumber.length()-1; i++) {
                char c1 = idNumber.charAt(i);
                if (c1 > '9' || c1 < '0' ){
                    System.out.println("数据错误，前17位非数字");
                    return 4;
                }
            }
            char c = idNumber.charAt(idNumber.length() - 1);
            if ((c > '9' || c <'0')&& (c != 'x' && c != 'X')){
                System.out.println("数据错误，最后一位非数字非x\\X");
                return 5;
            }
            return 1;
        }else {
            System.out.println("数据错误，长度错误");
            return 2;
        }
    }
}
