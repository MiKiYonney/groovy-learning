import org.jsoup.Jsoup

/**
 * Created by yonney.yang on 2015/6/18.
 */

Jsoup.connect("http://www.douban.com/tag/").get().select("#content > div > div.article > ul:nth-child(24) > li:nth-child(1) > a").each {
    println it.text()
}
