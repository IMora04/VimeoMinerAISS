package aiss.vimeoMiner.service;

import aiss.vimeoMiner.model.comment.Comment;
import aiss.vimeoMiner.model.video.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentListTests {


    @Autowired
    @Qualifier("commentService")
    CommentService commentService;

    @Test
    void getComments(){
        for(Comment c: commentService.getComments("1234")){
            System.out.println(c.getText());
        }
    }
    @Test
    void getCommentsOfVideo(){
        for(Comment c:commentService.getComments("1234",1)){
            System.out.println(c.getText());
        }
    }

}
