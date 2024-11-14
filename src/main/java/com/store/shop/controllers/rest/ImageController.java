package com.store.shop.controllers.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class ImageController
{
    @Value("${image.local.path}")
    private String imageDirPath;

    @GetMapping("/external-image")
    public ResponseEntity<FileSystemResource> getImage(@RequestParam String fileName) {
        File file = new File(imageDirPath + fileName);
        if (file.exists() && !file.isDirectory()) {
            return ResponseEntity.ok()
                    .body(new FileSystemResource(file));
        }
        return ResponseEntity.notFound().build();
    }
}