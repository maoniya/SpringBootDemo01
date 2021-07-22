package net.maoni.SpringBoot.schedule;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时统计订单,金额
 */
@Component //把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>
public class VideoOrderTask {

    //每隔2s执行一次
//    @Scheduled(fixedRate = 5000)      //按最长时间执行(5s or 4s  取 5s执行一次)
//    @Scheduled(fixedDelay = 5000)       //俩个时间相加(5s 4s  取 9s 执行一次 )
//    @Scheduled(cron = "0 59 14 15-20 * ?")   //每个月15-20号,14点59分 执行一次
    public void sum(){
        //正常的数据是从数据库中查询出
        System.out.println(LocalDateTime.now()+"当前交易额="+ Math.random());
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
