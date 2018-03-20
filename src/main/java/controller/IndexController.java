package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2018/3/20 0:58.
 * <p>
 * Description : File in controller , Project in SpringMvcM
 * <p>
 * Content:
 */

@Controller
class IndexController {
    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
        ModelAndView index = new ModelAndView("index");
        index.addObject("message", "Hello S11Pring MVC");
        return index;
    }



    @RequestMapping("/jump")
    public ModelAndView jump(){
        //redirect:/index 表示客户端跳转到index意思
        ModelAndView mav = new ModelAndView("redirect:/addProduct11");
        return mav;
    }

}

