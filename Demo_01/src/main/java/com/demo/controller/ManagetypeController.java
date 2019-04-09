package com.demo.controller;


import com.demo.domain.Managetype;
import com.demo.query.ManagetypeQuery;
import com.demo.service.IManagetypeService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/managetype")
public class ManagetypeController {

    @Autowired
    private IManagetypeService managetypeService;

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<Managetype> pagelist(ManagetypeQuery managetypeQuery) {

        return managetypeService.queryPage(managetypeQuery);
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            managetypeService.delete(id);
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
    public AjaxResult saveOrUpdate(Managetype managetype) {
        if (managetype != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (managetype.getId() != null) {
                    //修改
                    managetypeService.update(managetype);
                } else {
                    //添加
                    managetypeService.insert(managetype);
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
    public List<Managetype > list(){
            return managetypeService.selectAll();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Managetype  get(@PathVariable("id")Long id)
            {
            return managetypeService.selectOne(id);
            }


        }
