package Chap_11;

public interface HashTable<K,V> {

    V get(int index);

    void put(K index, V item);

    void delete(int index);

    int getSize();

    boolean isEmpty();

    int getCapacity();

}



