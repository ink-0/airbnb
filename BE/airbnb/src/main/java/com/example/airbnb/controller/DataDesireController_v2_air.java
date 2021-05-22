package com.example.airbnb.controller;

//import com.example.airbnb.dto.InfoDTO;

import com.example.airbnb.domain.Accommodation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

@RequestMapping("/data")
@Controller
public class DataDesireController_v2_air {

    private static final Logger logger = LoggerFactory.getLogger(DataDesireController_v2_air.class);

    private static final String URL1 = "https://www.airbnb.co.kr/s/%EA%B0%95%EB%82%A8%EA%B5%AC--Seoul--South-Korea/homes?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&flexible_trip_dates%5B%5D=july&flexible_trip_dates%5B%5D=june&flexible_trip_lengths%5B%5D=weekend_trip&date_picker_type=calendar&query=%EA%B0%95%EB%82%A8%EA%B5%AC%2C%20Seoul%2C%20South%20Korea&place_id=ChIJ-4m1XyOkfDURartwxRuXMbM&checkin=2021-06-15&checkout=2021-06-18&adults=2&disable_auto_translation=false&source=structured_search_input_header&search_type=autocomplete_click";

    @ResponseBody
    @RequestMapping(value = "desire22.do", method = {RequestMethod.GET, RequestMethod.POST},
            produces = "text/plain;charset=UTF-8")
    public String desireData() {
        logger.info("desireData >> {}", new Date());
        Document doc;
        String gson = "";


        try {
            doc = Jsoup.connect("https://www.airbnb.co.kr/s/%EA%B0%95%EB%82%A8%EA%B5%AC--Seoul--South-Korea/homes?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&flexible_trip_dates%5B%5D=july&flexible_trip_dates%5B%5D=june&flexible_trip_lengths%5B%5D=weekend_trip&date_picker_type=calendar&query=%EA%B0%95%EB%82%A8%EA%B5%AC%2C%20Seoul%2C%20South%20Korea&place_id=ChIJ-4m1XyOkfDURartwxRuXMbM&checkin=2021-06-15&checkout=2021-06-18&adults=2&disable_auto_translation=false&source=structured_search_input_header&search_type=autocomplete_click")
                    .userAgent("Chrome/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
            ;
            /* Elements */
            Elements elem_itemListElement = doc.select("_8ssblpx");
            Elements elem_title = doc.select("itemProp=\"name\"");
            Elements elem_reviewRating = doc.select("");
            Elements elem_reviewCount = doc.select("");
            Elements elem_charge = doc.select("_155sga30");
            Elements elem_badge = doc.select("_17bkx6k");
            Elements elem_image = doc.select("_91slf2a");
            Elements elem_isLike = doc.select("");


            for (int i = 0; i < elem_itemListElement.size(); i++) {


                //Long id =
                String title = elem_title.get(i).text();
                Double reviewRating = 0.0;//elem_reviewRating.get(i).text();
                Integer reviewCount = 0;//elem_reviewCount.get(i).text();
                Integer charge = Integer.parseInt(elem_charge.get(i).text());
                String badge = elem_badge.get(i).text();
                String image = elem_image.get(i).attr("src");
                Boolean isLike = false; //elem_isLike.get(i).text();

                Accommodation dao = new Accommodation(title, reviewRating, reviewCount, charge, badge, image, isLike);
                //InfoDTO info = new InfoDTO(rank, img, movieAge, movieTitle, movieRate, movieOpenDate, like, seq);

                //logger.info(info.toString());
                //list.add(info);
            }
            //gson = new Gson().toJson(list);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return gson;
    }


}
