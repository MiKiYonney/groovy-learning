package chapter4

/**
 * Created by yonney.yang on 2015/5/8.
 */
class MapTest {
    public static void main(String[] args) {
        def myMap = [a:1,b:2,c:3]
        assert myMap.size() == 3;
        assert myMap['a'] ==1;

        def emptyMap = [:]
        assert emptyMap.size() == 0;

        def explicitMap = new TreeMap()
        explicitMap.putAll(myMap)
        assert explicitMap('a') == 1

        def x = 'a'
        assert ['x':1] == [x:1]
        assert ['a':1] == [(x):1]

        myMap = [a:1,b:2,c:3]
        assert myMap['a']

        myMap.clear()
        assert myMap.size() == 0;
        myMap = [a:1,b:2,c:3]
        myMap.remove('a')
        assert myMap.size() == 2;
        myMap = [a:1,b:2,c:3]
        def abMap = myMap.subMap(['a','b'])
        assert abMap.size() == 2;

        abMap == myMap.findAll {entry -> entry.value <3 }
        assert abMap.a == 1;

        abMap == myMap.find {entry -> entry.value <2 }
        assert abMap.key == 'a';
        assert abMap.values() == 1

        def doubled = myMap.collect {entry -> entry.value *=2}
        assert doubled instanceof List
        assert doubled.every{
            item -> item%2
        }






    }
}
