package com.example.spring_boot_2d_data.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ApiResponse {

    private Response response;

    @Setter
    @Getter
    static class Response {
        private Service service;
        private String status;
        private Page page;
        private Record record;
        private Result result;
    }

    /*
    result
    - featureCollection
            - type
            - bbox (arr)
            - features (arr)
                - type
                - geometry
                    - type
                    - coordinates (arr)
                    - properties
                        - cat_nam
                        - lnk_nam
                        - cos_num
                        - cos_nam
                        - cos_lvl
                        - len_tim
                        - leng_lnk
                        - comment
                - id
     */

    @Getter
    @Setter
    static class Service {
        private String name;
        private String version;
        private String operation;
        private String time;
    }

    @Getter
    @Setter
    static class Record {
        private int total;
        private int current;
    }

    @Getter
    @Setter
    static class Page {
        private int total;
        private int current;
        private int size;
    }

    @Getter
    @Setter
    static class FeatureCollection {
        private String type;
        private List<Double> bbox;
        private List<Feature> features;
    }

    @Getter
    @Setter
    static class Feature {
        private String type;
        private Geometry geometry;
        private String id;
    }

    @Getter
    @Setter
    static class Geometry {
        private String type;
        private List<List<List<Double>>> coordinates;
        private Properties properties;
    }


    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Properties {
        private String catNam;
        private String lnkNam;
        private String cosNum;
        private String cosNam;
        private String cosLvl;
        private String lenTim;
        private String lengLnk;
        private String comment;
    }

    @Getter
    @Setter
    static class Result {
        private FeatureCollection featureCollection;
    }
}
