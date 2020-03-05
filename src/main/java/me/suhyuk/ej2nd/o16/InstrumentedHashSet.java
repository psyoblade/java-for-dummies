package me.suhyuk.ej2nd.o16;

import java.util.Collection;
import java.util.Set;

public class InstrumentedHashSet<E> extends ForwardingSet<E> {

    public InstrumentedHashSet(Set<E> s) {
        super(s);
    }

    private int addedCount = 0;

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
