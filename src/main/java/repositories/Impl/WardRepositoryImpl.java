package repositories.Impl;

import domain.hospital.Ward;
import repositories.hospital.WardRepository;

import java.util.HashSet;
import java.util.Set;

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

    public Ward find(int id) {
        return wards.stream().filter(ward -> ward.getWardId() == id).findAny().orElse(null);
    }

    @Override
    public Ward create(Ward ward) {

        wards.add(ward);

        return ward;
    }

    @Override
    public Ward read(Integer id) {

        Ward ward = find(id);
        if(ward == null){
            return null;
        }
        else {
            return ward;
        }
    }

    @Override
    public Ward update(Ward ward) {

        Ward ward1 = find(ward.getWardId());
        if(wards.contains(ward1)){
            wards.remove(ward1);
            wards.add(ward);
        }

        return ward1;
    }

    @Override
    public void delete(Integer id) {

        Ward ward = find(id);

        wards.remove(ward);
    }

    @Override
    public Set<Ward> getAll() {
        return wards;
    }


}
