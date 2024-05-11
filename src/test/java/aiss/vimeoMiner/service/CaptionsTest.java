package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.captions.Captions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
public class CaptionsTest {
    @Autowired
    @Qualifier("captionService")
    CaptionService captionService;

    @Test
    void getCaptions(){
        Captions captions = captionService.getCaptions("1234");
        System.out.println(captions);
    }

}
