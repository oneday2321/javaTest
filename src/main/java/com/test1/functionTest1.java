package com.test1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class functionTest1 {

    public static void main(String[] args) {
        System.out.println("----------欢迎访问系统----------");
        ArrayList<User> userInfo = new ArrayList<>();
        isGoOn:
        while (true) {
            System.out.println("请选择操作方式：1、登陆 2、注册 3、忘记密码");
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            switch (next) {
                case "1": {
                    for (int j = 3;j >= 0;j--) {
                        int i = loginSystem(userInfo);
                        if(i == 1){
                            System.out.println("成功登陆系统");
                            break ;
                        }else if (i == 2){
                            System.out.println("用户不存在，请注册用户");
                            break ;
                        }else if (i == 3){
                            if(j == 0){
                                System.out.println("用户次数用尽，无法再次登陆");
                                break ;
                            }
                            System.out.println("用户名或者密码错误，请重新输入,还有"+j+"次机会");
                        }
                    }
                    break;
                }
                case "2": {
                    isOne:
                    while (true) {
                        User user = inputInfo();
                        int oneUser = isOneUser(userInfo, user);
                        if (oneUser == 1) {
                            userInfo.add(user);
                            break isOne;
                        }
                    }
                    System.out.println("用户注册成功！");
                    break;
                }
                case "3": {
                    System.out.println("忘记密码");
                    break;
                }
                default: {
                    System.out.println("输入无效");
                    break;
                }
            }
        }
    }

    public static User inputInfo() {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        isGo:
        while (true) {
            isName:
            while (true) {
                System.out.print("请输入账户：");
                String username = sc.next();
                int yiShu = isYiShu(username);
                if (yiShu == 1) {
                    user.setUsername(username);
                    break isName;
                }
            }
            System.out.print("请输入密码：");
            String password = sc.next();
            isPassWord(password);
            user.setPassword(password);
//            isPhone1:
//            while (true) {
//                System.out.print("请输入手机号：");
//                String phone = sc.next();
//                int phone1 = isPhone(phone);
//                if (phone1 == 1) {
//                    user.setPhone(phone);
//                    break isPhone1;
//                }
//            }

//            isId:
//            while (true) {
//                System.out.print("请输入身份证号：");
//                String idNumber = sc.next();
//                int idNumber1 = isIdNumber(idNumber);
//                if (idNumber1 == 1) {
//                    user.setIdNumber(idNumber);
//                    break isId;
//                }
//            }
            break isGo;
        }
        return user;
    }

    public static int loginSystem(ArrayList<User> userInfo) {
        /*
         * @Param   现有对象集合
         * @Return  1   正常登陆
         * @Return  2   用户不存在
         * @Return  3   用户或者密码错误
         */
        Scanner sc = new Scanner(System.in);
        String s = yanZ();
        System.out.print("请输入账户：");
        String name = sc.next();
        System.out.print("请输入密码：");
        String password = sc.next();
        System.out.println("验证码：" + s);
        System.out.print("请输入验证码：");
        while (true) {
            String next2 = sc.next();
            if(next2.equals(s)) {
                for (User user : userInfo) {
                    if (user.getUsername().equals(name)) {
                        if (user.getPassword().equals(password)) {
                            return 1;
                        } else {
                            return 3;
                        }
                    }
                }
                return 2;
            }
            System.out.print("验证码输入错误，请重新输入：");
        }
    }

    public static void forgetPassword() {
    }

    public static int isYiShu(String username) {
        /*
         * return 1 数据正常
         * return 2 数据错误，长度不满足
         * return 3 数据错误，仅允许英文加数字
         * return 4 数据错误，不能全部都是数字
         */
        if (username.length() >= 3 && username.length() <= 15) {
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);
                if ((c > '9' || c < '0') && (c > 'z' || c < 'a') && (c < 'A' || c > 'Z')) {
                    System.out.println("数据错误，仅允许英文加数字");
                    return 3;
                }
            }
            int number = 0;
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);
                if (c <= '9' && c >= '0') {
                    number++;
                }
            }
            if (number == username.length()) {
                System.out.println("数据错误，不能全部都是数字");
                return 4;
            } else {
                return 1;
            }
        } else {
            System.out.println("数据错误，长度不满足");
            return 2;
        }
    }

    public static void isPassWord(String password) {
        /*
         * @Params  前后两次输入的密码
         * @Return  无返回值
         */
        Scanner sc = new Scanner(System.in);
        isGoOn:
        while (true) {
            System.out.print("请再次输入密码：");
            String password_cp = sc.next();
            if (password_cp.equals(password)) {
                break isGoOn;
            } else {
                System.out.print("重复校验错误！");
            }
        }
    }

    public static int isPhone(String phone) {
        /*
         * @Params  手机号
         * @Return 1 数据正常
         * @Return 2 数据错误，长度错误
         * @Return 3 数据错误，以0开头
         * @Return 4 数据错误，非全数字
         */
        if (phone.length() == 11) {
            if (phone.charAt(0) == '0') {
                System.out.println("数据错误，以0开头");
                return 3;
            } else {
                for (int i = 0; i < phone.length(); i++) {
                    char c = phone.charAt(i);
                    if (c > '9' || c < '0') {
                        System.out.println("数据错误，非全数字 ");
                        return 4;
                    }
                }
                return 1;
            }
        } else {
            System.out.println("数据错误，长度错误");
            return 2;
        }
    }

    public static int isIdNumber(String idNumber) {
        /*
         * @Params 身份证号
         * @Return 1 数据正常
         * @Return 2 数据错误，长度错误
         * @Return 3 数据错误，以0开头
         * @Return 4 数据错误，前17位非数字
         * @Return 5 数据错误，最后一位非数字非x\X
         */
        if (idNumber.length() == 18) {
            if (idNumber.charAt(0) == '0') {
                System.out.println("数据错误，以0开头");
                return 3;
            }
            for (int i = 0; i < idNumber.length() - 1; i++) {
                char c1 = idNumber.charAt(i);
                if (c1 > '9' || c1 < '0') {
                    System.out.println("数据错误，前17位非数字");
                    return 4;
                }
            }
            char c = idNumber.charAt(idNumber.length() - 1);
            if ((c > '9' || c < '0') && (c != 'x' && c != 'X')) {
                System.out.println("数据错误，最后一位非数字非x\\X");
                return 5;
            }
            return 1;
        } else {
            System.out.println("数据错误，长度错误");
            return 2;
        }
    }

    public static int isOneUser(ArrayList<User> userInfo, User User) {
        /*
         * @Param 对象集合，单独对象
         * @Return 1 正常注册
         * @Return 2 该账号已经存在，不能注册成功
         */
        if (userInfo.size() == 0) {
            return 1;
        }
        for (int i = 0; i < userInfo.size(); i++) {
            String username = userInfo.get(i).getUsername();
            if (username.equals(User.getUsername())) {
                System.out.println("该账号已经存在，不能注册成功,请重新输入");
                return 2;
            }
        }
        return 1;
    }

    public static String yanZ() {
        /*
         * @Param 无参
         * @Return 返回生成的验证码
         */
        char[] cha = new char[5];
        char[] zifu = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
                'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        while (true) {
            for (int i1 = 0; i1 < cha.length; i1++) {
                int i = random.nextInt(62);
                cha[i1] = zifu[i];
            }
            int num = 5;
            for (char value : cha) {
                if (value >= '0' && value <= '9') {
                    num -= 1;
                }
            }
            if (num < 4) {
                continue;
            }
            int num1 = 0;
            for (char c : cha) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    num1 += 1;
                }
            }
            if (num1 > 4) {
                continue;
            }
            break;
        }
        return new String(cha);
    }
}
