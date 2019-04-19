package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.commons.utils.ApplicationContextUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.ISpringGoodsService;
import com.qianfeng.fxmall.goods.service.impl.SpringGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet不能交给Spring管理
 */
public class GoodsDetailsServlet extends BaseServlet {

    private ISpringGoodsService goodsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //如果要获取代理对象，不同通过getBean（Class）形式获取。只能通过对象名称获取
        goodsService = (ISpringGoodsService) applicationContext.getBean("springGoodsServiceImpl");
        WxbGood wxbGood = goodsService.queryGoodsById("14886110");
        System.out.println(wxbGood.getGoodName());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
