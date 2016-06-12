/**
 * Created by yonney on 16/6/12.
 */

//1.while
//2.for
for (i in 1..10) {
    println i
}

for (count in [11, 1, 2, 3, 4]) {
    println count;
}

def staff = ['ken': 21, 'john': 25, 'sally': 22];
def totalAge = 0;
for (staffEntry in staff) {
    totalAge += staffEntry.value
}
println totalAge;

def name = "Kenneth"
def list = [];
for (letter in name) {
    list << letter
}
println list
//3.if
//4.switch
def n = 2
switch (n) {
    case 1: println 'One';
    case 2: println 'two'
    case [21, 22, 23, 24]:
        println "i am in";
        //break
    case ~'[0-9]':
        println "i am in regex";
        break
    default: println 'default'
}