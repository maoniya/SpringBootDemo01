package net.maoni.SpringBoot;

import junit.framework.TestCase;
import net.maoni.SpringBoot.controller.UserController;
import net.maoni.SpringBoot.domain.User;
import net.maoni.SpringBoot.utils.JsonData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //底层⽤junit SpringJUnit4ClassRunner
@SpringBootTest(classes={MavenDemoApplication.class})//启动整个springboot⼯程
public class UserTest {
    @Autowired
    private UserController userController;

    /**
     * 测试controller层
     */
    @Test
    public void loginTest(){
        User user =new User();
        user.setUsername("maoni");
        user.setPwd("123");

        JsonData jsonData = userController.login(user);
        //断言判断code状态是 1 还是 0
        System.out.println(jsonData.toString());
        TestCase.assertEquals(0,jsonData.getCode());
    }


}
