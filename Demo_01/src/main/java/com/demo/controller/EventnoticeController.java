package com.demo.controller;


import com.demo.domain.Eventnotice;
import com.demo.query.EventnoticeQuery;
import com.demo.service.IEventnoticeService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/eventnotice")
public class EventnoticeController {

    @Autowired
    private IEventnoticeService eventnoticeService;

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<Eventnotice> pagelist(EventnoticeQuery eventnoticeQuery) {

        return eventnoticeService.queryPage(eventnoticeQuery);
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            eventnoticeService.delete(id);
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
    public AjaxResult saveOrUpdate(Eventnotice eventnotice) {
        if (eventnotice != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (eventnotice.getId() != null) {
                    //修改
                    eventnoticeService.update(eventnotice);
                } else {
                    //添加
                    eventnoticeService.insert(eventnotice);
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
    public List<Eventnotice > list(){
            return eventnoticeService.selectAll();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Eventnotice  get(@PathVariable("id")Long id)
            {
            return eventnoticeService.selectOne(id);
            }



}
