package chapter5

/**
 * Created by yonney.yang on 2015/5/9.
 */
class ClosureCall {
    def benchMark(repeat,Closure closure){
        def start = System.currentTimeMillis();
        repeat.times{closure(it)}
        def end = System.currentTimeMillis();
        return end - start;
    }
    def slow = benchMark(10000){
        (int)it/2
    }
    def farst = benchMark(10000){
        it.intdiv(2)
    }
}
