package chapter5

/**
 * Created by yonney.yang on 2015/5/9.
 */
class MultiMethodSample {
    int mysteryMethod(String value){
        return value.length();
    }
    int mysteryMethod(List list){
        return list.size();
    }
    int mysteryMethod(int x , int y){
        return x+y;
    }

    public static void main(String[] args) {
        MultiMethodSample multiMethodSample = new MultiMethodSample();
        Closure multi = multiMethodSample.&mysteryMethod
        assert 10 == multi("String arg");
        assert 3 == multi(["list","of","value"])
        assert 14 == multi(6,8)
    }
}
