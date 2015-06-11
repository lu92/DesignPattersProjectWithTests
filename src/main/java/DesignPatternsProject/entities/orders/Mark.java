package DesignPatternsProject.entities.orders;

import DesignPatternsProject.entities.places.Venue;

import javax.persistence.*;

/**
 * Created by lucjan on 10.03.15.
 */

public class Mark {

    private Long mark_id;
    private int mark;
    private String opinion;



    private Venue venue;



    public Mark() {
    }

    public Mark(int mark, String opinion) {
        this.mark = mark;
        this.opinion = opinion;
    }

    public Mark(Long mark_id, int mark, String opinion) {
        this.mark_id = mark_id;
        this.mark = mark;
        this.opinion = opinion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (mark != mark1.mark) return false;
        if (!mark_id.equals(mark1.mark_id)) return false;
        if (!opinion.equals(mark1.opinion)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mark_id.hashCode();
        result = 31 * result + mark;
        result = 31 * result + opinion.hashCode();
        return result;
    }

    public Long getMark_id() {
        return mark_id;
    }

    public void setMark_id(Long mark_id) {
        this.mark_id = mark_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "mark_id=" + mark_id +
                ", mark=" + mark +
                ", opinion='" + opinion + '\'' +
                '}';
    }
}
