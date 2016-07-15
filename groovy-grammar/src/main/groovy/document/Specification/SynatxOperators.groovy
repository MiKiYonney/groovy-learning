package document.Specification

import document.beans.Car
import document.beans.Identifiable
import document.beans.User
import document.beans.UserIdentifabale

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by yonney on 16/7/5.
 */
//1.1.4 Characters:Groovy没有明确的Characters
char cc1 = 'A'
assert cc1 instanceof Character

def c2 = 'B' as char
assert c2 instanceof Character

def c3 = (char) 'C'
assert c3 instanceof Character

//1.1.5 Numbers: byte,char,short,int,long,BigInteger
// primitive types
byte b = 1
char c = 2
short s = 3
int i = 4
long l = 5
// infinite precision
BigInteger bi = 6
//使用def时会自动匹配到合适的数据类型
def a1 = 1
assert a1 instanceof Integer

// Integer.MAX_VALUE
def b1 = 2147483647
assert b1 instanceof Integer

// Integer.MAX_VALUE + 1
def c1 = 2147483648
assert c1 instanceof Long

// Long.MAX_VALUE
def d1 = 9223372036854775807
assert d1 instanceof Long

// Long.MAX_VALUE + 1
def e1 = 9223372036854775808
assert e1 instanceof BigInteger

//1.1.6 Booleans
def myBooleanVariable = true
boolean untypedBooleanVar = false
booleanField = true

//1.1.7 Lists
def numbers = [1, 2, 3]
assert numbers instanceof List

def heterogeneous = [1, "a", true] //同时封装多种类型

//默认是arrayList  可以用as指定类型

def arrayList = [1, 2, 3]
assert arrayList instanceof java.util.ArrayList

def linkedList = [2, 3, 4] as LinkedList
assert linkedList instanceof java.util.LinkedList

LinkedList otherLinked = [3, 4, 5]
assert otherLinked instanceof java.util.LinkedList

//访问list,正数:正向访问   负数:逆向访问
assert arrayList[0] == 1
assert arrayList[-1] == 3

//二维
def multi = [[0, 1], [2, 3]]
assert multi[1][0] == 2

//1.1.8 Arrays
def matrix3 = new Integer[3][3]
assert matrix3.size() == 3

Integer[][] matrix2
matrix2 = [[1, 2], [3, 4]]
assert matrix2 instanceof Integer[][]

//Maps  默认类型是LinkedHashMap
def map = [:] //empty map
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
assert colors['red'] == '#FF0000'

colors['pink'] = '#FF00FF'
colors.yellow = '#FFFF00'

println colors;
assert colors instanceof java.util.LinkedHashMap

def key = 'name'
def person = [key: 'Guillaume']  //这里的key不是变量key的值,这个map的key是"key"
assert !person.containsKey('name')
assert person.containsKey('key')
println person['name']
println person['key']
//如果想使用变量的形式
person = [(key): 'Guillaume']  //===>['name': 'Guillaume']
println person['name']


println("-------------------------------")
//-------------------------------------------------
//1.2. Operators
//1.2.1. Arithmetic operators  // + - * / % ** && & || | ! ++ -- ++=   bool?a:b
//1.2.6 Object operators
def user = new User("Bob")
assert user.name == 'Name: Bob'
//.@
assert user.@name == 'Bob'     //getName
//1..&
def str = 'example of method reference'
def fun = str.&toUpperCase     //方法指针是一个闭包:groovy.lang.Closure
def upper = fun()
assert upper == str.toUpperCase()
//2.*****.&*****用法  闭包
def transform(List elements, Closure action) {
    def result = []
    elements.each {
        result << action(it)
    }
    result
}

String describe(User p) {
    "$p.name is $p.age"
}

def action = this.&describe

def list = [new User('Bob', 42),
            new User('Julia', 35)]
assert transform(list, action) == ['Name: Bob is 42', 'Name: Julia is 35']
//*****.&*****用法  闭包*****END*******
//3.*******.&运行时才确定掉什么方法*****
def doSomething(String str) { str.toUpperCase() }

def doSomething(Integer x) { 2 * x }

def reference = this.&doSomething
assert reference('foo') == 'FOO'
assert reference(123) == 246

//1.2.7. Regular expression operators
//1.以~开头的正则表达式:是java.util.regex.Pattern的实例
def p = ~/foo/
assert p instanceof Pattern
//2.=~:java.util.regex.Matcher的实例
def text = "some text to match"
def m = text =~ /match/
assert m instanceof Matcher
if (!m.find()) {
    throw new RuntimeException("Oops, text not found!")
}
//if (!m) {
//    throw new RuntimeException("Oops, text not found!")
//}

//3.==~ :Match operator
m = text ==~ /match/
assert m instanceof Boolean
if (m) {
    throw new RuntimeException("Should not reach that point!")
}

//1.2.8. Other operators
//[一.操作符: *.] 1. *. == 获得某个集成对象的单个属性集合.相当于foreach之后对某属性的提取
def cars = [new Car(make: 'Peugeot', model: '508'), new Car(make: 'Renault', model: 'Clio')]
def makes = cars*.make
println makes
//[一.操作符: *.]  2. *. 为null的情况,null-safe,不会抛出空指针
cars = [
        new Car(make: 'Peugeot', model: '508'),
        null,
        new Car(make: 'Renault', model: 'Clio')]
assert cars*.make == ['Peugeot', null, 'Renault']
assert null*.make == null
//[一.操作符: *.] *.能用于所有继承Iterable的类
class Component {
    Long id
    String name
}

class CompositeObject implements Iterable<Component> {
    def components = [
            new Component(id: 1, name: 'Foo'),
            new Component(id: 2, name: 'Bar')]

    @Override
    Iterator<Component> iterator() {
        components.iterator()
    }
}

def composite = new CompositeObject()
assert composite*.id == [1, 2]
assert composite*.name == ['Foo', 'Bar']

//[二.操作符: *] 3. *. 传递方法参数
int function(int x, int y, int z) {
    x * y + z
}

def args = [4, 5, 6]
assert function(*args) == 26

args = [4]
assert function(*args, 5, 6) == 26

//[二.操作符: *] 4. *.传递list元素
def items = [4, 5]
def list1 = [1, 2, 3, *items, 6]
assert list1 == [1, 2, 3, 4, 5, 6]

//[二.操作符: *] 5. * 传递map元素
def m1 = [c: 3, d: 4]
def map1 = [a: 1, b: 2, *: m1, d: 8]
assert map1 == [a: 1, b: 2, c: 3, d: 8] //d:8不会被塞入

//[三.操作符Range operator: ..]
def range = 0..5
assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
assert (0..<5).collect() == [0, 1, 2, 3, 4]
assert (0..5) instanceof List
assert (0..5).size() == 6

//[四.操作符Spaceship operator: <=>]  ---compareTo
assert (1 <=> 1) == 0
assert (1 <=> 2) == -1
assert (2 <=> 1) == 1
assert ('a' <=> 'z') == -1

//[五.Subscript operator[]] -- getAt or putAt
def listop = [0, 1, 2, 3, 4]
assert listop[2] == 2
listop[2] = 4
assert listop[0..2] == [0, 1, 4]
listop[0..2] = [6, 6, 6]
assert listop == [6, 6, 6, 3, 4]

//[六.Membership operator:in] ==inCase
def listIncase = ['Grace', 'Rob', 'Emmy']
assert ('Emmy' in listIncase)
assert listIncase.contains('Emmy')
assert listIncase.isCase('Emmy')

//[七.恒等式 ==] --equals
def liste1 = ['Groovy 1.8', 'Groovy 2.0', 'Groovy 2.3']
def liste2 = ['Groovy 1.8', 'Groovy 2.0', 'Groovy 2.3']
assert liste1 == liste2
assert !liste1.is(liste2)  //比较引用

//[八.强制转换操作符:as]
Integer x = 123
String s1 = (String) x  //好像也可以转啊.....
String s2 = x as String
//如果实在转不成功,可以自定义转 如类 Identifiable-----asType方法
def u = new UserIdentifabale(name: 'Xavier')
def pi = u as Identifiable
assert pi instanceof Identifiable
assert !(pi instanceof UserIdentifabale)

//[九.Diamond operator:<>]
List<String> strings = new LinkedList<>()

//[十.Call operator:()]  类中只有有call方法都可以用.call来调用
class MyCallable {
    int call(int x) {
        2*x
    }
}
def mc = new MyCallable()
assert mc.call(2) == 4
assert mc(2) == 4   //==>.call


















































