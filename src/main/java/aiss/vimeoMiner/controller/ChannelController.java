package aiss.vimeoMiner.controller;

import aiss.vimeoMiner.VMmodel.VMChannel;
import aiss.vimeoMiner.model.channel.Channel;
import aiss.vimeoMiner.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ChannelController {
    public VMChannel sentToVideoMiner(VMChannel newChannel){
    }
    @Autowired
    ChannelService channelService;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping
    public List<Channel> findAll(){
        return channelService.getChannels();
    }

    @GetMapping("/{id")
    public Channel findOne(@PathVariable String id){
        return channelService.getChannel(id);
    }

    //@ResponseStatus(HttpStatus.CREATED)
    //@PostMapping("/{id}")
    //public VMChannel uploadChannel(@PathVariable String id){
        //VMChannel newChannel = ModelParser.channelParser(findOne(id));
        //return sentToVideoMiner(newChannel);
    }
}
