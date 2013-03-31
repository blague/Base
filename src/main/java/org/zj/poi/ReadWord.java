package org.zj.poi;

import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.*;

public class ReadWord {

    public static final  String path = "C:\\Users\\blague\\Downloads\\机场代码.doc";

    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream(new File(path));
            WordExtractor extrator = new WordExtractor(in);
            String[] strs = extrator.getParagraphText();


        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
