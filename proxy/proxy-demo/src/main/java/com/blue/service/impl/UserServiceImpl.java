package com.blue.service.impl;

import com.blue.service.UserService;

/**
 * @author shenjie
 * @version v1.0
 * @Description
 * @Date: Create in 15:22 2017/12/29
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

public class UserServiceImpl implements UserService {

    @Override
    public void save(String user,String password) {
        System.out.println("存储用户信息("+user+","+password+")");
    }

    @Override
    public void delete(String id) {
        System.out.println("删除用户:"+id);
    }
}
