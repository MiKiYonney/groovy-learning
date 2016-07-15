package document.beans

/**
 * Created by yonney on 16/7/9.
 */
class User {
    public String name;
    public Integer age;

    User(String name) {
        this.name = name
    }

    User(String name, Integer age) {
        this.name = name
        this.age = age
    }

    String getName() { "Name: $name" }
}
