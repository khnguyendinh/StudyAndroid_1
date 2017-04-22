package study_android1.lampstudio.com.studyandroid_1.bai8;

/**
 * Created by VS9 X64Bit on 22/04/2017.
 */

public class ItemModelBai8 {
    String id;
    String word;
    String description;

    public ItemModelBai8(String id, String word, String description) {
        this.id = id;
        this.word = word;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
