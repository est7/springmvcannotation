package controller;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import pojo.UploadedImageFile;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2018/3/20 22:19.
 * <p>
 * Description : File in controller , Project in springmvcannotation
 * <p>
 * Content:
 * 1. 方法的第二个参数UploadedImageFile 中已经注入好了 image
 2. 通过 RandomStringUtils.randomAlphanumeric(10);获取一个随机文件名。 因为用户可能上传相同文件名的文件，为了不覆盖原来的文件，通过随机文件名的办法来规避
 3. 根据request.getServletContext().getRealPath 获取到web目录下的image目录，用于存放上传后的文件。
 4. 调用file.getImage().transferTo(newFile); 复制文件
 5. 把生成的随机文件名提交给视图，用于后续的显示
 * @author Administrator
 */

@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)
            throws IllegalStateException, IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = name + ".jpg";
        File newFile = new File(request.getServletContext().getRealPath("/imagedir"), newFileName);
        newFile.getParentFile().mkdirs();
        //复制文件
        file.getImage().transferTo(newFile);

        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", newFileName);
        return mav;
    }
}