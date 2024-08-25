package com.briandidthat.files.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.briandidthat.files.util.FileZipper;

@Service
public class FileService {

    public String uploadFileToFtpServer(MultipartFile file) {
        return null;
    }

    public String uploadFilesToFtpServer(List<MultipartFile> files) {
        return null;
    }

    public String uploadFileToGoogleCloud(MultipartFile file) {
        return null;
    }

    public String uploadFilesToGoogleCloud(List<MultipartFile> file) {
        return null;
    }
}
