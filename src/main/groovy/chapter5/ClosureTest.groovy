package chapter5

/**
 * Created by yonney.yang on 2015/5/8.
 */
class ClosureTest {
    public static void main(String[] args) {
        // 简单用法
        def log =''
        (1..10).each {counter -> log += counter}
        assert log == '12345678910'
        log = ''
        (1..10).each {log += it}
        assert log == '12345678910'
        // 赋值声明闭包
        def printer = {line -> print(line)}
        //方法闭包
    }

    def Closure getPrinter(){
        return   {line -> print(line)}
    }
}
