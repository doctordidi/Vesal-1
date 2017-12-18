package com.thoughtWorks.web;

import com.thoughtWorks.dto.Result;
import com.thoughtWorks.entity.Custom;
import com.thoughtWorks.entity.Subscribe;
import com.thoughtWorks.service.CustomLoginService;
import com.thoughtWorks.util.Constant;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ubuntu
 */
@Controller
@RequestMapping("/CustomLogin")
public class CustomLoginController {
    @Autowired
    private CustomLoginService customLoginService;

    /**
     * 登录
     *
     * @param custom
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    private Map<String, Object> login(Custom custom, HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        try {
            Custom custom1 = customLoginService.login(custom);
            if (custom1 != null) {
                request.getSession().setAttribute("custom", custom1);
                data.put("result", true);
            } else {
                data.put("result", false);
                data.put("msg", Constant.ACCOUNT_OR_PWD_ERROR);
            }
        } catch (UnknownAccountException e) {
            data.put("result", false);
            data.put("msg", Constant.ACCOUNT_NOT_EXIST);
        } catch (LockedAccountException e) {
            data.put("result", false);
            data.put("msg", Constant.ACCOUNT_IS_LOCK);
        } catch (Exception e) {
            data.put("result", false);
            data.put("msg", Constant.ACCOUNT_OR_PWD_ERROR);
        }

        return data;
    }

    /**
     * 注销登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "loginOut")
    @ResponseBody
    private Map<String, Object> loginOut(HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        request.getSession().removeAttribute("custom");
        data.put("result", true);
        data.put("msg", Constant.LOGIN_OUT);
        return data;
    }

    /**
     * 判断是否有session
     *
     * @param session
     * @return
     */
    @RequestMapping("/session")
    @ResponseBody
    public Map<String, Object> session(HttpSession session) {
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            Custom user = (Custom) session.getAttribute("custom");
            if (user != null) {
                data.put("haveSession", true);
                data.put("user", user);
            } else {
                data.put("haveSession", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * 订阅和取消订阅
     *
     * @param subscribe
     * @return
     */
    @RequestMapping("/Subscribe")
    @ResponseBody
    public Map<String, Object> Subscribe(Subscribe subscribe) {
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            customLoginService.subscribe(subscribe);
            data.put("result", true);
            data.put("msg", Constant.SUBSCRIBE_SUCCESS);
        } catch (Exception e) {
            data.put("msg", Constant.UPDATE_FAILURE);
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 用户查找个人订阅
     *
     * @param custom
     * @return
     */
    @RequestMapping("/personal")
    @ResponseBody
    public Map<String, Object> personalSubscription(Custom custom, HttpSession session) {
        Map<String, Object> data = new HashMap<>();
        Custom user = (Custom) session.getAttribute("custom");
        try {
            custom.setcId(user.getcId());
            List<Map<String, Object>> customs = customLoginService.personalSubscription(custom);
            data.put("customs", customs);
            data.put("result", true);
            data.put("msg", Constant.SEARCH_SUCCESS);
        } catch (Exception e) {
            data.put("msg", Constant.SEARCH_FAILURE);
            e.printStackTrace();
        }

        return data;
    }

    @RequestMapping(value = "/customRegister")
    @ResponseBody
    public Result customRegister(Custom custom) {
        try {

            customLoginService.customRegister(custom);

            return Result.success(null, Constant.SEARCH_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();

            return Result.failure(null, Constant.SEARCH_FAILURE);
        }
    }

}
