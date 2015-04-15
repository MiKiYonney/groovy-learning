/**
 * Created by yonney.yang on 2015/4/11.
 */
class Syntax {
    public static void main(String[] args) {
        def classes = [String,List,File]
        for(clazz in classes){
            println(clazz.'package'.name)
        }
        //so cool
        println([String,List,File].'package'.name)
        // parser xml
        def xml = new XmlSlurper().parse(new File("text.xml"))

        //基本语法
        def x =1;
        assert x instanceof Integer

        //list
        def roman = ['','1','2','3','4','5']
        assert roman[4] == '4'
        //map
        def http = [
                100 : 'continue',
                200 : 'OK',
                400 : 'Bad Request'
        ]
        assert http[200] == 'OK'
        //ranges
        def ranges = 1..10;
        assert ranges.contains(5)
        assert ranges.reverse == 10..1;
        //closure
        def totalClinks = 0;
        def partyPeople = 100;
        1.upto(partyPeople{guestNumber ->
            clinksWithGuest = guestNumber -1;
            totalClinks += clinksWithGuest;
        })
        assert totalClinks == (partyPeople*(partyPeople-1))/2


    }
}
