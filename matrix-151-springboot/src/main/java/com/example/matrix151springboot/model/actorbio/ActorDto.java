package com.example.matrix151springboot.model.actorbio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDto {
    private String type;
    private List<String> akas;
    private String id;
    private Image image;
    private String legacyNameText;
    private String name;
    private String birthDate;
    private String birthPlace;
    private String gender;
    private Double heightCentimeters;
    private List<String> nicknames;
    private String realName;
    private List<Spouse> spouses;
    private List<String> trademarks;
    private List<MiniBio> miniBios;
}
