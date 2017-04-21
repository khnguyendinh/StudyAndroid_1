package study_android1.lampstudio.com.studyandroid_1.football;

/**
 * Created by VS9 X64Bit on 21/04/2017.
 */

public class Informatch {
    public enum STATUS{FT,AET};
    String fb1,fb2;
    int rs1,rs2;
    boolean co_keo,ykcg;
    STATUS status;

    public Informatch(String fb1, String fb2, int rs1, int rs2, boolean co_keo, boolean ykcg, STATUS status) {
        this.fb1 = fb1;
        this.fb2 = fb2;
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.co_keo = co_keo;
        this.ykcg = ykcg;
        this.status = status;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getFb1() {
        return fb1;
    }

    public void setFb1(String fb1) {
        this.fb1 = fb1;
    }

    public String getFb2() {
        return fb2;
    }

    public void setFb2(String fb2) {
        this.fb2 = fb2;
    }

    public int getRs1() {
        return rs1;
    }

    public void setRs1(int rs1) {
        this.rs1 = rs1;
    }

    public int getRs2() {
        return rs2;
    }

    public void setRs2(int rs2) {
        this.rs2 = rs2;
    }

    public boolean isCo_keo() {
        return co_keo;
    }

    public void setCo_keo(boolean co_keo) {
        this.co_keo = co_keo;
    }

    public boolean isYkcg() {
        return ykcg;
    }

    public void setYkcg(boolean ykcg) {
        this.ykcg = ykcg;
    }
}
