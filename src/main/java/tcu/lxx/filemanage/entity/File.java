package tcu.lxx.filemanage.entity;

/**
 * Created by stanwang on 2017/4/14.
 */
public class File {
    private int file_id;
    private String type_id;
    private String jidu_id;
    private String xueyuan_id;
    private String office_id;
    private String zhuanye_id;
    private String course_id;
    private String banji_id;
    private String type;
    private String jidu;
    private String xueyuan;
    private String office;
    private String zhuanye;
    private String course;
    private String banji;
    public File(String type, String jidu, String xueyuan, String office, String zhuanye, String course, String banji)
    {
        this.type=type;
        this.jidu=jidu;
        this.xueyuan=xueyuan ;
        this.office=office;
        this.zhuanye=zhuanye;
        this.course=course;
        this.banji=banji;

    }
    public File(){

    }
    public String getXueyuan_id() {
        return xueyuan_id;
    }

    public void setXueyuan_id(String xueyuan_id) {
        this.xueyuan_id = xueyuan_id;
    }

    public String getOffice_id() {
        return office_id;
    }

    public void setOffice_id(String office_id) {
        this.office_id = office_id;
    }

    public String getZhuanye_id() {
        return zhuanye_id;
    }

    public void setZhuanye_id(String zhuanye_id) {
        this.zhuanye_id = zhuanye_id;
    }

    public String getBanji_id() {
        return banji_id;
    }

    public void setBanji_id(String banji_id) {
        this.banji_id = banji_id;
    }
    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getJidu_id() {
        return jidu_id;
    }

    public void setJidu_id(String jidu_id) {
        this.jidu_id = jidu_id;
    }


    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJidu() {
        return jidu;
    }

    public void setJidu(String jidu) {
        this.jidu = jidu;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }
}
