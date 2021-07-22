package net.maoni.SpringBoot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Video implements Serializable {
    private int id;
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String summary;
    private int price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String coverImg;
    //返回指定的别名
    @JsonProperty("create_time")
    // 返回指定的时间格式
    @JsonFormat(pattern ="yyyy-MM-dd hh:mm:ss",locale="zh",timezone = "GMT+8")
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Chapter> chapterList;

    public Video(){}    //无参构造
    public Video(int id,String title){
        this.id =id;
        this.title =title;
        this.createTime =new Date();
    }
}
