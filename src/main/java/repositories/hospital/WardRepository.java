package repositories.hospital;

import domain.hospital.Ward;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class WardRepository implements Repository<Ward> {

    private static WardRepository repository = null;
    private Set<Ward> wards;

    public WardRepository(){
        wards = new HashSet<>();
    }

    public WardRepository getWards() {
        if(repository == null){
            return new WardRepository();
        }
        return repository;
    }

    @Override
    public Ward find(int id) {
        return wards.stream().filter(ward -> ward.getWardId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Ward ward) {

        wards.add(ward);

    }

    @Override
    public Ward read(int id) {
        return find(id);
    }

    @Override
    public void update(Ward ward) {

        Ward ward1 = find(ward.getWardId());
        if(wards.contains(ward1)){
            wards.remove(ward1);
            wards.add(ward);
        }

    }

    @Override
    public void delete(Ward ward) {
        wards.remove(ward);
    }

    @Override
    public Set<Ward> getAll() {
        return wards;
    }


}
