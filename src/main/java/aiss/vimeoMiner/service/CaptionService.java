package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.captions.CaptionList;
import aiss.vimeoMiner.model.captions.Captions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("captionService")
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;

    public List<Captions> getCaptions(){
        String uri = "https://api.vimeo.com/captions/";
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + );

        HttpEntity<CaptionList> request = new HttpEntity<>(null, header);

        ResponseEntity<CaptionList> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionList.class);

        return response.getBody().getData();
    }

    public List<Captions> getCaptions(String captionId){
        return getCaptions();
    }

}
