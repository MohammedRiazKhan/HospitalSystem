package me.mohammedriazkhan.factories.visits;

import me.mohammedriazkhan.domain.visits.MedicalTool;

public class MedicalToolFactory {

    public static MedicalTool getMedicalTool(int toolId, String toolName, String toolCost) {
        return (MedicalTool) new MedicalTool.MedicalToolBuilder()

                .build();
    }

}
