package com.ts1.ts1.controller;

import com.ts1.ts1.entity.Turk;
import com.ts1.ts1.service.TurkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turk")
public class TurkController {

    @Autowired
    TurkService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turk createTurk(@RequestBody Turk turk){
        return service.addTurk(turk);
    }

    @GetMapping
    public List<Turk> findAllTurk(){
        return service.findAllTurk();

    }

    @GetMapping("/{id}")
    public Turk findTurkID(@PathVariable String id){
        return service.findTurkByid(id);
    }

    @GetMapping("/ulke/{ulke}")
    public List<Turk> findTurkUlke(@PathVariable String ulke){
        return service.findTurkByUlke(ulke);

    }

    @GetMapping("/sene/{sene}")
    public List<Turk> findTurkSene(@PathVariable String sene){
        return service.findTurkBySene(sene);
    }

    @GetMapping("/komutan/{komutan}")
    public List<Turk> findTurkKomutan(@PathVariable String komutan){
        return service.findTurkByKomutan(komutan);
    }

    public List<Turk> findTurkSavasAdi(@PathVariable String savasAdi){
        return service.findTurkBySavasAdi(savasAdi);
    }

    @DeleteMapping("/{id}")
    public String deleteTurk(@PathVariable String id){
        return service.deleteId(id);
    }

    @PutMapping
    public Turk updateTurk(@RequestBody Turk turk){
        return service.updateId(turk);
    }

}
