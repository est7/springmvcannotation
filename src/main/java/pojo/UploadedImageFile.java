package pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator.
 * <p>
 * Created Time : 2018/3/20 22:17.
 * <p>
 * Description : File in utils , Project in springmvcannotation
 * <p>
 * Content:
 * @author Administrator
 */

public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
