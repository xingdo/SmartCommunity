package com.demo.controller;


import com.demo.domain.${Domain};
import com.demo.query.${Domain}Query;
import com.demo.service.${Domain}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/${domain}")
public class ${Domain}Controller {

    @Autowired
    private I${Domain}Service ${domain}Service;

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<${Domain}> pagelist(${Domain}Query ${domain}Query) {

        return ${domain}Service.queryPage(${domain}Query);
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            ${domain}Service.delete(id);
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
    public AjaxResult saveOrUpdate(${Domain} ${domain}) {
        if (${domain} != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (${domain}.getId() != null) {
                    //修改
                    ${domain}Service.update(${domain});
                } else {
                    //添加
                    ${domain}Service.insert(${domain});
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
    public List<${Domain} > list(){
            return ${domain}Service.selectAll();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ${Domain}  get(@PathVariable("id")Long id)
            {
            return ${domain}Service.selectOne(id);
            }


        }
