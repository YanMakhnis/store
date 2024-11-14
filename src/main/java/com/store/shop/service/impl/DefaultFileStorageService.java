package com.store.shop.service.impl;

import com.store.shop.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class DefaultFileStorageService implements FileStorageService {
    @Value("${upload.path}")
    private String uploadPath;

    @Value("${upload.url}")
    private String uploadUrl;


    @Override
    public String saveFile(MultipartFile file) throws IOException {
        if (file != null)
        {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists())
            {
                uploadDir.mkdir();
            }
            //TODO - make more individual solution
            String uuid = UUID.randomUUID().toString().substring(0, 8);
            String fileName = uuid + "_" + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + fileName));
            return fileName;
        }
        return null;
    }
}
