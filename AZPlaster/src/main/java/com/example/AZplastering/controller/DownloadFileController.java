package com.example.AZplastering.controller;

import com.example.AZplastering.model.FileInfo;
import com.example.AZplastering.model.FileModel;
import com.example.AZplastering.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class DownloadFileController {
    @Autowired
    FileRepository fileRepository;


    @GetMapping("/files")
    public ResponseEntity getListFiles(Model model) {
        List fileInfos = fileRepository.findAll().stream().map(
                        fileModel ->	{
                            Long id = fileModel.getId();
                            String filename = fileModel.getName();
                            String url = MvcUriComponentsBuilder.fromMethodName(DownloadFileController.class,
                                    "downloadFile", fileModel.getName().toString()).build().toString();
                            return new FileInfo(id, filename, url);
                        }
                )
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);

    }


    @GetMapping("/files/{filename}")
    public ResponseEntity downloadFile(@PathVariable String filename) {
        FileModel file = fileRepository.findByName(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getPic());
    }
}
