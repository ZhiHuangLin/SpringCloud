import com.wecon.springcloud.PaymentMain8001;
import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.controller.EmployeeController;
import com.wecon.springcloud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zhl
 * @create 2021/1/13 11:16
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentMain8001.class)
@Slf4j
public class EmployeeTest {

    @Autowired
    EmployeeController employeeController;
    @Autowired
    EmployeeService employeeService;

    /**
     * 测试数据
     */
    Long employeeNumber = (long) ((Math.random() * 100000) % 100);
    Long salary = Long.valueOf(3000);
    Date date = new Date();
    Timestamp timeStamp = new Timestamp(date.getTime());
    Employee JackMa = new Employee( (long) ((Math.random() * 100000) % 100),"JackMa","男",18,timeStamp,Long.valueOf(3000));
    Employee JackMa1 = new Employee( (long) ((Math.random() * 100000) % 100),"JackMa","男",28,timeStamp,Long.valueOf(3000));

    @Test
    public void testGetEmployee(){
        Employee employee = employeeService.getEmployee(employeeNumber);
        if(employee != null ){
            log.info("查询成功！返回"+employee);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void testAddEmployee(){
        long result = employeeService.addEmployee(JackMa);
        if(result != 0 && result > 0 ){
            log.info("添加成功！返回"+result);
        }else{
            log.error("添加失败！");
        }

    }
    @Test
    public void testUpdateEmployee(){
        long result = employeeService.updateEmployee(JackMa1);
        if(result == 1){
            log.info("更新成功！返回"+result);
        }else{
            log.error("更新失败！");
        }
    }
    @Test
    public void testDeleteEmployee(){
        long result = employeeService.deleteEmployee(employeeNumber);
        if(result == 1 ){
            log.info("删除成功！返回"+result);
        }else{
            log.error("删除失败！不存在此数据或出现错误！");
        }
    }
}
