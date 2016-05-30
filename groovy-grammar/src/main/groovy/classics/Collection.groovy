package classics

/**
 * Created by yonney on 16/5/28.
 */
//1. list
//list.getAt
def  numbers = [1,2,3]
println numbers[0]  //1
println numbers[3] //null
println numbers[-1] //3
//println [2,111][4]
println numbers[0..2] //[1, 2, 3]
println numbers[1..<3]  //[2, 3]

numbers << 15
println numbers  //[1, 2, 3, 15]

numbers + [16]
println numbers //[1, 2, 3, 15]

def num = [23,54,34]
num.add(15)
println num

num.remove(3)
println num

//2.映射










