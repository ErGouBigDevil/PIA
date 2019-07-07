import com.sust.pia.model.Contact;
import com.sust.pia.model.Pass;
import com.sust.pia.service.IPassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;
import java.util.List;

/**
 * @Package PACKAGE_NAME
 * @Description
 * @Author Haodong Zhao
 * @Datetime 2019/7/7 13:42
 */

@RunWith(JUnit4ClassRunner.class)// 添加spring测试方案
@ContextConfiguration("/spring-mybatis.xml")// 指定spring配置文件位置
public class PassTest {
    @Autowired
    private IPassService passService;

    @Test
    public void insertPass() {
        Pass insertPass = new Pass(0, 16200, "Alibaba", "testAlibaba", "testAlibaba");
        int rows = passService.insert(insertPass);
        if (rows > 0) {
            System.out.println("您成功添加了" + rows + "条数据！");

        } else {
            System.out.println("执行添加操作失败！！！");
        }
    }

    @Test
    public void findById() {
        Pass Pass = passService.findById(1);
        System.out.println(Pass.toString());
    }

    @Test
    public void deletePassById() {
        int rows = passService.delete(1);
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！！！");
        }
    }

    @Test
    public void updatePass() throws ParseException {
        Pass updatePass = new Pass(3, 16200, "Alibaba", "testAlibaba", "passwordOfAlibaba");
        int rows = passService.update(updatePass);
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        System.out.println(passService.findById(3));
    }

    @Test
    public void findAll() {
        List<Pass> list = passService.findAll(16200);
        System.out.println(list);
        for (Pass Pass : list)
            System.out.println(Pass);

    }

    @Test
    public void findAllData() {
        List<Pass> list = passService.findAllData(16200, 0, 10, "website", "desc");
        System.out.println(list);
        for (Pass Pass : list)
            System.out.println(Pass);

    }

    @Test
    public void count() {
        System.out.println(String.valueOf(passService.count(16200)));
    }

    @Test
    public void findByWebsite() {
        List<Pass> list = passService.findByWebsite(16200, "Baidu");
        for (Pass Pass : list)
            System.out.println(Pass);
    }
}
