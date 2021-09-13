package com.example.AZplastering.model;


public class FileInfo {
    private Long id;
    private String filename;
    private String url;

    public FileInfo(Long id ,String filename, String url) {
        this.id = id;
        this.filename = filename;
        this.url = url;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

