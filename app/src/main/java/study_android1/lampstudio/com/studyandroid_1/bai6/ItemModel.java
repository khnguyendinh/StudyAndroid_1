package study_android1.lampstudio.com.studyandroid_1.bai6;

/**
 * Created by VS9 X64Bit on 20/04/2017.
 */

public class ItemModel {
    String name;
    int idimg;

    public ItemModel(String name, int img) {
        this.name = name;
        this.idimg = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return idimg;
    }

    public void setImg(int img) {
        this.idimg = img;
    }
}
