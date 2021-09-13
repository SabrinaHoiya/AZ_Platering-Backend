package com.example.AZplastering.service;

import com.example.AZplastering.dto.ChantierRepository;
import com.example.AZplastering.model.Chantier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ChantierService {
    @Autowired
    private ChantierRepository chantierRepo;

    public void  saveProductToDB(MultipartFile file,MultipartFile file2,MultipartFile file3, MultipartFile file4,
                                 MultipartFile file5,String name ,String client, String region , String type_travaux ,
            String type_projet)
    {

        Chantier p = new Chantier();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {System.out.println("not a a valid file");}
        try {
            p.setFilePath (file.getBytes());} catch (IOException e) {
            e.printStackTrace();}
        p.setFileName(fileName) ;

        String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
        if(fileName2.contains(".."))
        {System.out.println("not a a valid file");}
        try {p.setFilePath2 (file2.getBytes());} catch (IOException e) {
            e.printStackTrace();}
        p.setFileName2(fileName2) ;

        String fileName3 = StringUtils.cleanPath(file3.getOriginalFilename());
        if(fileName3.contains(".."))
        {System.out.println("not a a valid file");}
        try {p.setFilePath3 (file3.getBytes());
        } catch (IOException e) {
            e.printStackTrace();}
        p.setFileName3(fileName3) ;

        String fileName4 = StringUtils.cleanPath(file4.getOriginalFilename());
        if(fileName4.contains(".."))
        {System.out.println("not a a valid file");}
        try {p.setFilePath4 (file4.getBytes());
        } catch (IOException e) {e.printStackTrace();
        }
        p.setFileName4(fileName4) ;

        String fileName5 = StringUtils.cleanPath(file5.getOriginalFilename());
        if(fileName5.contains(".."))
        {System.out.println("not a a valid file");}
        try {p.setFilePath5 (file5.getBytes());
        } catch (IOException e) {e.printStackTrace();}
        p.setFileName5(fileName5) ;

        p.setName(name);
        p.setClient(client);
        p.setRegion(region);
        p.setType_travaux(type_travaux);
        p.setType_projet(type_projet);


        chantierRepo.save(p);
    }
    public List<Chantier> getAllChantiers()
    {
        return chantierRepo.findAll();
    }

    public Optional<Chantier> getChantierById(Long id){
        return chantierRepo.findById(id);}

    public void deleteChantierById(Long id)
    {
        chantierRepo.deleteById(id);
    }


    public void chageChantierName(Long id ,String name)
    {
        Chantier p = new Chantier();
        p = chantierRepo.findById(id).get();
        p.setName(name);
        chantierRepo.save(p);
    }
    public void changeChantierClient(Long id , String client)
    {
        Chantier p = new Chantier();
        p = chantierRepo.findById(id).get();
        p.setClient(client);
        chantierRepo.save(p);
    }
    public void changeChantierRégion(Long id , String region)
    {
        Chantier p = new Chantier();
        p = chantierRepo.findById(id).get();
        p.setRegion(region);
        chantierRepo.save(p);
    }
    public void changeChantierTypeTravx(Long id , String type_travaux)
    {
        Chantier p = new Chantier();
        p = chantierRepo.findById(id).get();
        p.setType_travaux(type_travaux);
        chantierRepo.save(p);
    }
    public void changeChantierType(Long id, String type_projet)
    {
        Chantier p = new Chantier();
        p = chantierRepo.findById(id).get();
        p.setType_projet(type_projet);
        chantierRepo.save(p);
    }
}
