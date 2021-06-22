package Data0622MapCollection;
// E: element;
// K : Key;
// V : Value;
public class GenericTest<E> {
    private E username;

    public GenericTest() {

    }

    public GenericTest(E username) {
        this.username = username;
    }

    public E getusername() {
        return username;
    }

    public void setUsername(E username) {
        this.username=username;
    }
}
