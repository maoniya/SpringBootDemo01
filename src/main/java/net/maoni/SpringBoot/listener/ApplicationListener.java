package net.maoni.SpringBoot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 应用上下文监听器,除此之外还有应用启动监听,会话监听
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("上下文监听器已启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("上下文监听器已销毁");
    }
}