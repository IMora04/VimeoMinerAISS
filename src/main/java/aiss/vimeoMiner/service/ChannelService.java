package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${vimeominer.token}")
    private String token;

    @Autowired
    RestTemplate restTemplate;

    public List<Channel> getChannels(){
        String uri = "https://api.vimeo.com/channels";
        HttpHeaders header = new HttpHeaders();
        System.out.println(token);
        header.set("Authorization", "Bearer " + token);

        HttpEntity<ChannelSearch> request = new HttpEntity<>(null, header);

        ResponseEntity<ChannelSearch> response = restTemplate.exchange(uri, HttpMethod.GET,
                request, ChannelSearch.class);

        return response.getBody().getData();
    }

    public Channel getChannel(String channelId) {
        String uri = "https://api.vimeo.com/channels/" + channelId;
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + token);

        HttpEntity<Channel> request = new HttpEntity<>(null, header);

        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.GET,
                request, Channel.class);

        return response.getBody();

    }
}
