/**
 * Created by yonney.yang on 2015/6/19.
 */
import org.jsoup.Jsoup
import static groovyx.gpars.GParsPool.withPool

System.setProperty("http.proxyHost", "proxy.pvgl.sap.corp")
System.setProperty("http.proxyPort", "8080")
System.setProperty("https.proxyHost", "proxy.pvgl.sap.corp")
System.setProperty("https.proxyPort", "8080")

def SQUARE_METER = '/'
def root = "http://esf.sh.soufun.com"
def bag = ["徐汇康健": "a019-b01614", "闵行古美": "a018-b01601"]

bag.collect {

    def key = it.key
    def value = it.value
    def begin = new Date()
    println "processing ${it}..."

    def index = Jsoup.connect("$root/house-${value}/g23-i31-j3100/").get()
    def pages = index.select("span.fy_text").text().split("/").last().toInteger()
    println "total pages -> $pages"

    //pages = 2

    def docs = withPool(24) {
        (2..pages).toArray().collectParallel { page ->
            println "retrieving page $page"
            Jsoup.connect("$root/house-${value}/g23-i3$page-j3100/").timeout(15000).get()
        }
    }
    def end = new Date()
    def diff = groovy.time.TimeCategory.minus(end, begin)
    println "elapsed time -> ${diff}"

    docs << index

    new File("${key}.csv").with { file ->
        file.withWriter("utf-8") { fs ->
            fs.print "\uFEFF"
            fs.println "community,address,set,storey,top,degree,dir,year,total,area,unitPrice,url"

            docs.each { doc ->
                doc.select("div.houseList > dl > dd").each { dd ->
                    def url = dd.select("> p.title > a").attr("href")
                    def community = dd.select("> p.gray6.mt15 > a > span").text()
                    def address = dd.select("> p.gray6.mt15 > span").text().replace(',', '`')
                    def details = dd.select("> p:nth-child(3)").text().split('/', 5)
                    def total = dd.select("> div.moreInfo > p:nth-child(1) > span.price").text()
                    def area = dd.select("> div.area.alignR").text() - SQUARE_METER
                    def unitPrice = dd.select("> div.moreInfo > p.danjia.alignR.mt5.gray6").text() - SQUARE_METER - '元/'

                    def storey = details[1].toInteger()
                    def top = (details[2] - '层').toInteger()

                    if (storey == 0) {
                        storey = 1
                    }
                    if (top == 0) {
                        top = 1
                    }

                    def degree = storey / top

                    //if (total.toDouble() < 530 && storey > 7 && unitPrice.toDouble() < 45000) {
                    fs.println "$community,$address,${details[0]},${storey},${top},${degree},${details[3]},${details[4]},$total,$area,$unitPrice,$root$url"
                    //}
                }
            }
        }
    }

    "cmd /c start ${key}.csv"
}.each {
    it.execute()
}