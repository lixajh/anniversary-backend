package com.peake.webseed.feature.file.controller;

import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.EnumErrorCode;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.utils.CodeUtils;
import com.peake.webseed.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by CodeGenerator on 2018/09/05.
 */
@RestController
@RequestMapping("/file")
public class FileController extends AbstractController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${file.savePath}")
    private String uploadPath;

    @Value("${file.accessPath}")
    private String accessPath;

    @Value("${file.savePath}")
    private String savePath;

    @Resource
    private ResourceLoader resourceLoader;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
        String suffix = "";
        String[] split = file.getOriginalFilename().split("\\.");
        if (split.length > 1) {
            suffix = split[split.length - 1];
        }
        String newName = CodeUtils.genPicName() + "." + suffix;
        try {
            byte[] bytes = file.getBytes();
            FileUtil.uploadFile(bytes, uploadPath, newName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, String> result = new HashMap<>();
        result.put("url",accessPath + newName);
        result.put("name",newName);
//http://peake.mynatapp.cc/server/image/201810191453148745944.jpg
        return ResultGenerator.genSuccessResult(result);
    }

//    @GetMapping("/{filename:.+}")
////    @ResponseBody
//    public BufferedImage getFile(@PathVariable String filename) {
//        try {
//            return ImageIO.read(new FileInputStream(new File(savePath+ filename)));
//        } catch (Exception e) {
//            return null;
//        }
//    }
    @GetMapping("/{filename:.+}")
    @ResponseBody
    public byte[] getImg(@PathVariable String filename, HttpServletResponse response) throws IOException {
        Path path = Paths.get(savePath + filename);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.getOutputStream().write(data);
        return null;
    }

//    @GetMapping("/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<?> getFile(@PathVariable String filename) {
//        try {
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(savePath, filename)));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
