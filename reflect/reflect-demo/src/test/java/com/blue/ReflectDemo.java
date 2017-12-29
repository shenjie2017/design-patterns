package com.blue;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 11:11 2017/12/29
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

public class ReflectDemo {

    private String className;
    private Class userClass;

    @Before
    public void init() throws ClassNotFoundException {
        //需要反射的包名和类名
        className = "com.blue.User";
        userClass = Class.forName(className);

//        /**
//         * 获取类有三种方式
//         */
//
//        //第一种方式：
//        Class userClass1 = Class.forName("com.blue.User");
//        //第二种方式：
//        //java中每个类型都有class 属性.
//        Class userClass2 = User.class;
//
//        //第三种方式：
//        //java语言中任何一个java对象都有getClass 方法
//        //c3是运行时类 (e的运行时类是Employee)
//        Class userClass3 = new User().getClass();
    }

    /**
     * 获取类名字
     */
    @Test
    public void getClassName(){
        System.out.println(userClass.getName());
    }

    /**
     *  获得构造方法
     * @throws Exception
     */
    @Test
    public void getConstructors() throws Exception {
        /*
        获取所有public构造方法
         */
        System.out.println("public构造参数列表");
        Constructor[] constructors01 = userClass.getConstructors();
        for (Constructor constructor:constructors01) {
            System.out.println(constructor);
        }
        /*
        获取所有构造方法,包括私有方法和受保护的方法
         */
        System.out.println("private构造参数列表");
        Constructor[] constructors02 = userClass.getDeclaredConstructors();
        for (Constructor constructor:constructors02) {
            System.out.println(constructor);
        }
        //两个String的有参构造
        System.out.println("两个String的有参构造");
        Constructor constructor01 = userClass.getConstructor(String.class,String.class);
        System.out.println(constructor01);
        constructor01.newInstance("user01","123456");
        //无参构造
        System.out.println("无参构造");
        Constructor constructor02 = userClass.getConstructor();
        System.out.println(constructor02);
        constructor02.newInstance();

        System.out.println("私有有参构造");
        Constructor constructor03 = userClass.getDeclaredConstructor(String.class);
        System.out.println(constructor03);
        //private和protected外部无法直接调用，关掉权限的验证
        constructor03.setAccessible(true);
        constructor03.newInstance("123456@qq.com");
    }

    /**
     * 获得所有字段
     * @throws Exception
     */
    @Test
    public void getField() throws Exception {
        //获得所有public的字段
        System.out.println("所有public的字段");
        Field[] fields01 = userClass.getFields();
        for (Field field:fields01) {
            System.out.println(field);
        }
        //获得所有的字段
        System.out.println("获得所有的字段");
        Field[] fields02= userClass.getDeclaredFields();
        for (Field field:fields02) {
            System.out.println(field);
        }

        User user = new User("user01", "123456", 18, 1,"123456@qq.com", "13888888888", "测试数据");

        System.out.println("单独获取某个字段");

        Field field01 = userClass.getField("desc");
        System.out.println(field01);
        String fieldValue01 = (String)field01.get(user);
        System.out.println(fieldValue01);
        field01.set(user,"测试数据被修改");
        System.out.println(user);

        Field field02 = userClass.getDeclaredField("name");
        System.out.println(field02);
        field02.setAccessible(true);
        String fieldValue02 = (String)field02.get(user);
        System.out.println(fieldValue02);
        field02.set(user,"lisi");
        System.out.println(user);

        Field field03 = userClass.getDeclaredField("level");
        System.out.println(field03);
        field03.setAccessible(true);
        int fieldValue03 = (Integer) field03.get(user);
        System.out.println(fieldValue03);
        field03.set(user,2);
        System.out.println(user);
    }

    /**
     * 获得所有方法
     */
    @Test
    public void getMethod() throws Exception{
        //获得所有public方法，包括集成的方法
        System.out.println("所有public方法");
        Method[] methods01 = userClass.getMethods();
        for(Method method:methods01){
            System.out.println(method);
        }
        //获得所有方法，包括私有的和受保护的,但是不包括继承的方法
        System.out.println("所有方法(不包括继承的方法)");
        Method[] methods02 = userClass.getDeclaredMethods();
        for(Method method:methods02){
            System.out.println(method);
        }

        User user = new User();
        //调用公有无参方法
        System.out.println("调用公有无参方法");
        Method method01 = userClass.getMethod("method_public");
        System.out.println(method01);
        Object return01 = method01.invoke(user);
        System.out.println(return01);
        //调用公有有参方法
        System.out.println("调用公有有参方法");
        Method method02 = userClass.getMethod("method_public",String.class);
        System.out.println(method02);
        Object return02 = method02.invoke(user,"my params");
        System.out.println(return02);

        Method method03 = userClass.getMethod("method_public",int.class);
        System.out.println(method03);
        Object return03 = method03.invoke(user,1);
        System.out.println(return03);

        //获得私有方法
        System.out.println("获得私有方法");
        Method method04 = userClass.getDeclaredMethod("method_private");
        System.out.println(method04);
        method04.setAccessible(true);
        Object return04 = method04.invoke(user);
        System.out.println(return04);

        Method method05 = userClass.getDeclaredMethod("method_protected");
        System.out.println(method05);
        method05.setAccessible(true);
        Object return05 = method05.invoke(user);
        System.out.println(return05);

        //调用带参数私有方法
        System.out.println("调用带参数私有方法");
        Method method06 = userClass.getDeclaredMethod("method_private",String.class);
        System.out.println(method06);
        method06.setAccessible(true);
        Object return06 = method06.invoke(user,"my params");
        System.out.println(return06);
    }

    /**
     * 获取实现的接口
     */
    @Test
    public void getInterface(){
       Class[] interfaces = userClass.getInterfaces();
       for(Class cls:interfaces){
           System.out.println(cls);
       }
    }

    /**
     * 获取超类(父类)
     */
    @Test
    public void getSuperClass(){
        Type type = userClass.getGenericSuperclass();
        System.out.println(type);
    }

}
