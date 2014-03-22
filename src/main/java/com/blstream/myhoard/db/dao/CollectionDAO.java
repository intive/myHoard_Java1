package com.blstream.myhoard.db.dao;

import com.blstream.myhoard.db.model.CollectionDS;
import com.blstream.myhoard.exception.MyHoardException;
import java.util.List;

public interface CollectionDAO {

    public List<CollectionDS> getList();

    public CollectionDS get(int id);

    public void create(CollectionDS object) throws MyHoardException;

    public void update(CollectionDS object) throws MyHoardException;

    public void remove(int id);

    public List<CollectionDS> getList(List<String> sortBy, String sortDirection)
            throws MyHoardException;
}
