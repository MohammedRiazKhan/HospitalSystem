package me.mohammedriaz.factories.employee;

import me.mohammedriaz.domain.employee.Qualification;

public class QualificationFactory {

    public static Qualification getQualification(int qualificationId, String qualificationName, String instituteName, String duration) {
        return (Qualification) new Qualification.QualificationBuilder()
                .build();
    }

}
