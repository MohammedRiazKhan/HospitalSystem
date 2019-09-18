package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.helper.IDGenerator;

public class WardFactory {

    public static Ward getWard(String wardSize) {
        return new Ward.WardBuilder()
                .wardId(IDGenerator.generateId())
                .wardSize(wardSize)
                .build();
    }



}
