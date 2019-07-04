import com.sust.pia.model.User;
import com.sust.pia.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Package PACKAGE_NAME
 * @Description 测试User相关方法
 * @Author Haodong Zhao
 * @Datetime 2019/7/4 10:57
 */
@RunWith(JUnit4ClassRunner.class)// 添加spring测试方案
@ContextConfiguration("/spring-mybatis.xml")// 指定spring配置文件位置
public class UserTest {
    @Autowired
    IUserService userService;

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void findUserByName() {
        User user = userService.findUserByName("ErGouBigDevil");
        System.out.println(user.toString());
        log.debug("Test: " + user.toString());


    }

    @Test
    public void findUserByNameAndPassword() {
        User user = userService.findByNameAndPassword("ErGouBigDevil", "admin");
        System.out.println(user.toString());

    }

    @Test
    public void insertUser() {
        User insertUser = new User(0, "jacky", "test@qq.com", "test@gmail.com");
        int rows = userService.insertUser(insertUser);
        if (rows > 0) {
            System.out.println("您成功插入了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
    }


}

