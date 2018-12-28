package com.uwjx.kml.service.bean;

import lombok.Data;

import java.util.List;

@Data
public class MultiPolygonData {

    private String name;
    private String code;
    private List<CoordinatePoint> points;

}
