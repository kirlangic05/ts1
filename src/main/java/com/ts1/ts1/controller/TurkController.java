package com.ts1.ts1.controller;

import com.mongodb.MongoException;
import com.ts1.ts1.entity.Turk;
import com.ts1.ts1.service.TurkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/turk")
public class TurkController {

    Logger logger = LoggerFactory.getLogger(TurkController.class);
    @Autowired
    TurkService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turk createTurk(@RequestBody Turk turk){
        logger.info("POST işlemi gerçekleşti.");
        return service.addTurk(turk);
    }

    @GetMapping
    public List<Turk> findAllTurk(){
        logger.info("Tüm datanın GET işlemi gerçekleşti.");
        return  service.findAllTurk();

    }

    @GetMapping("/{id}")
    public Turk findTurkID(@PathVariable String id){
        try {
            logger.info("Id ile GET işlemi gerçekleşti");
            return service.findTurkByid(id);
        } catch (Exception e) {
            logger.error("GET işlemi başarısız oldu. Id'yi kontrol edin. ", e);
            return null;
        }
    }

    @GetMapping("/ulke/{ulke}")
    public List<Turk> findTurkUlke(@PathVariable String ulke){
        try{logger.info("Ülke filtrelemesi ile GET işlemi gerçekleşti.");
        return service.findTurkByUlke(ulke);}
        catch (Exception e) {
            logger.error("GET işlemi başarısız oldu. Id'yi kontrol edin. ", e);
            return null;
        }

    }

    @GetMapping("/sene/{sene}")
    public List<Turk> findTurkSene(@PathVariable String sene){
        try{logger.info("Sene filtrelemesi ile GET işlemi gerçekleşti.");
        return service.findTurkBySene(sene);}
        catch (Exception e) {
            logger.error("GET işlemi başarısız oldu. Id'yi kontrol edin. ", e);
            return null;
        }
    }

    @GetMapping("/komutan/{komutan}")
    public List<Turk> findTurkKomutan(@PathVariable String komutan){
        try{logger.info("Ülke filtrelemesi ile GET işlemi gerçekleşti.");
        return service.findTurkByKomutan(komutan);}
        catch (Exception e) {
            logger.error("GET işlemi başarısız oldu. Id'yi kontrol edin. ", e);
            return null;
        }
    }

    @GetMapping("/savasAdi/{savasAdi}")
    public List<Turk> findTurkSavasAdi(@PathVariable String savasAdi){
        try{logger.info("Savaşın ismi filtrelemesi ile GET işlemi gerçekleşti.");
        return service.findTurkBySavasAdi(savasAdi);}
        catch (Exception e) {
            logger.error("GET işlemi başarısız oldu. Id'yi kontrol edin. ", e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTurk(@PathVariable String id){
       try{ logger.info("Silme işlemi gerçekleşti.");
        return service.deleteId(id);}
       catch (MongoException e) {
           logger.error("Silme işlemi sırasında bir hata oluştu: ",e /*+ e.getMessage()*/);
           return "Silme işlemi başarısız oldu.";
       }
    }

    @PutMapping
    public Turk updateTurk(@RequestBody Turk turk){
       try{ logger.info("Verinin güncellenmesi tamamlandı.");
        return service.updateId(turk);}
       catch (MongoException e) {
           logger.error("Silme işlemi sırasında bir hata oluştu: ",e);
           return null;
       }
    }

}
