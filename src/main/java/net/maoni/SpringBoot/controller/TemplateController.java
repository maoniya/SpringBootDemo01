package net.maoni.SpringBoot.controller;

import net.maoni.SpringBoot.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("tpl")
public class TemplateController {

    @Autowired
    private WXConfig wxConfig;

    @GetMapping("freemaker")
    public String index1(ModelMap modelMap){
        modelMap.addAttribute("setting",wxConfig);
//        不需要加后缀,再配置文件里已经指定了后缀
        return "user/fm/index";
    }

    @GetMapping("thymeleaf")
    public String index2(ModelMap modelMap){
        modelMap.addAttribute("setting",wxConfig);
//        不需要加后缀,再配置文件里已经指定了后缀
        return "tl/index";
    }
}
