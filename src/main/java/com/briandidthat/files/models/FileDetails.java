package com.briandidthat.files.models;

public class FileDetails {
    private String fileName;
    private String fileType;
    private Repository repository;
    private Long uploadTime;
    private Integer uploadStatusCode;

    public FileDetails(String fileName, String fileType, Repository repository, Long uploadTime,
            Integer uploadStatusCode) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.repository = repository;
        this.uploadTime = uploadTime;
        this.uploadStatusCode = uploadStatusCode;
    }

    public String getFileName() {
        return fileName;
    }

    public String fileType() {
        return fileType;
    }

    public Repository getRepository() {
        return repository;
    }

    public Long getUploadTime() {
        return uploadTime;
    }

    public Integer uploadStatusCode() {
        return uploadStatusCode;
    }
}
