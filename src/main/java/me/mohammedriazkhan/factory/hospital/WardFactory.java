package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.utility.IDGenerator;

public class WardFactory {

    public static Ward getWard(int wardId, String wardCode) {
        return (Ward) new Ward.WardBuilder()
                .wardId(IDGenerator.genId())
                .wardCode(wardCode)
                .build();
    }



}
