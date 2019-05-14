package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.repository.hospital.WardRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("WardInMemory")
public class WardRepositoryImpl implements WardRepository {

    private static WardRepositoryImpl repository = null;
    private Map<Integer, Ward> wards;

    public WardRepositoryImpl(){
        wards = new HashMap<>();
    }

    public static WardRepositoryImpl getWards() {
        if(repository == null){
            return new WardRepositoryImpl();
        }
        return repository;
    }

    /*public Ward find(int id) {
        return wards.stream().filter(ward -> ward.getWardId() == id).findAny().orElse(null);
    }*/

    @Override
    public Ward create(Ward ward) {

        wards.put(ward.getWardId(), ward);

        return ward;
    }

    @Override
    public Ward read(Integer id) {

        return wards.get(id);
    }

    @Override
    public Ward update(Ward ward) {

       wards.replace(ward.getWardId(), ward);
       return wards.get(ward.getWardId());
    }

    @Override
    public void delete(Integer id) {

        wards.remove(id);
    }

    @Override
    public Set<Ward> getAll() {
        return new HashSet<>(wards.values());
    }


}
