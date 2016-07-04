/**
 * Created by yonney on 16/6/12.
 */
//无参数闭包
def sParameterLessClosure = "1 + 2 == ${-> 3}"
assert sParameterLessClosure == '1 + 2 == 3'

//一个参数闭包
def sOneParamClosure = "1 + 2 == ${ w -> w << 3}"
assert sOneParamClosure == '1 + 2 == 3'


def number = 1
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"

assert eagerGString == "value == 1"
assert lazyGString ==  "value == 1"

number = 2
assert eagerGString == "value == 1"
assert lazyGString ==  "value == 2"


// GString和String即使字符串一样他们的HashCode也不会一样,一定要避免使用GString作为MAP的key
assert "one: ${1}".hashCode() != "one: 1".hashCode()
def key = "a"
def m = ["${key}": "letter ${key}"]

assert m["a"] == null  //取不到
