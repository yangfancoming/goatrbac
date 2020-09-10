package com.goat.rbac.goatrbac;

import com.goat.rbac.goatrbac.system.util.MD5Utils;
import org.junit.Test;

/**
 * Created by Administrator on 2020/9/1.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/1---22:52
 */
public class MyTest {


    @Test
    public void test(){
        for(int i = 1;i<=26;i++){
            System.out.println((char)(96+i));
        }
    }


    @Test
    public void md5(){
        String username = "yangfan";
        String password = "123123";
        password = MD5Utils.encrypt(username.toLowerCase(), password);
        System.out.println(password);
    }

}
