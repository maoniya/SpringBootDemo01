package net.maoni.SpringBoot.mapper;

import net.maoni.SpringBoot.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository    //帮助spring 识别这个类是一个组件
public class VideoMapper {
    private static Map<Integer, Video> videoMap = new HashMap<>();

    // 静态加载数据,后续项目应该是直接从数据库中读取数据
    static {
        videoMap.put(1,new Video(1,"常熟第一人民医院"));
        videoMap.put(2,new Video(2,"苏州九龙医院"));
        videoMap.put(3,new Video(3,"苏州广慈医院"));
        videoMap.put(4,new Video(4,"吴中第一人民医院"));
    }

    public List<Video> listVideo(){
        List<Video> list= new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }

}
