package document.Specification

/**
 * Created by yonney on 16/7/10.
 * 1.4 面向对象
 */
//与java不同的地方
//1.public变量自动转换成属性,默认会有get set方法.
//2.未声明访问类型的默认为public,方法或变量
//3.文件名跟类名不一定要一样
//4.一个文件可能包含多个类,不包含则被认为为脚本

//Normal class

//Inner class
class Outer {
    private String privateStr;

    def callInnerMethod() {
        new Inner().methodA();
    }

    class Inner {
        def methodA() {
            println "${privateStr}"
        }
    }
}

new Outer().callInnerMethod()

class Outer2 {
    private String privateStr = "some string"

    def startThred() {
        new Thread(new Inner2()).start();
    }

    class Inner2 implements Runnable {
        void run() {
            println "${privateStr}."
        }
    }
}

new Outer2().startThred();

//Anonymous inner class 匿名内部类
class Outer3 {
    private String privateStr = 'some string'

    def startThred() {
        new Thread(new Runnable() {
            @Override
            void run() {
                println("${privateStr}")
            }
        }).start();
    }
}

new Outer3().startThred();

//Abstract class
abstract class Abstract {
    String name

    abstract def abstractMethod()

    def concreteMethod() {
        println 'concrete'
    }
}

//Interface
interface Greeter {
    void greet(String name)
}

interface ExtendedGreeter extends Greeter {
    void sayBye(String name)
}

class DefaultGreeter {
    void greet(String name) { println "Hello" }
}

greeter = new DefaultGreeter()
coerced = greeter as Greeter
assert coerced instanceof Greeter


//Constructors












