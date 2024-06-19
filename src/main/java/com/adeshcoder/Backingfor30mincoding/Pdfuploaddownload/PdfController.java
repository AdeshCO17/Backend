package com.adeshcoder.Backingfor30mincoding.Pdfuploaddownload;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UD")
@AllArgsConstructor
public class PdfController {

    @Autowired
    private final PdfFileRepository pdfFileRepository;
    @PostMapping("/pdf/upload")
    public void uploadPDF(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        byte[] fileData = file.getBytes();
        // Save the PDF file data to the database
        PdfFile pdfFile = new PdfFile(fileName, fileType, fileData);
        pdfFileRepository.save(pdfFile);
    }

    @GetMapping("/pdf/download/{id}")
    public ResponseEntity<byte[]> downloadPDF(@PathVariable Long id) {
        Optional<PdfFile> pdfFileOptional = pdfFileRepository.findById(id);
        if (pdfFileOptional.isPresent()) {
            PdfFile pdfFile = pdfFileOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(pdfFile.getFileType()));
            headers.setContentDispositionFormData(pdfFile.getFileName(), pdfFile.getFileName());
            return new ResponseEntity<>(pdfFile.getFileData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<PdfFile>> getAllPdfFiles() {
        List<PdfFile> pdfFiles = pdfFileRepository.findAll();
        if (pdfFiles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(pdfFiles, HttpStatus.OK);
        }
    }
    @GetMapping("/pdf/download/all")
    public ResponseEntity<List<byte[]>> downloadAllPDFs() {
        List<PdfFile> pdfFiles = pdfFileRepository.findAll();
        List<byte[]> pdfFileBytes = new ArrayList<>();

        for (PdfFile pdfFile : pdfFiles) {
            pdfFileBytes.add(pdfFile.getFileData());
        }

        if (!pdfFileBytes.isEmpty()) {
            return new ResponseEntity<>(pdfFileBytes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}
