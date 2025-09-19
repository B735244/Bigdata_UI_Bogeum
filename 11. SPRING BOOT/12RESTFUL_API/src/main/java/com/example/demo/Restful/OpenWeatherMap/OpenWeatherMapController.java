package com.example.demo.Restful.OpenWeatherMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/Open_Weather")
public class OpenWeatherMapController{
    private String appid ="1d118961923175df9646ff136af410a7";
    private String server="https://api.openweathermap.org/data/2.5/weather";

    @GetMapping("/{lat}/{lon}")
    public void get(@PathVariable("lat") String lat, @PathVariable("lon") String lon, Model model) throws Exception{

        log.info("GET /Open_Weather...");

        //1. 파라미터 설정(service key 포함)
        String url = UriComponentsBuilder.fromHttpUrl(server)
                .queryParam("appid", URLEncoder.encode(appid, StandardCharsets.UTF_8))
                .queryParam("lat",lat)
                .queryParam("lon",lon)
                .toUriString();

        System.out.println(url);
        // 요청 헤더, 바디 x
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response =restTemplate.exchange(url, HttpMethod.GET, null,Root.class);
        //System.out.println(response.getBody());


        //확인작업
        Root root = response.getBody();
        ObjectMapper mapper = new ObjectMapper(); // 객체를 구조화 해서 예브게 출력할 수 있음.
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String prettyJson = mapper.writeValueAsString(root);
        System.out.println(prettyJson);

    }
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
    @Data
    private static class Clouds{
        public int all;
    }
    @Data
    private static class Coord{
        public double lon;
        public double lat;
    }
    @Data
    private static class Main{
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public int pressure;
        public int humidity;
        public int sea_level;
        public int grnd_level;
    }
    @Data
    private static class Root{
        public Coord coord;
        public ArrayList<Weather> weather;
        public String base;
        public Main main;
        public int visibility;
        public Wind wind;
        public Clouds clouds;
        public int dt;
        public Sys sys;
        public int timezone;
        public int id;
        public String name;
        public int cod;
    }
    @Data
    private static class Sys{
        public int type;
        public int id;
        public String country;
        public int sunrise;
        public int sunset;
    }
    @Data
    private static class Weather{
        public int id;
        public String main;
        public String description;
        public String icon;
    }
    @Data
    private static class Wind{
        public double speed;
        public int deg;
    }



}
