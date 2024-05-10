package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import aiss.vimeoMiner.model.channel.Channel;
import java.util.List;

@Service("channelService")
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;

    public List<Channel> getChannels(){
        String uri = "https://api.vimeo.com/channels";
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + "5394a30ebd1c27d98804ed901a30358a");

        HttpEntity<ChannelSearch> request = new HttpEntity<>(null, header);

        ResponseEntity<ChannelSearch> response = restTemplate.exchange(uri, HttpMethod.GET,
                request, ChannelSearch.class);

        return response.getBody().getData();
    }



}
