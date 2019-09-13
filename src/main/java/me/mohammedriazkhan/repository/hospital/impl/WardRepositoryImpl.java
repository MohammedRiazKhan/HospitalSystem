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
    private Set<Ward> wards;

    public WardRepositoryImpl(){
        wards = new HashSet<>();
    }

    public static WardRepositoryImpl getWards() {
        if(repository == null){
            return new WardRepositoryImpl();
        }
        return repository;
    }


    @Override
    public Ward create(Ward ward) {

        wards.add(ward);

        return ward;
    }

    @Override
    public Ward read(String id) {

        return wards.stream().filter(ward -> ward.getWardId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Ward update(Ward ward) {

        Ward inDB = read(ward.getWardId());

        if(inDB != null){
            wards.remove(inDB);
            wards.add(ward);
            return ward;

        }
        return null;
    }

    @Override
    public void delete(String id) {
        Ward inDB = read(id);
        wards.remove(inDB);
    }

    @Override
    public Set<Ward> getAll() {
        return wards;
    }


}
