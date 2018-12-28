package com.uwjx.kml.controller;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.OutputStream;

@RestController
@Slf4j
public class KmlController {

    @GetMapping(value = "kml")
    public String kml(){
//        Element root = DocumentHelper.createElement("kml");  //根节点是kml
//        Document document = DocumentHelper.createDocument(root);
//        //给根节点kml添加属性
//        root.addAttribute("xmlns", "http://www.opengis.net/kml/2.2")
//                .addAttribute("xmlns:gx", "http://www.google.com/kml/ext/2.2")
//                .addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
//                .addAttribute("xsi:schemaLocation",
//                        "http://www.opengis.net/kml/2.2 http://schemas.opengis.net/kml/2.2.0/ogckml22.xsd http://www.google.com/kml/ext/2.2 http://code.google.com/apis/kml/schema/kml22gx.xsd");
//
//        //给根节点kml添加子节点  Document
//        Element documentElement = root.addElement("Document");
//
//        documentElement.addElement("name").addText("kml文件名"); //添加name节点
//        documentElement.addElement("Snippet").addText(""); //Snippet节点
//        Element folderElement = documentElement.addElement("Folder");//Folder节点
//        folderElement.addAttribute("id", "FeatureLayer0");
//        //给Folder节点添加子节点
//        folderElement.addElement("name").addText("kml文件名");
//        folderElement.addElement("Snippet").addText("");
//        //循环添加每一个Placemark节点，有几个坐标点就有几个Placemark节点，这里仅作示例
//        for (int i = 0; i < 5; i++) {
//            Element placeMarkElement = folderElement.addElement("Placemark");
//            placeMarkElement.addAttribute("id", String.valueOf(i));
//            placeMarkElement.addElement("name").addText("每一个坐标点的名字");
//            placeMarkElement.addElement("Snippet").addText("");
//            placeMarkElement.addElement("description").addText("");
//            placeMarkElement.addElement("styleUrl").addText("#IconStyle00");
//            Element pointElement = placeMarkElement.addElement("Point");
//            pointElement.addElement("altitudeMode").addText("clampToGround");
//            //添加每一个坐标点的经纬度坐标，这里仅作示例
//            pointElement.addElement("coordinates").addText("119.39986000,31.13396700000143,0");
//        }
//        Element styleElement = documentElement.addElement("Style");//Style节点
//        styleElement.addAttribute("id", "IconStyle00");
//        // IconStyle
//        Element iconStyleElement = styleElement.addElement("IconStyle");
//        Element iconElement = iconStyleElement.addElement("Icon");
//        iconElement.addElement("href").addText("Layer0_Symbol_107dde08.png");
//        iconStyleElement.addElement("scale").addText("0.250000");
//        // LabelStyle
//        Element labelStyleElement = styleElement.addElement("LabelStyle");
//        labelStyleElement.addElement("color").addText("00000000");
//        labelStyleElement.addElement("scale").addText("0.000000");
//        // PolyStyle
//        Element polyStyleElement = styleElement.addElement("PolyStyle");
//        polyStyleElement.addElement("color").addText("ff000000");
//        polyStyleElement.addElement("outline").addText("0");
//
//        //将kml写出本地
//        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding("utf-8");//设置编码格式
//        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("doc.kml"),format);
//
//        xmlWriter.write(document);
//
//        xmlWriter.close();
//        //开始对文件进行压缩，一个kml文件其实是一个压缩文件，里面包含一个kml文件和一个png图标
//
//        String[] strs = new String[2];
//        strs[0]="doc.kml";
//        strs[1]="Layer0_Symbol_107dde08.png";//这里写图片的路径
//        writeKml(strs, "kml文件名");
//        System.out.println("success");
        return "str";
    }

//    public static void writeKml(String[] strs, String kmlName) throws IOException
//    {
//        String[] files = strs;
//        //File kmlFile = new File("person.kml");
//        OutputStream os = new BufferedOutputStream( new FileOutputStream(kmlName + ".kml"));
//        ZipOutputStream zos = new ZipOutputStream(os);
//        byte[] buf = new byte[8192];
//        int len;
//        for (int i=0;i < files.length;i++) {
//            File file = new File(files[i]);
//            if ( !file.isFile() )
//                continue;
//            ZipEntry ze = new ZipEntry( file.getName() );
//            zos.putNextEntry( ze );
//            BufferedInputStream bis = new BufferedInputStream( new FileInputStream( file ) );
//            while ( ( len = bis.read( buf ) ) > 0 ) {
//                zos.write( buf, 0, len );
//            }
//            zos.closeEntry();
//        }
//
//        zos.closeEntry();
//        zos.close();
//
//    }
}
