package chapter4

/**
 * Created by yonney.yang on 2015/5/8.
 */
class Notes {
    public static void main(String[] args) {
        def list = [1, 2, 3, 4]
        list.each {
            list.remove(0)
        }
        new File('myfile.txt').eachLine { println it }

    }
}
