package com.example.teamproject1.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String start;

    @Column
    private String enddate;

    @Column
    private String kind;

    @Column
    private int otherdate;


    public int getOtherdate() {
        String date1= getStart();
        String date2 = getEnddate();

        LocalDate changeDate1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate changeDate2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return Period.between(changeDate1,changeDate2).getDays();
    }



    @Column
    private String nameinfo;

    @Column
    private String image;

    @Column
    private String othermonth;

    public int getOthermonth() {

        String date1= getStart();
        String date2 = getEnddate();

        LocalDate changeDate1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate changeDate2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return Period.between(changeDate1,changeDate2).getMonths();
    }

@Column
private String plusdate;

//    public int getPlusdate() {
//
//    // Calendar start = Calendar.getInstance();
//        String date1 = getStart();
//        String date3 = getKind();
//
//        LocalDate changeDate1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate changeDate2 = LocalDate.parse(date3, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//
//        return Period.between(changeDate1,changeDate2).getMonths();
//    }

    //    public Long getOtherdate() throws ParseException {
//        java.util.Date wantDate=null;
//        SimpleDateFormat ddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat ddate2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//        try
//        {
//            Date firstDate = ddate.parse(getDate());
//            Date seconddate = ddate2.parse(getEnddate());
//            Long Sec = Long.valueOf((firstDate.compareTo(seconddate)));
//            otherdate = Sec/(24*60*60);
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//    return otherdate;
    }










    //    class DateTime{
//
//        private Comparable<String> date,enddate;
//
//        public void testcalcuate(String date, String enddate){
//            this.date=date;
//            this.enddate=enddate;
//            LocalDate localDate = LocalDate.now();
//            LocalDate past = LocalDate.of(date);
//
//        }
//
//    }



    // public data(Long id, String name, String date) {
    //    this.id = id;
    //    this.name = name;
     //   this.date = date;
    //}

   // @Override
   // public String toString() {
    //    return "data{" +
    //            "id=" + id +
     //           ", name='" + name + '\'' +
     //           ", date='" + date + '\'' +
     //           '}';
   // }

