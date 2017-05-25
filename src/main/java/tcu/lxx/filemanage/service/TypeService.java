package tcu.lxx.filemanage.service;


import tcu.lxx.filemanage.entity.Type;

import java.util.List;

public interface TypeService {

    public int addType(Type type);


    public int deleteById(String typeid);


    public int update(Type type);



    List<Type> findTypeAll();
}
