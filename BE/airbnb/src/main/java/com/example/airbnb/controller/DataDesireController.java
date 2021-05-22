package com.example.airbnb.controller;

import com.example.airbnb.dto.InfoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.google.gson.Gson;

@RequestMapping("/data")
@Controller
public class DataDesireController {

    private static final Logger logger = LoggerFactory.getLogger(DataDesireController.class);

    private static final String URL1 = "https://www.airbnb.co.kr/s/%EA%B0%95%EB%82%A8%EA%B5%AC--Seoul--South-Korea/homes?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&flexible_trip_dates%5B%5D=july&flexible_trip_dates%5B%5D=june&flexible_trip_lengths%5B%5D=weekend_trip&date_picker_type=calendar&query=%EA%B0%95%EB%82%A8%EA%B5%AC%2C%20Seoul%2C%20South%20Korea&place_id=ChIJ-4m1XyOkfDURartwxRuXMbM&checkin=2021-06-15&checkout=2021-06-18&adults=2&disable_auto_translation=false&source=structured_search_input_header&search_type=autocomplete_click";
    private static final String URL2 = "http://www.cgv.co.kr/movies/";

    @ResponseBody
    @RequestMapping(value = "desire.do", method = {RequestMethod.GET, RequestMethod.POST},
    produces = "text/plain;charset=UTF-8")
    public String desireData() {
        logger.info("desireData >> {}",new Date());
        Document doc;
        String gson = "";

        try{
            doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
            /* Elements */
            Elements ranks = doc.select(".rank");
            /* logger.info("rank" + ranks); */

            Elements imgs = doc.select(".thumb-image > img");
            /* logger.info("imgs" + imgs); */

            Elements movieAges = doc.select(".ico-grade");
            /* logger.info("ico-grade" + movieAges); */

            Elements movieTitles = doc.select("div.box-contents strong.title");
            /* logger.info("titles" + movieTitles); */

            Elements movieRates = doc.select(".percent span");
            /* logger.info("percents" + movieRates); */


            Elements movieOpenDates = doc.select(".txt-info strong");
            /* logger.info("percents" + movieOpenDates); */

            Elements likes = doc.select(".count strong>i");
            /* logger.info("counts" + likes); */
            List<InfoDTO> list = new ArrayList<InfoDTO>();

            for(int i = 0; i < ranks.size(); i++) {

                String rank = ranks.get(i).text();
                String img = imgs.get(i).attr("src");
                String movieAge = movieAges.get(i).text();
                String movieTitle = movieTitles.get(i).text();
                String movieRate = movieRates.get(i).text();
                String movieOpenDate = movieOpenDates.get(i).text();
                String like = "";// = likes.get(i).text();
                Integer seq = i;
                InfoDTO info = new InfoDTO(rank, img, movieAge, movieTitle, movieRate, movieOpenDate, like, seq);

                logger.info(info.toString());
                list.add(info);
            }
            gson = new Gson().toJson(list);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return gson;
    }


}
