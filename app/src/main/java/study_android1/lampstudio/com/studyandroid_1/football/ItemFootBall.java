package study_android1.lampstudio.com.studyandroid_1.football;

/**
 * Created by VS9 X64Bit on 21/04/2017.
 */

public class ItemFootBall {
    public enum TYPE_FB {TITLE,MATCH};
    Informatch informatch;
    TYPE_FB type_fb;
    InforChampang inforChampang;

    public ItemFootBall(TYPE_FB type_fb,Informatch informatch, InforChampang inforChampang) {
        this.type_fb = type_fb;
        this.informatch = informatch;
        this.inforChampang = inforChampang;
    }

    public Informatch getInformatch() {
        return informatch;
    }

    public void setInformatch(Informatch informatch) {
        this.informatch = informatch;
    }

    public InforChampang getInforChampang() {
        return inforChampang;
    }

    public void setInforChampang(InforChampang inforChampang) {
        this.inforChampang = inforChampang;
    }
}
