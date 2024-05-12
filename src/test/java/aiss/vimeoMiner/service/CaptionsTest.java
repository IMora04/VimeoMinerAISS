package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.captions.Caption;
import aiss.vimeoMiner.model.captions.CaptionSearch;
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
        Caption caption = captionService.getCaptions("1905299", "945454931");
        System.out.println(caption);
    }

}
