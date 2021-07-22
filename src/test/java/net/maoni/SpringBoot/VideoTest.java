package net.maoni.SpringBoot;

import junit.framework.TestCase;
import net.maoni.SpringBoot.domain.Video;
import net.maoni.SpringBoot.service.VideoService;
import org.junit.After;import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class) //底层⽤junit SpringJUnit4ClassRunner
@SpringBootTest(classes={MavenDemoApplication.class})//启动整个springboot⼯程
@AutoConfigureMockMvc    //测试controller层对外提供的借口
public class VideoTest {
    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void testBefore(){
        System.out.println("测试before");
    }

    @After
    public void testAfter(){
        System.out.println("测试After");
    }

    /**
     * 测试controller层
     */
    @Test
    public void testVideoListApi() throws Exception{
        //perform 执行一个requestbuilder请求 相当于提交给服务器一个api路径接口
        //传入一个requestBuilder   MockMvcRequestBuilders:构建器 构建http请求
        //发出请求,判断响应码
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn(); //判断是否是http200的响应码

        //拿到响应结果
        int status =mvcResult.getResponse().getStatus();
        //返回结果实体
        System.out.println(status);

        //使用下面的,增加编码说明,不会出现乱码的打印
        String result=mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));

        System.out.println(result);

    }

    /**
     * 测试service层
     */
    @Test
    public void testVideoList(){
        List<Video> videoList = videoService.listVideo();
        TestCase.assertTrue(videoList.size()>0);
    }

}
