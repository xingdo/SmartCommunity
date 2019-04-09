package com.demo.controller;


import com.demo.domain.Location;
import com.demo.query.LocationQuery;
import com.demo.service.ILocationService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private ILocationService locationService;

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<Location> pagelist(LocationQuery locationQuery) {

        return locationService.queryPage(locationQuery);
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            locationService.delete(id);
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
    public AjaxResult saveOrUpdate(Location location) {
        if (location != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (location.getId() != null) {
                    //修改
                    locationService.update(location);
                } else {
                    //添加
                    locationService.insert(location);
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
    public List<Location > list(){
            return locationService.selectAll();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Location  get(@PathVariable("id")Long id)
            {
            return locationService.selectOne(id);
            }


        }
