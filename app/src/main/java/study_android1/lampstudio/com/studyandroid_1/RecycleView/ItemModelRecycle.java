package study_android1.lampstudio.com.studyandroid_1.RecycleView;

/**
 * Created by VS9 X64Bit on 23/04/2017.
 */

public class ItemModelRecycle {
    String name;
    int id_img;

    public ItemModelRecycle(String name, int id_img) {
        this.name = name;
        this.id_img = id_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }
}
