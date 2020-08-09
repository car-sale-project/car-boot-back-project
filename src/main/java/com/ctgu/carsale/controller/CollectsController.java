package com.ctgu.carsale.controller;

import com.ctgu.carsale.entity.Collects;
import com.ctgu.carsale.entity.JsonBean;
import com.ctgu.carsale.service.CollectsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Collects)表控制层
 *
 * @author makejava
 * @since 2020-08-08 15:21:08
 */
@RestController
@RequestMapping("api/v1/collects")
public class CollectsController {
    /**
     * 服务对象
     */
    @Resource
    private CollectsService collectsService;

    /**获取收藏列表**/
    @RequestMapping(value = "get_collects_list_by_userid",method = RequestMethod.POST)
    public List<Collects> getCollectList(Collects collects){
        return this.collectsService.collectsList(collects);
    }

    /**根据汽车id和用户id判断汽车在不在收藏列表**/
    @RequestMapping(value = "in_collects",method = RequestMethod.POST)
    public boolean inCollects(Collects collects){
//        System.out.println(collects.getUserid()+" "+collects.getCarid());
        return this.collectsService.inCollects(collects);
    }

    /**添加汽车进收藏列表**/
    @RequestMapping(value = "add_car",method = RequestMethod.POST)
    public JsonBean addCar(Collects collects) {
        JsonBean jsonBean = new JsonBean();
        //判断是否已经在收藏列表
        if (inCollects(collects)){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("已在收藏列表");
            return jsonBean;
        }
        this.collectsService.insertCollects(collects);
        jsonBean.setStatus(0);
        jsonBean.setMsg("添加成功");
        return jsonBean;
    }

    /**从收藏列表移除**/
    @RequestMapping(value = "remove",method = RequestMethod.POST)
    public JsonBean remove(Collects collects){
        JsonBean jsonBean = new JsonBean();
        Boolean tag = this.collectsService.remove(collects);
        if (!tag){
            jsonBean.setStatus(-1);
            jsonBean.setMsg("移除失败");
            return jsonBean;
        }
        jsonBean.setStatus(0);
        jsonBean.setMsg("移除成功");
        return jsonBean;
    }

}