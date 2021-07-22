package net.maoni.SpringBoot.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.maoni.SpringBoot.domain.User;
import net.maoni.SpringBoot.service.impl.UserServiceImpl;
import net.maoni.SpringBoot.utils.JsonData;
import org.thymeleaf.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤器
 */
@WebFilter(urlPatterns = "/api/v1/pri/*",filterName = "loginfilter")
public class LoginFilter implements Filter {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 容器加载的时候
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("开启过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤开始");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        String token =req.getHeader("token");   //从headers中得到token
        if (StringUtils.isEmpty(token)){           // 如果header里面没有token时,从请求的参数里面拿token
            token = req.getParameter("token");
        }
        if (!StringUtils.isEmpty(token)){            //如果还为空,直接返回json字符串或跳转index页面
            // 判断token是否合法
            User user = UserServiceImpl.sessionMap.get(token);  //在登录时在sessionMap里存了token,通过token取出user,若为空则未登录,若不为空则显示正确
            if(user !=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                JsonData jsonData = JsonData.buildError("登录失败,token无效",-2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);         //json转字符
                renderJson(rep,jsonStr);
            }
        }else {
            JsonData jsonData = JsonData.buildError("登录失败,token无效",-3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(rep,jsonStr);
        }
    }
    private void renderJson(HttpServletResponse response,String json){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer=response.getWriter()){
            writer.print(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 容器销毁的时候
     */
    @Override
    public void destroy() {
        System.out.println("destory LoginFilter");
    }
}
