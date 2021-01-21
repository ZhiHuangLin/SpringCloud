package com.wecon.springcloud.controller;

import com.wecon.springcloud.entities.Department;
import com.wecon.springcloud.entities.Employee;
import com.wecon.springcloud.entities.CommonResult;
import com.wecon.springcloud.service.EmployeeService;
import com.wecon.springcloud.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhl
 * @create 2021/1/13 10:37
 * @description
 */
@RestController
@Slf4j
public class EmployeeController {

    @Autowired
     private EmployeeService employeeService;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/getEmployee/{id}")
    public CommonResult getEmployee(@PathVariable("id") Long id) {
        Employee employee = (Employee) employeeService.getEmployee(id);
        log.info("***查询结果***"+employee);
        if(employee != null){
            return new CommonResult(200,"查询数据成功，服务端口："+serverPort+",返回数据：",employee);
        }else{
            return new CommonResult(404,"没有对应的记录，服务端口："+serverPort+",返回数据：",null);
        }
    }

    /**
     * 添加用户
     * @param employee
     * @return
     */
    @PostMapping("/addEmployee")
    public CommonResult addEmployee(Employee employee) {
        /**
         * 初始化数据库时使用
         */
        /*
        employee.setName(EmployeeUtil.getName()[0]);
        employee.setAge((long) EmployeeUtil.getAge());
        employee.setSex(EmployeeUtil.getName()[1]);
        employee.setEmail(EmployeeUtil.getEmail());
        employee.setPhone_number(EmployeeUtil.getPhone_number());
        employee.setJoinUsDate(new Timestamp((EmployeeUtil.randomDate("2007-01-01", "2021-01-14")).getTime()));
        employee.setJob_id(EmployeeUtil.getDepartmentAndJob_id());
        employee.setSalary(EmployeeUtil.getSalary());
        employee.setDepartment_id(EmployeeUtil.getDepartmentAndJob_id());
        employee.setManager_id(EmployeeUtil.getManager_id());
        */
        int result = employeeService.addEmployee(employee);
        log.info("***插入结果***"+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功，服务端口："+serverPort+",返回数据：",result);
        }else{
            return new CommonResult(404,"插入数据失败，服务端口："+serverPort+",返回数据：",null);
        }
    }

    /**
     * 修改用户信息
     * @param employee
     * @return
     */
    @PutMapping("/updateEmployee")
    public CommonResult updateEmployee(Employee employee) {
        int result =employeeService.updateEmployee(employee);
        log.info("***更新结果***"+result);
        if(result > 0){
            return new CommonResult(200,"更新数据成功，服务端口："+serverPort+",返回数据：",result);
        }else{
            return new CommonResult(404,"更新数据失败，服务端口："+serverPort+",返回数据：",null);
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployee/{id}")
    public CommonResult deleteEmployee(@PathVariable("id") Long id) {
        int result =employeeService.deleteEmployee(id);
        log.info("***删除结果***"+result);
        if(result > 0){
            return new CommonResult(200,"删除数据成功，服务端口："+serverPort+",返回数据：",result);
        }else{
            return new CommonResult(404,"删除数据失败，服务端口："+serverPort+",返回数据：",null);
        }
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息
     * @return
     */
    @GetMapping("/queryLAWD")
    public CommonResult queryLAWD() {
        Department department =employeeService.queryLAWD();
        log.info("***查询结果***"+department);
        if(department != null){
            return new CommonResult(200,"查询平均工资最低的部门信息成功，服务端口："+serverPort+",返回数据：",department);
        }else{
            return new CommonResult(404,"查询平均工资最低的部门信息失败，服务端口："+serverPort+",返回数据：",null);
        }
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQL")
    public CommonResult queryLAWDByBetterSQL() {
        Department department = employeeService.queryLAWDByBetterSQL();
        log.info("***查询结果***"+department);
        if(department != null){
            return new CommonResult(200,"查询平均工资最低的部门信息成功，服务端口："+serverPort+",返回数据：",department);
        }else{
            return new CommonResult(404,"查询平均工资最低的部门信息失败，服务端口："+serverPort+",返回数据：",null);
        }
    }

    /**
     * 查询平均工资最低的部门LAWD（Lowest Average Wage Department）信息用更好的SQL并使用redis
     * @return
     */
    @GetMapping("/queryLAWDByBetterSQLUsingRedis")
    public CommonResult queryLAWDByBetterSQLUsingRedis(){
        //查询缓存中是否存在
        String id = "minWage";
        boolean hasKey = redisUtils.exists(id);
        Department department;
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id);
            log.info("从缓存获取的数据"+ object);
            return  new CommonResult(200,"从缓存中查询平均工资最低的部门信息成功，服务端口："+serverPort+",返回数据：",object);
        }else{
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            department = employeeService.queryLAWDByBetterSQL();
            //数据插入缓存（set中的参数含义：key值，对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id,department,10L, TimeUnit.MINUTES);
            log.info("数据插入缓存" + department);
            return  new CommonResult(200,"从数据库中查询平均工资最低的部门信息成功，服务端口："+serverPort+",返回数据：",department);
        }
    }

}