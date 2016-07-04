package advanced
/**
 * Created by yonney on 16/7/4.
 * 进阶:了解具体实现
 * classloader
 */

def cl = this.class.classLoader
while (cl) {
    println cl
    cl = cl.parent
}