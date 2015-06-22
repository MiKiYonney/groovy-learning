package chapter5

/**
 * Created by yonney.yang on 2015/5/9.
 */
class Mother {
    int field = 1;
    int foo(){
        return 2;
    }
    Closure birth(param){
        def local = 3;
        def closure = {
            caller -> [this,field,foo(),local,param,caller,this.field]
        }
        return closure;
    }

    public static void main(String[] args) {
        Mother mother = new Mother();
        def closure = mother.birth(4)
        def context = closure.call(this)
        println(context[0].class.name)

        assert context[1..4] == [1,2,3,4]
        println(context[5])
        println(context[6])
       // assert context[5] instanceof Script
        // assert context[6] instanceof Mother

        def firstClosure = mother.birth(4)
        def secondClosure = mother.birth(4)
        assert false == firstClosure.is(secondClosure)

    }
}
