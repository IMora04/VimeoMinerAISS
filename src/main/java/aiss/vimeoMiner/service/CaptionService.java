package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.captions.Captions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("captionService")
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;

    public Captions getCaptions(String videoId){
        String uri = "https://api.vimeo.com/videos/" + videoId; ;
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + "5394a30ebd1c27d98804ed901a30358a");

        HttpEntity<Captions> request = new HttpEntity<>(null, header);

        ResponseEntity<Captions> response = restTemplate.exchange(uri, HttpMethod.GET, request, Captions.class);

        return response.getBody();
    }


}
