package tcu.lxx.filemanage.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 对应的是数据库中“file”表，每个字段相对应。
 * 并且将联合查询出来的名字也显示出来方便显示。
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
    private String count;
    private String FileCode;
    private List<String> FileCodeList =new ArrayList<String>();

    public File(String type, String jidu, String xueyuan, String office, String zhuanye, String course, String banji,String FileCode) {
        this.type = type;
        this.jidu = jidu;
        this.xueyuan = xueyuan;
        this.office = office;
        this.zhuanye = zhuanye;
        this.course = course;
        this.banji = banji;
        this.FileCode=FileCode;

    }

    public File() {

    }

    public List getFileCodeList() {
        return FileCodeList;
    }

    public void setFileCodeList(List fileCodeList) {
        FileCodeList = fileCodeList;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFileCode() {
        return FileCode;
    }

    public void setFileCode(String fileCode) {
        FileCode = fileCode;
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

    @Override
    public String toString() {

        //得到当前的年份
        Calendar a = Calendar.getInstance();
        String year = String.valueOf(a.get(Calendar.YEAR));
        //得到条码
        String fileCode = year + "-" + type_id + "•" + xueyuan_id + "•" + jidu_id + "-" + office_id + course_id + banji_id;
        //赋给他,可以用filecode属性了
        setFileCode(fileCode);
        int num=Integer.valueOf(count);
        if(!"".equals(getCount())){
            for (int i = 1; i <=num ; i++) {
                String newFileCode = fileCode + "-" + i + "/" + count;
                FileCodeList.add(newFileCode);
            }
            return fileCode;
        }
        return fileCode;

    }
}
