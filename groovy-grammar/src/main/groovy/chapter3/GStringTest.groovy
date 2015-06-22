package chapter3

/**
 * Created by yonney.yang on 2015/4/17.
 */
class GStringTest {
    GString gString = new GString() {
        @Override
        String[] getStrings() {
            return new String[1];
        }
    }
}
