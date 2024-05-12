package aiss.vimeoMiner.service;


import aiss.vimeoMiner.model.channel.Channel;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test get channels")
    void getChannels() {
        for (Channel c : channelService.getChannels()) {
            System.out.println("Channel name: " + c.getName() + ". Description: " + c.getDescription());
        }
    }
    @Test
    @DisplayName("Test get channel given its Id")
    void getChannel(){
            Channel c = channelService.getChannel("1234");
            System.out.println("Channel name: " + c.getName() + ". Description: " + c.getDescription());

    }
}
