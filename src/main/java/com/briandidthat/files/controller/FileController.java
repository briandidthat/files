package com.briandidthat.files.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.briandidthat.files.service.FileService;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping(value = "/ftp2", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String zipfile(@RequestPart(value = "file") MultipartFile file) throws Exception {
        final String fileName = fileService.uploadToFtp2(file);
        return fileName;
    }

    @PostMapping(value = "/ftp2/batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String zipfiles(@RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        final String fileName = fileService.uploadFilesToFtp2(files, "combined");
        return fileName;
    }

}
