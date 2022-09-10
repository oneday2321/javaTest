package com.test1;

import java.util.ArrayList;
import java.util.Scanner;

public class functionTest2 {
    public static void main(String[] args) throws InterruptedException {
        //开始，第一步 文字提示
        language();
        //输入选择
        Scanner sc = new Scanner(System.in);
        //创建集合存储学生数据
        ArrayList<Student> arrList = new ArrayList<>();
        //根据选择进行操作
        boolean bool3 = true;
        while (bool3) {
            System.out.print("请输入您的选择：");
            String next = sc.next();
            switch (next){
                case "1":
                    boolean bool = true;
                    while (bool) {
                        insertStudent(arrList,luRU1());
                        String next1 = sc.next();
                        if(next1.equals("0")){
                            bool= true;
                            System.out.println("继续录入");
                        }else {
                            System.out.println("返回菜单");
                            language();
                            bool = false;
                        }
                    }
                    break;
                case "2":
                    boolean bool1 = true;
                    while (bool1) {
                        System.out.print("请输入需要删除的学生ID:");
                        String next1 = sc.next();
                        Boolean aBoolean = deleteStudent(arrList, next1);
                        if (aBoolean) {
                            String next2 = sc.next();
                            if(next2.equals("0")){
                                bool1= true;
                                System.out.println("继续删除");
                            }else {
                                System.out.println("返回菜单");
                                language();
                                bool1 = false;
                            }
                        }else {
                            bool1 = false;
                        }
                    }
                    break;
                case "3":
                    boolean bool2 = true;
                    System.out.print("请输入需要修改信息的学生ID:");
                    String next1 = sc.next();
                    while (bool2) {
                        Boolean aBoolean = updateStudent(arrList, next1);
                        if (aBoolean) {
                            String next2 = sc.next();
                            if(next2.equals("0")){
                                bool2 = true;
                                System.out.println("继续修改");
                            }else{
                                System.out.println("返回菜单");
                                language();
                                bool2 = false;
                            }
                        }else {
                            bool2 = false;
                        }
                    }
                    break;
                case "4":
                    System.out.println("查询");
                    boolean b = selectStudent(arrList);
                    break;
                case "5":
                    System.out.println("退出系统！");
                    bool3 = false;
                    break;
            }
        }
    }

    public static void language(){
        System.out.println("----------欢迎使用学生系统！---------");
        System.out.println("1：添加学生");
        System.out.println("2：删除学生");
        System.out.println("3：修改学生");
        System.out.println("4：查询学生");
        System.out.println("5：退出系统");
    }

    public static Student luRU1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生id：");
        String id = sc.next();
        System.out.print("请输入学生姓名：");
        String username = sc.next();
        System.out.print("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.print("请输入学生家庭住址：");
        String address = sc.next();
        return  new Student(id, username, age, address);
    }


    public static void insertStudent(ArrayList<Student> arrList, Student student){
        if(arrList.size() == 0){
            arrList.add(student);
            System.out.println("学生添加成功，是否继续？ 0：继续录入 1：返回菜单 ");
        }else{
            for (Student value : arrList) {
                String id = value.getId();
                if (id.equals(student.getId())) {
                    System.out.println("输入的学生id已存在，是否继续录入？ 0：继续录入 1：返回菜单 ");
                    return;
                }
            }
            arrList.add(student);
            System.out.println("学生添加成功，是否继续？ 0：继续录入 1：返回菜单 ");
        }
    }

    public static Boolean deleteStudent(ArrayList<Student> arrList,String id){
        if(arrList.size() == 0){
            System.out.println("学生ID不存在，返回初始菜单");
            language();
            return false;
        }else{
            for (int i = 0; i < arrList.size(); i++) {
                Student student = arrList.get(i);
                if(id.equals(student.getId())){
                    arrList.remove(i);
                    System.out.println("学生ID已删除，是否继续？ 0：继续删除 1：返回菜单");
                    return true;
                }else {
                    System.out.println("学生ID不存在，返回初始菜单");
                    language();
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean updateStudent(ArrayList<Student> arrList,String id){
        Scanner sc = new Scanner(System.in);
        if(arrList.size() == 0){
            System.out.println("学生ID不存在，返回初始菜单");
            language();
            return false;
        }else{
            for (int i = 0; i < arrList.size(); i++) {
                Student student = arrList.get(i);
                if(id.equals(student.getId())){
                    System.out.println("请输入需要修改的内容： 1、名称 2、年龄 3、地址");
                    String next = sc.next();
                    switch (next){
                        case "1":
                            System.out.println("修改名称");
                            System.out.print("请输入修改后的名称：");
                            String next1 = sc.next();
                            student.setName(next1);
                            System.out.println("已修改完成，是否继续修改？ 0：继续修改 1、返回菜单");
                            return true;
                        case "2":
                            System.out.println("修改年龄");
                            System.out.print("请输入修改后的年龄：");
                            int i1 = sc.nextInt();
                            student.setAge(i1);
                            System.out.println("已修改完成，是否继续修改？ 0：继续修改 1、返回菜单");
                            return true;
                        case "3":
                            System.out.println("修改地址");
                            System.out.print("请输入修改后的地址：");
                            String next2 = sc.next();
                            student.setAddress(next2);
                            System.out.println("已修改完成，是否继续修改？ 0：继续修改 1、返回菜单");
                            return true;
                    }

                }else {
                    System.out.println("学生ID不存在，返回初始菜单");
                    language();
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean selectStudent(ArrayList<Student> arrList) throws InterruptedException {
        if(arrList.size() == 0){
            System.out.println("当前学生信息未录入，请添加后在查询");
            Thread.sleep(2000);
            language();
            return false;
        }else{
            System.out.println("id"+"    "+"姓名"+"    "+"年龄"+"    "+"家庭住址");
            for (int i = 0; i < arrList.size(); i++) {
                Student student = arrList.get(i);
                System.out.println(student.getId()+"    "+student.getName()+"    "+student.getAge()+"    "+student.getAddress());
            }
            System.out.println("查询完毕，3秒后返回菜单！");
            System.out.println();
            System.out.println();
            Thread.sleep(3000);
            language();
        }
        return true;
    }
}
