package com.litte.controller.reception;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litte.entity.reception.TSlideshow;
import com.litte.service.reception.TSlideshowService;
import com.litte.util.BaseController;
import com.litte.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 首页轮播图
 */
@Controller
@RequestMapping(value = "/slideshow")
public class TSlideshowController extends BaseController {


    @Autowired
    TSlideshowService tSlideshowService;

    /**
     * 进入首页轮播图列表页面
     * @return
     */
    @RequestMapping(value = "/listSlideshowView")
    public String listSlideshowView(Model model, String pid, String id) {
        model.addAttribute("pid",pid);
        model.addAttribute("id",id);
        return "html/reception/slideshow/slideshowlist";
    }

    /**
     * 首页轮播图列表
     *
     * @return
     */
    @RequestMapping(value = "/listSlideshow")
    @ResponseBody
    public String listSlideshow(TSlideshow slideshow, int rows, HttpServletRequest request) {
        PageHelper.startPage(slideshow.getPage(),rows);//分页查询
        List<TSlideshow> tSlideshowList = tSlideshowService.selectByExample(slideshow);
        PageInfo<TSlideshow> pageInfo = new PageInfo<>(tSlideshowList);
        slideshow.setPageSize(rows);
        slideshow.setRows(tSlideshowList);
        slideshow.setPage(slideshow.getPage());
        slideshow.setTotal(pageInfo.getPages());
        return JsonUtil.toJsonString(slideshow);
    }

    /**
     * 进入轮播图页面
     * @return
     */
    @RequestMapping(value = "/addSlideshow")
    public String addSlideshow() {
        return "html/reception/slideshow/slideshowadd";
    }

    /**
     * 增加轮播图
     * @return
     */
    @RequestMapping(value = "/addSlide")
    @ResponseBody
    public int addSlide(TSlideshow slideshow,String headPortrait) {
        int i = 0;
        slideshow.setPicture(headPortrait);
        i = tSlideshowService.insertSelective(slideshow);
        return i;
    }


    /**
     * 接口轮播图
     *
     * @return
     */
    @RequestMapping(value = "/listSlideshowByPort")
    @ResponseBody
    public List<TSlideshow> listSlideshowByPort() {
        List<TSlideshow> tSlideshowList = tSlideshowService.selectByExampleByTime();
        return tSlideshowList;
    }

    /**
     * 删除轮播图
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delSlideshow")
    @ResponseBody
    public int delSlideshow(String ids){
        List<String> idlist = Arrays.asList(ids.split(","));
        int delSlideshow = tSlideshowService.deleteByPrimaryKey(idlist);
        return delSlideshow;

    }
}
