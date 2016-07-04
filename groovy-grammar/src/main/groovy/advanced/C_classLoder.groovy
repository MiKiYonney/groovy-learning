package advanced

/**
 * Created by yonney on 16/7/4.
 * RootLoader如何体现为Groovy的classpath管理者
 */

println this.class.classLoader;
println C.classLoader;
println()

println groovy.ui.GroovyMain.classLoader
//println org.objectweb.asm.ClassVisitor.classLoader
println()

println String.classLoader
println()

println org.codehaus.groovy.tools.GroovyStarter.classLoader
println ClassLoader.systemClassLoader.findLoadedClass('org.codehaus.groovy.tools.GroovyStarter')?.classLoader
println()
