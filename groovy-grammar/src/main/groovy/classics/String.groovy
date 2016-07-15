/**
 *  Created by yonney.yang on 2016/5/25.
 */

//1.字符串字面值
def a = '';
def b = 'He said "He"'
def c = """ one two three""";
def d = """ spread s
        d"""

println("==========")
def age = 10;
println 'age is ${age}' // age is ${age}
println "age is ${age}" //age is 10
println """age is ${age}"""  //age is 10

//2. 字符串索引和索引段
def greeting = "I'm in ShangHai"
println greeting[4] //i
println greeting[-1] //i 从结尾开始算
println greeting[1..2] // 'm
println greeting[1..<3] //'m
println greeting[4..2]  // i m
println greeting[4, 1, 6] // i '

//3.基本操作
def t = "hello"
println 'hello' + 'lll'
println 'hello' * 3  //hellohellohello
println t - 'o' //hell
println t.length()  //5
println t.size()  //5
println t.count('l') //2
println t.contains('ell') //true

//4.字符串方法
println 'hello'.compareToIgnoreCase("hello")
println 'hello'.concat("w")

//5. 比较字符串  大写字母排在小写字母之前
println 'ken' <=> 'ken'  //0
println 'ken' <=> 'kneneth' // -1
println 'ken' <=> 'Ken'  //1
println 'ken'.compareTo('Ken')  //32 after

//6.正则表达式
def regex = ~'cheese'
println 'cheesecake' =~'cheese';//java.util.regex.Matcher[pattern=cheese region=0,10 lastmatch=]
println 'cheesecake' =~regex
println 'cheesecake' ==~regex  //false  精确匹配

def rhyme = 'Humpty Dupty sat on a wall'
println rhyme =~'^humpty'
println rhyme =~'^wall$'


//占位符支持表达式,最后一个表达式需要有值返回
println "${def a1 = 1; def b1 = 2; a1 + b1}"


def number = 3.14
println "${number.toString()}";


//Special case of interpolating closure expressions

def name = "Guillaume"
def date = "April, 1st"

def dollarSlashy = $/
    Hello $name,
    today we're ${date}.

    $ dollar sign
    $$ escaped dollar sign
    \ backslash
    / forward slash
    $/ escaped forward slash
    $/$ escaped dollar slashy string delimiter
/$

println dollarSlashy







