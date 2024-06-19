package com.adeshcoder.Backingfor30mincoding.ServiceImp;

import com.adeshcoder.Backingfor30mincoding.Entities.Video;
import com.adeshcoder.Backingfor30mincoding.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class VideoService {

    @Value("${upload.path}")  // Define 'upload.path' in application.properties or application.yml
    private String uploadPath;

    public Video saveVideo(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = uploadPath + File.separator + fileName;

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(file.getBytes());
        }

        // Here you can return any metadata or identifier related to the file
        Video video = new Video();
        video.setName(fileName);
        video.setType(file.getContentType());
        return video;
    }

    public Optional<Video> getVideoById(Long id) {
        // Implement as needed for your application
        return Optional.empty();
    }

    // Other service methods (e.g., find video by id)
}
