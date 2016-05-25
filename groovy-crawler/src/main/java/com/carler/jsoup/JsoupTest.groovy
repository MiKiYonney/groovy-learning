package com.carler.jsoup

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

/**
 * Created by yonney.yang on 2015/6/18.
 */
String html1 = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
Document doc1 = Jsoup.parse(html1);
println doc1;
println "---------------"


String html2 = "<div><p>Lorem ipsum.</p>";
Document doc2 = Jsoup.parseBodyFragment(html2);
Element body = doc2.body();
println body
println "---------------"

//Load a Document from a URL
Document doc3 = Jsoup.connect("http://baidu.com/").get();
String title = doc3.title();
println title
println "---------------"

/*Document doc4 = Jsoup.connect("http://baidu.com")
        .data("query", "Java")
        .userAgent("Mozilla")
        .cookie("auth", "token")
        .timeout(3000)
        .post();
println doc4;
println "---------------"*/

//Load a Document from a File
File input = new File("/tmp/input.html");
Document doc5 = Jsoup.parse(input, "UTF-8", "http://baidu.com/");
println doc5;
println "---------------"

//---extract data----
//Use DOM methods to navigate a document
File input1= new File("/tmp/input.html");
Document doc = Jsoup.parse(input1, "UTF-8", "http://chapter.example.com/");

Element content = doc.getElementById("content");
Elements links = content.getElementsByTag("a");
for (Element link : links) {
    String linkHref = link.attr("href");
    String linkText = link.text();
}

//Use selector-syntax to find elements
File input2 = new File("/tmp/input.html");
Document doc6 = Jsoup.parse(input2, "UTF-8", "http://chapter.example.com/");

Elements links1 = doc6.select("a[href]"); // a with href
//Elements pngs = doc6.select("img[src$=.png]");
// img with src ending .png
Element masthead = doc6.select("div.masthead").first();
// div with class=masthead
Elements resultLinks = doc6.select("h3.r > a"); // direct a after h3

//Extract attributes, text, and HTML from elements
String html = "<p>An <a href='http://chapter.example.com/'><b>chapter.example</b></a> link.</p>";
Document doc7 = Jsoup.parse(html);
Element link = doc7.select("a").first();

String text = doc7.body().text(); // "An chapter.example link"
String linkHref = link.attr("href"); // "http://example.com/"
String linkText = link.text(); // "chapter.example""

String linkOuterH = link.outerHtml();
// "<a href="http://example.com"><b>chapter.example</b></a>"
String linkInnerH = link.html(); // "<b>chapter.example</b>"

//Working with URLs
Document doc8 = Jsoup.connect("http://jsoup.org").get();

Element link1 = doc8.select("a").first();
String relHref = link1.attr("href"); // == "/"
String absHref = link1.attr("abs:href"); // "http://jsoup.org/"


































