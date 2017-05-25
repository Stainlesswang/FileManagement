package tcu.lxx.filemanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcu.lxx.filemanage.entity.Type;
import tcu.lxx.filemanage.mapper.TypeMapper;
import tcu.lxx.filemanage.service.TypeService;

import java.util.List;
@Service
public class TypeServiceimpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public int deleteById(String typeid) {
        return typeMapper.deleteById(typeid);
    }

    @Override
    public int update(Type type) {
        return typeMapper.update(type);
    }

    @Override
    public List<Type> findTypeAll() {
        return typeMapper.findTypeAll();
    }
}
