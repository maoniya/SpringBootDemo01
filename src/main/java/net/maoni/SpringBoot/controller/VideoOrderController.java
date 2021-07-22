package net.maoni.SpringBoot.controller;

import net.maoni.SpringBoot.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

    @RequestMapping("save")
    public JsonData saveorder(){
        return  JsonData.buildSuccess("下单成功");
    }

}
