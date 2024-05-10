package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.captions.Captions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CaptionsTest {
    @Autowired
    @Qualifier("CaptionService")
    CaptionService captionService;

    void getCaptions(){
        for(Captions c:captionService.getCaptions()){
            System.out.println(c.getData());
        }
    }

}
