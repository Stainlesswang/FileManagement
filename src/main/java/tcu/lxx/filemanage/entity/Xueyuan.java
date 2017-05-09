package tcu.lxx.filemanage.entity;

import java.util.List;

public class Xueyuan {

    private String id;
    private String name;
    private List<Zhuanye> sub;

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

    public List<Zhuanye> getSub() {
        return sub;
    }

    public void setSub(List<Zhuanye> sub) {
        this.sub = sub;
    }
}
