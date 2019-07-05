import com.sust.pia.model.ToDo;
import com.sust.pia.service.IToDoService;
import com.sust.pia.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Package PACKAGE_NAME
 * @Description 测试ToDo相关函数
 * @Author Haodong Zhao
 * @Datetime 2019/7/5 15:24
 */

@RunWith(JUnit4ClassRunner.class)// 添加spring测试方案
@ContextConfiguration("/spring-mybatis.xml")// 指定spring配置文件位置
public class ToDoTest {
    @Autowired
    IToDoService toDoService;

    @Test
    public void insertToDo(){
        ToDo insertToDo = new ToDo(3,16200,"集团聚会",new Date(),"test","test");
        int rows = toDoService.insert(insertToDo);
        if (rows > 0) {
            System.out.println("您成功添加了" + rows + "条数据！");

        } else {
            System.out.println("执行添加操作失败！！！");
        }
    }

    @Test
    public void findById(){
        ToDo ToDo =  toDoService.findById(1);
        System.out.println(ToDo.toString());
    }

    @Test
    public void deleteToDoById(){
        int rows = toDoService.delete(3);
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！！！");
        }
    }

    @Test
    public void updateToDo() throws ParseException {
        ToDo updateToDo = new ToDo(1,16200,"集团聚会",new Date(),"test","test");
        int rows = toDoService.update(updateToDo);
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        System.out.println(toDoService.findById(1));
    }

    @Test
    public void findAll(){
        List<ToDo> list = toDoService.findAll(16200);
        System.out.println(list);
        for(ToDo ToDo:list)
            System.out.println(ToDo);

    }

    @Test
    public void findAllData(){
        List<ToDo> list = toDoService.findAllData(16200, 0,10,"title","desc");
        System.out.println(list);
        for(ToDo ToDo:list)
            System.out.println(ToDo);

    }

    @Test
    public void count(){
        System.out.println(String.valueOf(toDoService.count(16200)));
    }

    @Test
    public void testDate() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("20190103105927");
        System.out.println(date.toString());
    }

    @Test
    public void findByTime() throws ParseException {
        String dateStr1 = "2019-01-01 00:00:00";
        String dateStr2 = "2020-01-01 00:00:00";
        DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse(dateStr1);
        Date date2 = format.parse(dateStr2);

        List<ToDo> list = toDoService.findByTime(date1, date2,16200);
        for(ToDo ToDo:list)
            System.out.println(ToDo);
    }

    @Test
    public void findByKeyword(){
        List<ToDo> list = toDoService.findByKeyword(16200, "集团");
        for(ToDo ToDo:list)
            System.out.println(ToDo);
    }
}
