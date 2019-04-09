package com.demo.controller;

import com.demo.domain.Department;
import com.demo.query.DepartmentQuery;
import com.demo.service.IDepartmentService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 保存和修改公用的
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Department department ){
        try {
            if(department.getDeid()!=null){
                departmentService.update(department);
            }else{
                departmentService.insert(department);
            }
            return AjaxResult.getAjaxResult().setLog(true).setMsg("保存对象成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult().setMsg("保存对象失败！"+e.getMessage());
        }
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            departmentService.delete(id);
            return AjaxResult.getAjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult().setMsg("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Department  get(@PathVariable("id")Long id)
    {
        return departmentService .selectOne(id);
    }


    /**
     * 查看所有的信息
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Department > list(){
        return departmentService .selectAll();
    }

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<Department> pagelist(DepartmentQuery departmentQuery ) {

        return departmentService.queryPage(departmentQuery);
    }
}
