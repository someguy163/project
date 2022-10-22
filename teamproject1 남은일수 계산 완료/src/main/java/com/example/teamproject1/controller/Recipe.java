package com.example.teamproject1.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import com.example.teamproject1.dto.DataForm;
import com.example.teamproject1.entity.Data;
import com.example.teamproject1.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

import java.util.List;
import java.util.SimpleTimeZone;

@Controller
@Slf4j
public class Recipe {

    @Autowired

    private DataRepository dataRepository;

    @GetMapping("/home")
    public String pagehome() {
        return "view/home";
    }
    @PostMapping("/view/create")
    public String homecreate(DataForm form, Model model){
        log.info(form.toString());

        //1.dto를 entity로 변환
        Data data = form.toEntity();
        log.info(data.toString());

        //2. entity를 repository에 저장.
        Data saved= dataRepository.save(data);
        log.info(saved.toString());


        log.info(data.toString());
        model.addAttribute("data",saved);
        //repository에 저장된 정보를 배열로 불러온다.
        List<Data> Datalist= dataRepository.findAll();

        //Datalist를 오름차순 정렬
        //Datalist를 내림차순 정렬하려면 Datalist.sort(Comparator.comparing(Data::getName).reversed()); 이다.
        Datalist.sort(Comparator.comparing(Data::getOtherdate));

        model.addAttribute("datalist",Datalist);
        return "view/refrigerator";

    }
        @GetMapping("/Data/{id}/edit")
        public String show(@PathVariable Long id, Model model){
        Data Alldata = dataRepository.findById(id).orElse(null);
        model.addAttribute("Alldata",Alldata);
        return "/view/edit";
}

    @GetMapping("/view/refrigerator")
    public String pagemypage(Model model){
        List<Data> Datalist= dataRepository.findAll();
        model.addAttribute("datalist",Datalist);
        Datalist.sort(Comparator.comparing(Data::getName));
        Datalist.sort(Comparator.comparing(Data::getEnddate));
        return "/view/refrigerator";
        }
    @GetMapping("/Community")
    public String pagelist(){
        return "view/Community";
    }

    @GetMapping("/Recipe")
    public String pagenewdelete(DataForm form, Model model){




        List<Data> Datalist= dataRepository.findAll();
        model.addAttribute("datalist",Datalist);
        Datalist.sort(Comparator.comparing(Data::getName));
        Datalist.sort(Comparator.comparing(Data::getEnddate));

        return "view/Recipe";
    }

}
