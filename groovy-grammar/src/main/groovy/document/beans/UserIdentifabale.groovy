package document.beans

/**
 * Created by yonney on 16/7/10.
 */
class UserIdentifabale {
    Long id
    String name
    def asType(Class target) {
        if (target==Identifiable) {
            return new Identifiable(name: name)
        }
        throw new ClassCastException("User cannot be coerced into $target")
    }
}
