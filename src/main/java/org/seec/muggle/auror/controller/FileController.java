package org.seec.muggle.auror.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping(value = "/api")
public class FileController {
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<?> upLoadFile(@RequestParam MultipartFile myFile, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String realFileName = "";
        if (myFile.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("图片未上传");
        } else {
            String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload") + File.separator;
            System.out.println(realPath);
            realFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + myFile.getOriginalFilename();
            String realFileAddress = realPath + realFileName;
            System.out.println(realFileAddress);
            FileUtils.copyInputStreamToFile(myFile.getInputStream(), new File(realFileAddress));
        }
        return ResponseEntity.ok("/uploads/" + realFileName);
    }
}
