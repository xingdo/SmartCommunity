package com.demo.controller;


import com.demo.domain.Eventhandle;
import com.demo.query.EventhandleQuery;
import com.demo.service.IEventhandleService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/eventhandle")
public class EventhandleController {

    @Autowired
    private IEventhandleService eventhandleService;

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<Eventhandle> pagelist(EventhandleQuery eventhandleQuery) {

        return eventhandleService.queryPage(eventhandleQuery);
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            eventhandleService.delete(id);
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
    public AjaxResult saveOrUpdate(Eventhandle eventhandle) {
        if (eventhandle != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (eventhandle.getId() != null) {
                    //修改
                    eventhandleService.update(eventhandle);
                } else {
                    //添加
                    eventhandleService.insert(eventhandle);
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
    public List<Eventhandle > list(){
        return eventhandleService.selectAll();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Eventhandle  get(@PathVariable("id")Long id) {
        return eventhandleService.selectOne(id);
    }

    //查找当前用户的所有历史
    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public List<Eventhandle > queryAll(Long id){
        return eventhandleService.queryAll(id);
    }

    //查找当前用户需要完成的任务
    @RequestMapping(value = "/queryNow",method = RequestMethod.GET)
    public List<Eventhandle > queryNow(Long id){
        return eventhandleService.queryNow(id);
    }

    //查找当前用户最新需要执行的任务
    @RequestMapping(value = "/eventNow",method = RequestMethod.GET)
    public Eventhandle eventNow(Long id){
        return eventhandleService.eventNow(id);
    }

}
