package factories.hospital;

import domain.hospital.Ward;
import utility.IDGenerator;

public class WardFactory {

    public static Ward getWard(int wardId, String wardCode) {
        return (Ward) new Ward.WardBuilder()
                .wardId(IDGenerator.genId())
                .build();
    }

}
