package com.uwjx.kml.service;

import com.google.common.collect.Lists;
import com.uwjx.kml.service.bean.CoordinatePoint;
import com.uwjx.kml.service.bean.MultiPolygonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.List;

@Service
@Slf4j
public class CsvHandleService {

    public List<MultiPolygonData> handle() {
        log.warn("开始处理。。。");
        List<MultiPolygonData> data = Lists.newArrayList();
        try {
            String pathName = "classpath:data/district.csv";
            File filename = ResourceUtils.getFile(pathName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine();
                if(!StringUtils.isEmpty(line)){
                    MultiPolygonData multiPolygonData = new MultiPolygonData();
                    log.warn("line -> {}" , line);
                    String[] strs = line.split(",");
                    String name = strs[0];
                    if(!StringUtils.isEmpty(name)){
                        log.error("name : {}" , name);
                        multiPolygonData.setName(name);
                    }
                    String code = strs[1];
                    if(!StringUtils.isEmpty(code)){
                        code = code.replaceAll("\"" , "");
                        log.error("code : {}" , code);
                        multiPolygonData.setCode(code);
                    }

                    String[] coods = line.split("\\(\\(\\(");
                    if(!StringUtils.isEmpty(coods[1])){
                        log.info("items -> {}" , coods[1]);
                        String[] items = coods[1].split(",");
                        List<CoordinatePoint> points = Lists.newArrayList();
                        for (int i = 0; i < items.length; i++) {
                            if(org.apache.commons.lang3.StringUtils.isNotEmpty(items[i])){
                                String[] item = items[i].split(" ");
//                                log.info("item : {} , {}" , item[0] , item[1]);
                                if(item.length == 2 && !StringUtils.isEmpty(item[0])
                                        && !StringUtils.isEmpty(item[1])){
                                    CoordinatePoint point = new CoordinatePoint();
                                    log.info("item[0] : {}|item[1] : {}" , item[0] , item[1]);
                                    point.setLat(Double.parseDouble(item[0].replaceAll("\"" ,"")));
                                    point.setLng(Double.parseDouble(item[1].replaceAll("\"" ,"")));
                                    points.add(point);
                                }
                            }
                        }
                        multiPolygonData.setPoints(points);
                    }
                    data.add(multiPolygonData);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}