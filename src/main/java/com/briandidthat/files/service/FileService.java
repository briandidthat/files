package com.briandidthat.files.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public String uploadToFtp2(MultipartFile file) {
        return "";
    }

    public String uploadFilesToFtp2(List<MultipartFile> files, String outputFileName) {
        return "";
    }

    public String uploadToGoogleDrive(MultipartFile file) {
        return "";
    }

    public String uploadFilesToGoogleDrive(List<MultipartFile> file) {
        return "";
    }
}
