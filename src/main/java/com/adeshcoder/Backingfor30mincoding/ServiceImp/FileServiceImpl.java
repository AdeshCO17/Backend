package com.adeshcoder.Backingfor30mincoding.ServiceImp;

import com.adeshcoder.Backingfor30mincoding.Services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
//@NoArgsConstructor
//@AllArgsConstructor
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //file name fetching
        String name=file.getOriginalFilename(); // name of the file

        //random name generate file
        String randomID= UUID.randomUUID().toString();
        String fileName1=randomID.concat(name.substring(name.lastIndexOf(".")));  // new filename

        //fullPath
        String filePath= path+ File.separator+fileName1;

        // create folder if not created
        File f=new File(path);       //
        if(!f.exists()) {
            f.mkdir();
        }

        // file copy

        Files.copy(file.getInputStream(), Paths.get(filePath)); // getInputstream use for read the file data or get the file data

        return fileName1;



    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath=path+File.separator+fileName;// this is used to give the actual path of image that stored in image folder

        InputStream is=new FileInputStream(fullPath);   //taking out the image after giving the  full path of that image
        return is;   // return the file or image
    }


}
