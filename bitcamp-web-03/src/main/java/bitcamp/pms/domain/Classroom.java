package bitcamp.pms.domain;

import java.util.Date;

public class Classroom {
    protected int crno;//번호
    protected String title;//수업명
    protected Date startDate;//시작일
    protected Date endDate;//종료일
    protected String room;//교실
    public int getCrno() {
        return crno;
    }
    public void setCrno(int crno) {
        this.crno = crno;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    @Override
    public String toString() {
        return "Classroom [crno=" + crno + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
                + ", room=" + room + "]";
    }
    
   
}
