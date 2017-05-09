package tcu.lxx.filemanage.entity;

import java.util.List;

public class Zhuanye {
    private String id;
    private String name;
    private List<Banji> sub;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Banji> getSub() {
        return sub;
    }

    public void setSub(List<Banji> sub) {
        this.sub = sub;
    }
}
