package com.ts1.ts1.repository;

import com.ts1.ts1.entity.Turk;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurkRepository extends MongoRepository<Turk,String> {
    List<Turk> findByUlke(String ulke);
    List<Turk> findByKomutan(String komutan);
    List<Turk> findBySene(String sene);
    List<Turk> findBySavasAdi(String savasAdi);
}
