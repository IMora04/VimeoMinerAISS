package aiss.vimeoMiner.service;


import aiss.vimeoMiner.model.channel.Channel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChannelsTest {
    @Autowired
    @Qualifier("channelService")
    ChannelService channelService;

    @Test
    void getChannels() {
        for (Channel c : channelService.getChannels()) {
            System.out.println(c.getName());
        }
    }
    @Test
    void getChannel(){
            Channel channel = channelService.getChannel("1234");
            System.out.println(channel.getName());

    }
}
