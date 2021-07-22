package net.maoni.SpringBoot.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * 标记这是一个异常处理
 */
//@RestControllerAdvice  //标记用于处理异常
@ControllerAdvice
public class CustomExHandle {
//    //处理json
//    @ExceptionHandler(value = Exception.class)
//    Object handleException(Exception e, HttpServletRequest request){
//       return JsonData.buildError("服务端出问题",-2);
//    }

    @ExceptionHandler(value = Exception.class)
    Object handleException(Exception e, HttpServletRequest request){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());
        System.out.println(e.getMessage());
        return modelAndView;
    }
}
