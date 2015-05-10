package chapter5

/**
 * Created by yonney.yang on 2015/5/8.
 */
class MethodClosureSample {
    int limit;

    MethodClosureSample(int limit) {
        this.limit = limit
    }

    boolean validate(String value) {
        return value.length() <= limit
    }

     static main(args) {
        MethodClosureSample first = new MethodClosureSample(6);
        MethodClosureSample second = new MethodClosureSample(5);
        Closure firstClosure = first.&validate;
        def words = ['long string', 'medium ', 'short', 'tiny']
        assert 'medium' == words.find { firstClosure }
        assert 'short' == words.find { second.&validate }

    }
}
