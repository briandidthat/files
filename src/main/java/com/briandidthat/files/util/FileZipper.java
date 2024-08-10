package com.briandidthat.files.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import net.logstash.logback.marker.Markers;

public class FileZipper {
    private final static Logger logger = LoggerFactory.getLogger(FileZipper.class);

    private FileZipper() {
    }

    public static synchronized ByteArrayOutputStream zipFile(MultipartFile file, ByteArrayOutputStream output)
            throws Exception {
        if (file.isEmpty())
            throw new FileNotFoundException("File cannot be empty");

        final Map<String, Object> logs = new HashMap<>();

        try {
            String fileName = file.getOriginalFilename();
            byte[] fileBytes = file.getBytes();

            ZipEntry zipEntry = new ZipEntry(fileName);
            ZipOutputStream zipOut = new ZipOutputStream(output);

            zipOut.putNextEntry(zipEntry);
            zipOut.write(fileBytes);
            zipOut.closeEntry();
            zipOut.close();

            logs.put("fileName", fileName);
            logs.put("sizeBeforeZip", fileBytes.length);
            logs.put("sizeAfterZip", output.size());

            logger.info(Markers.append("logs", logs), "File zipped successfully.");
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
