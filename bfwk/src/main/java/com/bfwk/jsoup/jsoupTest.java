package com.bfwk.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class jsoupTest {
    @Test
    public void testImage() {
        try {
            Document document = Jsoup.connect("http://www.18bg.com/app/#group/1/member").get();
            Elements elements = document.select("#datalist");
            for (Element element : elements) {
                System.out.println(element.attr("src"));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testJsoup() {
        String url = "http://music.163.com/#/playlist?id=2039098272";
        try {
            Document document = Jsoup.connect(url).get();
            // Elements elements = document.select("#song-list-pre-cache").select("table
            // tbody").select("tr.event").select("td.rank").select("span.txt");
            Elements elements = document.select(".m-table");
            for (Element element : elements) {
                System.out.println(element.attr("href") + " : " + element.text());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
