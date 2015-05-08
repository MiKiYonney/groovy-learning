package chapter4

/**
 * Created by yonney.yang on 2015/5/5.
 */
class ListTest {
    public static void main(String[] args) {
        def myList = [1,2,3]
        assert myList.size() == 3;
        assert myList instanceof ArrayList;

        def longList = (0..10).toList();
        // putAt getAt
        myList = ['a','b','c','d','e','f']
        assert myList[0..2] ==['a','b','c']  //getAt
        myList[0..2] = ['x','y','z']  // putAt
        assert myList == ['x','y','z','d','e','f']
        // plus leftShift minus
        myList = [];
        myList += 'a'
        assert myList == ['a']

        myList += ['b','c']
        assert myList == ['a','b','c']

        myList = []
        myList << 'a' << 'b'
        assert myList == ['a','b']

        assert myList - ['b'] == ['a']
        assert myList*2 == ['a','b','a','b']
        //控制结构
        myList == ['a','b','c']
        assert myList.isCase('a')
        def candidate = 'a'
        switch (candidate){
            case myList :assert true;break;
            default:assert false;
        }
        assert ['x','y','a'].grep(myList) == ['a']
        def log =''
        for (i in [1,'x',5]){
            log += i
        }
        assert log == '1x5'
        //method to manipulate list content
        assert [1,[2,3]].flatten() == [1,2,3]
        assert [1,2,3].intersect([4,3,1]) == [3,1]
        assert [1,2,3].disjoint([4,5,6])
        def list = [[1,0],[0,1,2]]
        list = list.sort{a,b -> a[0] <=> b[0]}
        assert list == [[0,1,2],[0,1]]

        list = list.sort{ item -> item.size()}
        assert list == [[0,1,2],[0,1]]

        def doubled = [1,2,3].collect { item -> item*2 }
        assert doubled == [2,4,6]
        def odd = [1,2,3].findAll {item -> item % 2 == 1 }
        assert odd == [1,3]

        def x = [1,null,1]
        assert [1,1] == x.findAll { it != null }
        //assert [1,1] == x.grep(it != null)

        list = [1,2,3];
        assert list.max() == 3;
        assert list.count(2) == 1
        assert list.min() == 1;

        def even = list.find {
            item -> item % 2 == 0
        }
        assert even ==2
        assert list.every{
            item ->item <5
        }
        assert list.any{
            item ->item <5
        }
        def store =''
        list.each {
            item->store+=item
        }
        assert store =="123"
        list.reverseEach {
            item->store+=item
        }
        assert store =="321"
        assert list.join("-") == "1-2-3"

    }
}
