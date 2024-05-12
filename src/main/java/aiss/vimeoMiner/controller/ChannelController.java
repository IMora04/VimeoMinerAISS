package aiss.vimeoMiner.controller;

import aiss.vimeoMiner.VMmodel.VMChannel;
import aiss.vimeoMiner.model.channel.Channel;
import aiss.vimeoMiner.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;


import static aiss.vimeoMiner.parser.Modelparser.channelParser;

@RestController
@RequestMapping("/vimeominer/channels")
public class ChannelController {
    public VMChannel sentToVideoMiner(VMChannel newChannel){
        String uri = "https://localhost:8080/videominer/channels";
        HttpEntity<VMChannel> request = new HttpEntity<>(newChannel);
        ResponseEntity<VMChannel> response = restTemplate.exchange(uri, HttpMethod.POST, request, VMChannel.class);
        return response.getBody();
    }

    @Autowired
    ChannelService channelService;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public List<Channel> findAll() {
        return channelService.getChannels();
    }

    @GetMapping("/{id")
    public Channel findOne(@PathVariable String id){
        return channelService.getChannel(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public VMChannel uploadChannel(@PathVariable String id) {
        VMChannel newchannel = channelParser(findOne(id));
        return sentToVideoMiner(newchannel);
    }

}
