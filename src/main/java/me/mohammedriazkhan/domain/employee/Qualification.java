package me.mohammedriazkhan.domain.employee;

public class Qualification {

    private int qualificationId;
    private String qualificationName;
    private String instituteName;
    private String duration;

    public Qualification(){

    }



    public Qualification(QualificationBuilder builder){

        this.qualificationId = builder.qualificationId;
        this.qualificationName = builder.qualificationName;
        this.instituteName = builder.instituteName;
        this.duration = builder.duration;

    }

    public int getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(int qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public static class QualificationBuilder {

        private int qualificationId;
        private String qualificationName;
        private String instituteName;
        private String duration;

        public QualificationBuilder(){

        }

        public QualificationBuilder qualificationId(int qualificationId){
            this.qualificationId = qualificationId;
            return this;
        }
        public QualificationBuilder qualificationName(String qualificationName){
            this.qualificationName = qualificationName;
            return this;
        }

        public QualificationBuilder instituteName(String instituteName){
            this.instituteName = instituteName;
            return this;
        }

        public QualificationBuilder duration(String duration){
            this.duration = duration;
            return this;
        }


        public Qualification build(){
            return new Qualification(this);
        }


        @Override
        public String toString() {
            return "QualificationBuilder{" +
                    "qualificationId=" + qualificationId +
                    ", qualificationName='" + qualificationName + '\'' +
                    ", instituteName='" + instituteName + '\'' +
                    ", duration='" + duration + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            QualificationBuilder that = (QualificationBuilder) o;

            if (qualificationId != that.qualificationId) return false;
            if (qualificationName != null ? !qualificationName.equals(that.qualificationName) : that.qualificationName != null)
                return false;
            if (instituteName != null ? !instituteName.equals(that.instituteName) : that.instituteName != null)
                return false;
            return duration != null ? duration.equals(that.duration) : that.duration == null;

        }

        @Override
        public int hashCode() {
            int result = qualificationId;
            result = 31 * result + (qualificationName != null ? qualificationName.hashCode() : 0);
            result = 31 * result + (instituteName != null ? instituteName.hashCode() : 0);
            result = 31 * result + (duration != null ? duration.hashCode() : 0);
            return result;
        }
    }

}
