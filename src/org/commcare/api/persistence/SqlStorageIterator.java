package org.commcare.api.persistence;

import org.javarosa.core.services.storage.IStorageIterator;
import org.javarosa.core.services.storage.Persistable;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wpride1 on 6/25/15.
 */
public class SqlStorageIterator<E extends Persistable> implements IStorageIterator, Iterator<E> {

    List<E> mList;
    int count = 0;


    public SqlStorageIterator(List<E> list){
        this.mList = list;
        mList.listIterator();
    }

    @Override
    public int numRecords() {return mList.size();}


    @Override
    public int peekID() {
        return mList.get(count+1).getID();
    }

    @Override
    public int nextID() {
        return 0;
    }

    @Override
    public E nextRecord() {
        return null;
    }

    @Override
    public boolean hasMore() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
