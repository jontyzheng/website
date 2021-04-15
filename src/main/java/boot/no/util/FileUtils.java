package boot.no.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    private static final String prePath = System.getProperty("user.dir") + "/src/main/resources/static/upload/";

    public static String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "";
        }
        //获取原文件名
        String originalFileName = file.getOriginalFilename();
        //使用 UUID 设置文件的随机名
        String uuid = UUID.randomUUID().toString();
        assert originalFileName != null;
        //获取原文件的文件后缀名
        String suffix = originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
        //文件的新路径
        String path = prePath + uuid + "." + suffix;
        String returnPath = "/upload/" + uuid + "." + suffix;
        File newFile = new File(path);
        if (newFile.getParentFile() != null && !newFile.getParentFile().exists()) {
            System.out.println("创建目录ing");
            if (newFile.getParentFile().mkdirs()) {
                System.out.println("创建目录成功");
            }
            else {
                System.out.println("创建目录失败");
                return "";
            }
        }
        try {
            file.transferTo(newFile);
        }catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return returnPath;
    }
}
