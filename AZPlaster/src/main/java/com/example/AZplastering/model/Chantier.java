package com.example.AZplastering.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Chantier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String client;
    private String region;
    private String type_travaux;
    private String type_projet;

    //@Lob
    //@Type(type="org.hibernate.type.BinaryType")
    //private byte[] image;
    @Column(name = "file_name")
    private String fileName;
    @Lob
    private byte[] filePath;

    @Column(name = "file_name2")
    private String fileName2;
    @Lob
    private byte[] filePath2;

    @Column(name = "file_name3")
    private String fileName3;
    @Lob
    private byte[] filePath3;

    @Column(name = "file_name4")
    private String fileName4;
    @Lob
    private byte[] filePath4;

    @Column(name = "file_name5")
    private String fileName5;
    @Lob
    private byte[] filePath5;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType_travaux() {
        return type_travaux;
    }

    public void setType_travaux(String type_travaux) {
        this.type_travaux = type_travaux;
    }

    public String getType_projet() {
        return type_projet;
    }

    public void setType_projet(String type_projet) {
        this.type_projet = type_projet;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFilePath() {
        return filePath;
    }

    public void setFilePath(byte[] filePath) {
        this.filePath = filePath;
    }

    public String getFileName2() {
        return fileName2;
    }

    public void setFileName2(String fileName2) {
        this.fileName2 = fileName2;
    }

    public byte[] getFilePath2() {
        return filePath2;
    }

    public void setFilePath2(byte[] filePath2) {
        this.filePath2 = filePath2;
    }

    public String getFileName3() {
        return fileName3;
    }

    public void setFileName3(String fileName3) {
        this.fileName3 = fileName3;
    }

    public byte[] getFilePath3() {
        return filePath3;
    }

    public void setFilePath3(byte[] filePath3) {
        this.filePath3 = filePath3;
    }

    public String getFileName4() {
        return fileName4;
    }

    public void setFileName4(String fileName4) {
        this.fileName4 = fileName4;
    }

    public byte[] getFilePath4() {
        return filePath4;
    }

    public void setFilePath4(byte[] filePath4) {
        this.filePath4 = filePath4;
    }

    public String getFileName5() {
        return fileName5;
    }

    public void setFileName5(String fileName5) {
        this.fileName5 = fileName5;
    }

    public byte[] getFilePath5() {
        return filePath5;
    }

    public void setFilePath5(byte[] filePath5) {
        this.filePath5 = filePath5;
    }

    @Override
    public String toString() {
        return "Chantier{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", region='" + region + '\'' +
                ", type_travaux='" + type_travaux + '\'' +
                ", type_projet='" + type_projet + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileName2='" + fileName2 + '\'' +
                ", filePath2='" + filePath2 + '\'' +
                ", fileName3='" + fileName3 + '\'' +
                ", filePath3='" + filePath3 + '\'' +
                ", fileName4='" + fileName4 + '\'' +
                ", filePath4='" + filePath4 + '\'' +
                ", fileName5='" + fileName5 + '\'' +
                ", filePath5='" + filePath5 + '\'' +

                '}';
    }
}
