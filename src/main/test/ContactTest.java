import com.sust.pia.model.Contact;
import com.sust.pia.service.IContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;
import java.util.List;

/**
 * @Package PACKAGE_NAME
 * @Description 联系人管理测试
 * @Author Haodong Zhao
 * @Datetime 2019/7/6 23:36
 */
@RunWith(JUnit4ClassRunner.class)// 添加spring测试方案
@ContextConfiguration("/spring-mybatis.xml")// 指定spring配置文件位置
public class ContactTest {
    @Autowired
    IContactService contactService;

    @Test
    public void insertContact() {
        Contact insertContact = new Contact(0, 16200, "test", "1111", "test", "test", "test");
        int rows = contactService.insert(insertContact);
        if (rows > 0) {
            System.out.println("您成功添加了" + rows + "条数据！");

        } else {
            System.out.println("执行添加操作失败！！！");
        }
    }

    @Test
    public void findById() {
        Contact Contact = contactService.findById(1);
        System.out.println(Contact.toString());
    }

    @Test
    public void deleteContactById() {
        int rows = contactService.delete(3);
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！！！");
        }
    }

    @Test
    public void updateContact() throws ParseException {
        Contact updateContact = new Contact(4, 16200, "test666", "1111", "test", "test", "test");
        int rows = contactService.update(updateContact);
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        System.out.println(contactService.findById(4));
    }

    @Test
    public void findAll() {
        List<Contact> list = contactService.findAll(16200);
        System.out.println(list);
        for (Contact Contact : list)
            System.out.println(Contact);

    }

    @Test
    public void findAllData() {
        List<Contact> list = contactService.findAllData(16200, 0, 10, "name", "desc");
        System.out.println(list);
        for (Contact Contact : list)
            System.out.println(Contact);

    }

    @Test
    public void count() {
        System.out.println(String.valueOf(contactService.count(16200)));
    }


    @Test
    public void findByName() throws ParseException {

        List<Contact> list = contactService.findByName(16200, "test");
        for (Contact Contact : list)
            System.out.println(Contact);
    }

    @Test
    public void findByKeyword() {
        List<Contact> list = contactService.findByKeyword(16200, "test");
        for (Contact Contact : list)
            System.out.println(Contact);
    }
}
