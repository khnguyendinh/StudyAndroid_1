package study_android1.lampstudio.com.studyandroid_1.bai10;

import java.io.Serializable;

/**
 * Created by VS9 X64Bit on 22/04/2017.
 */

public class User implements Serializable{
    String user_name;
    int age;

    public User(String user_name, int age) {
        this.user_name = user_name;
        this.age = age;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
