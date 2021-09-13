package com.example.AZplastering.controller;
import java.util.ArrayList;
import java.util.List;

import com.example.AZplastering.ResponseMessage;
import com.example.AZplastering.model.FileModel;
import com.example.AZplastering.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class UploadFileController {

    @Autowired
    FileRepository fileRepository;


    @PostMapping("/upload")
    public ResponseEntity uploadMultipartFile(@Valid @RequestParam("files") MultipartFile[] files, Model model) {
        List fileNames = new ArrayList();


        try {
            String message ="";
            List storedFile = new ArrayList();

            for(MultipartFile file: files) {
                FileModel fileModel = fileRepository.findByName(file.getOriginalFilename());
                if(fileModel != null) {
                    // update new contents
                    fileModel.setPic(file.getBytes());
                }else {
                    fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
                }

                fileNames.add(file.getOriginalFilename());
                storedFile.add(fileModel);
            }

            // Save all Files to database
            fileRepository.saveAll(storedFile);

            message = "Uploaded the file successfully: ";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Could not upload the file: " + "!"));
        }

    }
}

