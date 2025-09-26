package com.example.demo.Controller;


import com.example.demo.Dtos.FileDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/file")
public class FileController {


    private String ROOT_PATH="c:"; //;Linux OS :  '/'
    private String UPLOAD_PATH = "upload";

    @GetMapping("/upload")
    public void upload(){
        log.info("GET /file/upload");

    }

    @PostMapping ("/upload")
    public void upload_post(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        log.info("POST /file/upload" + file);
        System.out.println("File Name : " + file.getOriginalFilename());
        System.out.println("File Size : " + file.getSize()+"Byte");
        String filename = file.getOriginalFilename();
        String uploadPath = ROOT_PATH
                + File.separator //구분자
                + UPLOAD_PATH
                + File.separator;

        File dir = new File(uploadPath);
        if(!dir.exists())
            dir.mkdirs();
        //파일 업로드(단일 파일)

        File fileObject = new File(uploadPath,filename);
        file.transferTo(fileObject);

    }


    @PostMapping ("/uploads")
    @ResponseBody
    public void upload_posts(
            @RequestParam("files") MultipartFile[] files// 여러개가 날아오기 때문에 배열로 받아주어야 함.
    ) throws IOException {
        log.info("POST /file/upload" + files);

        String uploadPath = ROOT_PATH
                + File.separator //구분자
                + UPLOAD_PATH
                + File.separator;

        File dir = new File(uploadPath);
        if(!dir.exists())
            dir.mkdirs();

        for(MultipartFile file : files){
            System.out.println("File Name : " + file.getOriginalFilename());
            System.out.println("File Size : " + file.getSize()+"Byte");
            System.out.println("======================================");
            String filename = file.getOriginalFilename();

            File fileObject = new File(uploadPath,filename);
            file.transferTo(fileObject);

        }


    }



    @PostMapping ("/upload_dto")
    @ResponseBody
    public void upload_post_dto(FileDto dto) throws IOException {
        log.info("POST /file/upload_dto" + dto);
        MultipartFile [] files = dto.getFiles();

        String uploadPath = ROOT_PATH
                + File.separator //구분자
                + UPLOAD_PATH
                + File.separator;

        File dir = new File(uploadPath);
        if(!dir.exists())
            dir.mkdirs();

        for(MultipartFile file : files){
            System.out.println("File Name : " + file.getOriginalFilename());
            System.out.println("File Size : " + file.getSize()+"Byte");
            System.out.println("======================================");
            String filename = file.getOriginalFilename();

            File fileObject = new File(uploadPath,filename);
            file.transferTo(fileObject);

        }





    }
}
