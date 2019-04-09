package com.demo.controller;


import com.demo.domain.Permission;
import com.demo.query.PermissionQuery;
import com.demo.service.IPermissionService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<Permission> pagelist(PermissionQuery permissionQuery) {

        return permissionService.queryPage(permissionQuery);
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            permissionService.delete(id);
            return AjaxResult.getAjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult().setMsg("删除对象失败！"+e.getMessage());
        }
    }

    /**
     * 保存和修改公用的
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult saveOrUpdate(Permission permission) {
        if (permission != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (permission.getId() != null) {
                    //修改
                    permissionService.update(permission);
                } else {
                    //添加
                    permissionService.insert(permission);
                }
                return AjaxResult.getAjaxResult().setLog(true).setMsg("保存对象成功");
            } catch (Exception e) {
                e.printStackTrace();
                return AjaxResult.getAjaxResult().setMsg("保存对象失败！"+e.getMessage());
            }
        }
        return null;
    }
    /**
     * 查看所有的信息
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Permission > list(){
            return permissionService.selectAll();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Permission  get(@PathVariable("id")Long id)
            {
            return permissionService.selectOne(id);
            }


        }
