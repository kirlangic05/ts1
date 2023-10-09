package com.ts1.ts1.service;

import com.ts1.ts1.entity.Turk;
import com.ts1.ts1.repository.TurkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurkService {
    @Autowired
    TurkRepository repo;

    public Turk addTurk(Turk turk){
        return  repo.save(turk);

    }

           //GET METODLARI
    public List<Turk> findAllTurk(){
        return repo.findAll();
    }
    public Turk findTurkByid(String id){
        return repo.findById(id).get();
    }
    public List<Turk> findTurkByUlke(String ulke){
        return  repo.findByUlke(ulke);
    }
    public List<Turk> findTurkByKomutan(String komutan){
        return repo.findByKomutan(komutan);
    }
    public List<Turk> findTurkBySene(String sene){
        return repo.findBySene(sene);
    }
    public List<Turk> findTurkBySavasAdi(String savasAdi){
        return repo.findBySavasAdi(savasAdi);
    }
    ///////////////////////////////////////////////////////////

    public String deleteId(String id){
        repo.deleteById(id);
        return id+" silme işlemi tamamlandı";
    }

    public Turk updateId(Turk turkRequest){
        Turk existingTurk= repo.findById(turkRequest.getId()).get();
        existingTurk.setId(turkRequest.getId());
        existingTurk.setSene(turkRequest.getSene());
        existingTurk.setUlke(turkRequest.getUlke());
        existingTurk.setKomutan(turkRequest.getKomutan());
        existingTurk.setOlay(turkRequest.getOlay());
        existingTurk.setSavasAdi(turkRequest.getSavasAdi());
        return repo.save(existingTurk);
    }

}
