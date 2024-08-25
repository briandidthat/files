package com.briandidthat.files.models;

import java.util.List;

public class FileResponse {
    private List<FileDetails> fileDetails;

    public FileResponse(List<FileDetails> fileDetails) {
        this.fileDetails = fileDetails;
    }

    public List<FileDetails> getFileDetails() {
        return fileDetails;
    }
}
