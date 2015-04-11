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

    }
}
