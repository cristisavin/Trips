package ro.scoalainformala.trips.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TRIP")
public class Trip {


    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "START_DATE")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "SPOT1_TITLE")
    private String spot1Title;

    @Column(name = "SPOT1_FILEPATH")
    private String spot1FilePath;

    @Column(name = "SPOT1_DESCRIPTION")
    private String spot1Description;

    @Column(name = "SPOT2_TITLE")
    private String spot2Title;

    @Column(name = "SPOT2_FILEPATH")
    private String spot2FilePath;

    @Column(name = "SPOT2_DESCRIPTION")
    private String spot2Description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpot1Title() {
        return spot1Title;
    }

    public void setSpot1Title(String spot1_title) {
        this.spot1Title = spot1_title;
    }

    public String getSpot1FilePath() {
        return spot1FilePath;
    }

    public void setSpot1FilePath(String spot1FilePath) {
        this.spot1FilePath = spot1FilePath;
    }

    public String getSpot1Description() {
        return spot1Description;
    }

    public void setSpot1Description(String spot1Description) {
        this.spot1Description = spot1Description;
    }

    public String getSpot2Title() {
        return spot2Title;
    }

    public void setSpot2Title(String spot2_title) {
        this.spot2Title = spot2_title;
    }

    public String getSpot2FilePath() {
        return spot2FilePath;
    }

    public void setSpot2FilePath(String spot2FilePath) {
        this.spot2FilePath = spot2FilePath;
    }

    public String getSpot2Description() {
        return spot2Description;
    }

    public void setSpot2Description(String spot2Description) {
        this.spot2Description = spot2Description;
    }
}
