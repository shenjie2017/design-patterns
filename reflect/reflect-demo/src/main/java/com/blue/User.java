package com.blue;

import java.io.Serializable;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 11:14 2017/12/29
 * @Modifide By:
 **/

//      ┏┛ ┻━━━━━┛ ┻┓
//      ┃　　　　　　 ┃
//      ┃　　　━　　　┃
//      ┃　┳┛　  ┗┳　┃
//      ┃　　　　　　 ┃
//      ┃　　　┻　　　┃
//      ┃　　　　　　 ┃
//      ┗━┓　　　┏━━━┛
//        ┃　　　┃   神兽保佑
//        ┃　　　┃   代码无BUG！
//        ┃　　　┗━━━━━━━━━┓
//        ┃　　　　　　　    ┣┓
//        ┃　　　　         ┏┛
//        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//          ┃ ┫ ┫   ┃ ┫ ┫
//          ┗━┻━┛   ┗━┻━┛

public class User implements Serializable {
    private String name;
    private String password;
    private int age;
    private int level;
    private String email;
    protected String tel;
    public String desc;

    public User() {
        System.out.println("调用 public User()");
    }

    public User(String name, String password) {
        System.out.println("调用 public User(String name, String password)");
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, int age) {
        System.out.println("调用 public User(String name, String password, int age)");
        this.name = name;
        this.password = password;
        this.age = age;
    }

    private User(String email){
        System.out.println("调用 private User(String email)");
    }

    protected User(String name,String password,String email,String tel){
        System.out.println("调用 protected User(String name,String password,String email,String tel)");
    }

    public User(String name, String password, int age, int level, String email, String tel, String desc) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.level = level;
        this.email = email;
        this.tel = tel;
        this.desc = desc;
    }

    public String getDesc() {
        System.out.println("getDesc");
        return desc;
    }

    public int getLevel() {
        System.out.println("getLevel");
        return level;
    }

    public String method_public(){
        return "public String method_public()";
    }

    public String method_public(String param){
        return "public String method_public(String param)";
    }

    public String method_public(int level){
        return "public String method_public(int level)";
    }

    protected String method_protected(){
        return "protected String method_protected()";
    }

    private String method_private(){
        return " private String method_private()";
    }

    private String method_private(String params){
        return "private String method_private(String params)";
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
