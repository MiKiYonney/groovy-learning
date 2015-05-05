package chapter4

/**
 * Created by yonney.yang on 2015/5/4.
 */
class rangesTest {
    public static void main(String[] args) {
        assert (0..10).contains(10)
        assert (0..<10).contains(10)==false;


        def a = new IntRange(0..10)
        assert a.contains(5)

        def today = new Date();
        def yesterday = today - 1;
        assert (yesterday..today).size() == 2;

        assert ('a'..'c').contains('c')

        def log = '';
        for(element in 5..9){
            log += element
        }

        log = ''
        (9..<5).each {
            element -> log +=element
        }
        assert log == '9876'

        // range for switch
        def age = 36;
        def insurance = 0;
        switch (age){
            case 16..20 : insurance = 0.05;break;
            case 21..50 : insurance = 0.06;break;
            case 51..56 : insurance = 0.07;break;
            default: throw new IllegalArgumentException()
        }
        assert insurance == 0.06;
        // filter with ranges
        def ages = [20,36,42,56]
        def midage = 21..50
        assert ages.grep(midage) == [36,42]


    }
}
