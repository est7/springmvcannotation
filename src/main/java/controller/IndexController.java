package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView index = new ModelAndView("index");
        index.addObject("message", "Hello S11Pring MVC");
        return index;
    }


    @RequestMapping("/jump")
    public ModelAndView jump() {
        //redirect:/index 表示客户端跳转到index意思
        ModelAndView mav = new ModelAndView("redirect:/addProduct11");
        return mav;
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        //映射 /check 到方法check()
        //为方法check()提供参数HttpSession session，这样就可以在方法体中使用session了
       // 接下来的逻辑就是每次访问为session中的count+1.
      //  最后跳转到check.jsp页面
        Integer i = (Integer) session.getAttribute("count");
        if (i == null) {
            i = 0;
        }
        i++;
        session.setAttribute("count", i);
        ModelAndView mav = new ModelAndView("check");
        return mav;
    }

}

