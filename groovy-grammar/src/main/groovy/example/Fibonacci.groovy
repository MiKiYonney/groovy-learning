package example

/**
 * Created by yonney.yang on 2015/4/11.
 */
def current = 1;
def next = 1;
10.times {
    print current+ ''
    def newCurrent = next;
    next = next + current;
    current = newCurrent;
}
println("")
