package umc.spring.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

// http://localhost:8080/
@RestController
@RequestMapping("/get-api")
public class GetController {
    // http://localhost:8080/get-api/areas
    @GetMapping(value="/areas")
    public String getAreas(){
        return "안암동"+" "+"고잔동"+" "+"중앙동";
    }
    // http://localhost:8080/get-api/areas/{areaid}
    @GetMapping(value = "/areas/{areaid}")
    public String getAreaName(@PathVariable String areaid){
        return areaid;
    }
    // http://localhost:8080/get-api/users/{userid}/areas/{areaid}/missions-count?status=finish
    @GetMapping(value="/users/{userid}/areas/{areaid}/missions-count")
    public String getFinMyMission(@PathVariable String userid, @PathVariable String areaid,
                            @RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder();
        String count = "7";

        param.entrySet().forEach(map->{
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return areaid + " "+ count + "개"+" "+ sb.toString();
    }

}
