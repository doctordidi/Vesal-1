package com.eutwStudio.front.controller.SystemDisplay;

import com.eutwStudio.front.entity.Level;
import com.eutwStudio.front.entity.Model;
import com.eutwStudio.front.service.SystemDisplayService;
import com.eutwStudio.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * @author 马欢欢
 * @date 2017/12/15
 */
@Component
@RequestMapping("/front/SystemDisplay")
public class SystemDisplayController {
//    @Resource
    private SystemDisplayService systemDisplayService;

    @RequestMapping("/bone")
    public String bone() {
        return "../../front/system3D/motion/bones.jsp?id=001-002-003";
    }
    @RequestMapping("/skull")
    public String skull() {
        return "../../front/system3D/motion/bones";
    }
    @RequestMapping("/upperLimb")
    public String upperLimb() {
        return "../../front/system3D/motion/bones";
    }

    @RequestMapping("/lowerLimb")
    public String lowerLimb() {
        return "../../front/system3D/motion/bones";
    }

    @RequestMapping("/SystemInfo")
    public Map<String,Object> systemInfo(Level level) {
        Map<String,Object> data = new HashMap<String,Object>();
        try {
           List<Model> list = (List<Model>) systemDisplayService.systemInfo(level);
           data.put("info",list);
           data.put("result",true);
           data.put("msg", Constant.SEARCH_SUCCESS);
        } catch (Exception e) {
            data.put("result",false);
            data.put("msg", Constant.SEARCH_FAILURE);
            e.printStackTrace();
        }

        return null;
    }
}