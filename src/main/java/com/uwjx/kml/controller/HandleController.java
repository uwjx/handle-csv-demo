package com.uwjx.kml.controller;

import com.uwjx.kml.service.CsvHandleService;
import com.uwjx.kml.service.bean.MultiPolygonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class HandleController {

    @Autowired
    private CsvHandleService csvHandleService;

    @GetMapping(value = "handle")
    public List<MultiPolygonData> handle(){
        List<MultiPolygonData> data = csvHandleService.handle();
        return data;
    }
}
