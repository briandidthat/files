package com.briandidthat.files.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileZipper {
    private FileZipper() {
    }

    public static ByteArrayOutputStream zipFile(MultipartFile file, ByteArrayOutputStream output) throws Exception {
        if (file.isEmpty())
            throw new FileNotFoundException("File cannot be empty");

        try {
            String fileName = file.getOriginalFilename();
            byte[] fileBytes = file.getBytes();

            ZipEntry zipEntry = new ZipEntry(fileName);
            ZipOutputStream zipOut = new ZipOutputStream(output);

            zipOut.putNextEntry(zipEntry);
            zipOut.write(fileBytes);
            zipOut.closeEntry();
            zipOut.close();

            return output;
        } catch (Exception e) {
            throw new FileSystemException("Invalid file");
        }
    }

    public static ByteArrayOutputStream zipFiles(List<MultipartFile> files) throws Exception {
        if (files.isEmpty())
            throw new FileNotFoundException("File cannot be empty");

        try {
            final ByteArrayOutputStream output = new ByteArrayOutputStream();

            for (MultipartFile file : files) {
                zipFile(file, output);
            }
            return output;
        } catch (FileSystemException e) {
            throw e;
        }
    }
}
