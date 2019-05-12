package me.mohammedriazkhan.domain.visits;

public class MedicalTool {

    private int toolId;
    private String toolName;
    private String toolCost;

    public MedicalTool(){

    }

    private MedicalTool(MedicalToolBuilder builder){

        this.toolId = builder.toolId;
        this.toolName = builder.toolName;
        this.toolCost = builder.toolCost;


    }

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolCost() {
        return toolCost;
    }

    public void setToolCost(String toolCost) {
        this.toolCost = toolCost;
    }

    public static class MedicalToolBuilder{
        private int toolId;
        private String toolName;
        private String toolCost;

        public MedicalToolBuilder(){

        }

        public MedicalToolBuilder toolId(int toolId){
            this.toolId = toolId;
            return this;
        }

        public MedicalToolBuilder toolName(String toolName){
            this.toolName = toolName;
            return this;
        }

        public MedicalToolBuilder toolCost(String toolCost){
            this.toolCost = toolCost;
            return this;
        }


        public MedicalTool build(){

            return new MedicalTool();

        }

        @Override
        public String toString() {
            return "MedicalToolBuilder{" +
                    "toolId=" + toolId +
                    ", toolName='" + toolName + '\'' +
                    ", toolCost='" + toolCost + '\'' +
                    '}';
        }
    }

}
