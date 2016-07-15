package document.Specification

import org.codehaus.groovy.runtime.InvokerHelper

/**
 * Created by yonney on 16/7/10.
 * 1.3 Program structure
 */

//1.3.1 package
//1.3.2 default import
//import java.lang.*
//import java.util.*
//import java.io.*
//import java.net.*
//import groovy.lang.*
//import groovy.util.*
//import java.math.BigInteger
//import java.math.BigDecimal


import static Boolean.FALSE
assert !FALSE //use directly, without Boolean prefix!

import static Calendar.getInstance as now
assert now().class == Calendar.getInstance().class

import java.util.Date
import java.sql.Date as SQLDate

Date utilDate = new Date(1000L)
SQLDate sqlDate = new SQLDate(1000L)

assert utilDate instanceof java.util.Date
assert sqlDate instanceof java.sql.Date

//1.3.3 Scripts versus classes
class Main {
    static void main(String... args) {
        println 'Groovy world!'
    }
}
// 等价于
println 'Groovy world!'


class Main2 extends Script {
    def run() {
        println 'Groovy world!'
    }
    static void main(String[] args) {
        InvokerHelper.runScript(Main, args)
    }
}










