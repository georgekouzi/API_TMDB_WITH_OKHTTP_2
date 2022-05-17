package networking;

public interface ResultApi<S,E> {
    void result(S getData,E getException);

}
