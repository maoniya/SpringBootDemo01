package net.maoni.SpringBoot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.maoni.SpringBoot.domain.Video;
import net.maoni.SpringBoot.service.VideoService;
import net.maoni.SpringBoot.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 视频控制器
 * 注:Controller和RestController的区别
 * 1.RestController = ResponseBody+Controller   返回json数据
 */
@RestController
@RequestMapping("/api/v1/pub/video")
public class videoController {
    @Autowired
    private VideoService videoService;

    //@RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("list")   //GetMapping = @RequestMapping(method = RequestMethod.GET)
    public Object list() throws JsonProcessingException {
        List<Video> list =videoService.listVideo();
        //序列化
        ObjectMapper objectMapper =new ObjectMapper();
        String jsonStr =objectMapper.writeValueAsString(list);
        System.out.println(jsonStr);

        //反序列化回去
        List <Video>temp = objectMapper.readValue(jsonStr,List.class);
        return JsonData.buildSuccess(temp);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideo(@RequestBody Video video){
        System.out.println(video.toString());
        return  JsonData.buildSuccess("");
    }

}
