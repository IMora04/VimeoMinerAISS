package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.captions.Caption;
import aiss.vimeoMiner.model.captions.CaptionSearch;
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

    public Caption getCaptions(String channelId, String videoId){
        String uri = "https://api.vimeo.com/channels/" + channelId + "/videos/" + videoId + "/texttracks";
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + "5394a30ebd1c27d98804ed901a30358a");

        HttpEntity<Caption> request = new HttpEntity<>(null, header);

        ResponseEntity<Caption> response = restTemplate.exchange(uri, HttpMethod.GET, request, Caption.class);

        return response.getBody();
    }


}
