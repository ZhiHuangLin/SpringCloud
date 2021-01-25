import com.wecon.springcloud.PaymentMain8001;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.entities.Department;
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
import java.util.Scanner;

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
    Employee JackMa = new Employee(15155L,"lucy",18L,"女","13466585@qq.com","1862545625",timeStamp,30L,152323L,30L);
    Employee JackMa1 = new Employee(15155L,"JackMa",18L,"男","13466585@qq.com","1862545625",timeStamp,30L,152323L,20L);
//    Employee JackMa1 = new Employee( (long) ((Math.random() * 100000) % 100),"JackMa","男",28,timeStamp,Long.valueOf(3000));

    @Test
    public void testGetEmployee(){
        Employee employee = employeeService.getEmployee(15173L);
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
        long result = employeeService.deleteEmployee(15154L);
        if(result == 1 ){
            log.info("删除成功！返回"+result);
        }else{
            log.error("删除失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void testDeleteEmployeeBC(){
        CommonResult commonResult = employeeController.deleteEmployee(15191L);
        if(commonResult != null ){
            log.info("删除成功！返回"+commonResult);
        }else{
            log.error("删除失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void queryLAWD(){
        Department department = employeeService.queryLAWD();
        if(department != null ){
            log.info("查询成功！返回"+department);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void queryLAWDByBetterSQL(){
        Department department = employeeService.queryLAWDByBetterSQL();
        if(department != null ){
            log.info("查询成功！返回"+department);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }


    @Test
    public void testGetEmployeeBC(){
        CommonResult commonResult = employeeController.getEmployee(15155L);
        if(commonResult != null ){
            log.info("查询成功！返回"+commonResult);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void testAddEmployeeBC(){
        CommonResult commonResult = employeeController.addEmployee(JackMa);
        if(commonResult != null ){
            log.info("查询成功！返回"+commonResult);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }

    @Test
    public void testBatchAddEmployee(){
        CommonResult commonResult = employeeController.batchAddEmployee(10);
        if(commonResult != null ){
            log.info("查询成功！返回"+commonResult);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void testUpdateEmployeeBC(){
        CommonResult commonResult = employeeController.updateEmployee(JackMa1);
        if(commonResult != null ){
            log.info("查询成功！返回"+commonResult);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void queryLAWDBC(){
        CommonResult commonResult = employeeController.queryLAWD();
        if(commonResult != null ){
            log.info("查询成功！返回"+commonResult);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void queryLAWDByBetterSQLBC(){
        CommonResult commonResult = employeeController.queryLAWDByBetterSQL();
        if(commonResult != null ){
            log.info("查询成功！返回"+commonResult);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
    @Test
    public void queryLAWDByBetterSQLUsingRedisBC(){
        CommonResult commonResult = employeeController.queryLAWDByBetterSQLUsingRedis();
        if(commonResult != null ){
            log.info("查询成功！返回"+commonResult);
        }else{
            log.error("查询失败！不存在此数据或出现错误！");
        }
    }
}
