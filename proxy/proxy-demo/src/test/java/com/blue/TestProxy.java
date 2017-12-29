package com.blue;

import com.blue.service.UserService;
import com.blue.service.handle.CustomInvocationHandler;
import com.blue.service.impl.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 15:28 2017/12/29
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

public class TestProxy {
    /**
     * 动态代理使用
     */
    @Test
    public void testProxy(){
        /*
        动态代理所需条件
        1.代理类(CustomInvocationHandler)
        2.被代理的对象(UserServiceImpl)
        3.被代理对象的接口列表(UserService)
        4.代理工具类(Proxy)
         */
        UserService service = new UserServiceImpl();
        service = (UserService)Proxy.newProxyInstance(CustomInvocationHandler.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),new CustomInvocationHandler(service));

        System.out.println("调用UserServiceImpl的save方法:");
        service.save("zhangsan","123456");
        System.out.println();

        System.out.println("调用UserServiceImpl的delete方法:");
        service.delete("kevin");
    }

}
