package com.ts1.ts1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Turk {
    @Id
    public String id;
    public String savasAdi;
    public String ulke;
    public String komutan;
    public String sene;
    public String olay;
}
