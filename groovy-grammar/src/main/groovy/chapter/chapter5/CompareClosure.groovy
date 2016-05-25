package chapter.chapter5

/**
 * Created by yonney.yang on 2015/5/9.
 */
def map = ['a':1,'b':2];
map.each {
    key,value->map[key] = value*2
}
def doubler = { key,value->map[key] = value*2 }
map.each {doubler}
assert map == ['a':2,'b':4]

doubler = new CompareClosure().&doubleMethod;
map.each(doubler)
assert map == ['a':8,'b':16]


def doubleMethod(entry){
    map[entry.key] = entry.value * 2;
}