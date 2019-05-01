package me.mohammedriaz.factories.visits;

import me.mohammedriaz.domain.visits.MedicalTool;

public class MedicalToolFactory {

    public static MedicalTool getMedicalTool(int toolId, String toolName, String toolCost) {
        return (MedicalTool) new MedicalTool.MedicalToolBuilder()

                .build();
    }

}
