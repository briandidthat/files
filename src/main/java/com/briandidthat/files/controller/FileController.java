package com.briandidthat.files.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.briandidthat.files.service.FileService;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping(value = "/sftp", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadFileToSftp(@RequestPart(value = "file") MultipartFile file) throws Exception {
        final String fileName = fileService.uploadFileToFtpServer(file);
        return fileName;
    }

    @PostMapping(value = "/sftp/batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadFilesToFtp2(@RequestPart(value = "files") List<MultipartFile> files, @RequestParam String outputFileName) throws Exception {
        final String fileName = fileService.uploadFilesToFtpServer(files, outputFileName);
        return fileName;
    }

    @PostMapping(value = "/drive", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadFileToGoogleCloud(@RequestPart(value = "file") MultipartFile file) throws Exception {
        final String fileName = fileService.uploadFileToGoogleCloud(file);
        return fileName;
    }

    @PostMapping(value = "/cloud/batch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadFilesToGoogleCloud(@RequestPart(value = "files") List<MultipartFile> files) throws Exception {
        final String fileName = fileService.uploadFilesToGoogleCloud(files);
        return fileName;
    }

}
