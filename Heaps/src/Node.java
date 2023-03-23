public interface Node <T extends Comparable<T>> {
    Node getIzq();
    Node getDer();
    T getElem();
}
