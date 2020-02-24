package me.suhyuk.ej2nd.o16;

import java.util.Collection;
import java.util.HashSet;

public class IllegalUsageHashSet<E> extends HashSet<E> {
    private int addedCount = 0;

    public IllegalUsageHashSet() {
    }

    public IllegalUsageHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        this.addedCount += 1;
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        this.addedCount += c.size();
        return super.addAll(c);
    }

    public int getAddedCount() {
        return this.addedCount;
    }

}
