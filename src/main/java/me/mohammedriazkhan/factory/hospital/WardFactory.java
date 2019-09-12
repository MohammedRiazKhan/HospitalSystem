package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.helper.IDGenerator;

public class WardFactory {

    public static Ward getWard(String wardCode) {
        return new Ward.WardBuilder()
                .wardId(IDGenerator.generateId())
                .wardCode(wardCode)
                .build();
    }



}
