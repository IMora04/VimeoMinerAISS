package aiss.vimeoMiner.parser;

import aiss.vimeoMiner.VMmodel.VMChannel;
import aiss.vimeoMiner.VMmodel.VMComment;
import aiss.vimeoMiner.VMmodel.VMUser;
import aiss.vimeoMiner.VMmodel.VMVideo;
import aiss.vimeoMiner.model.channel.Channel;
import aiss.vimeoMiner.model.comment.Comment;
import aiss.vimeoMiner.model.comment.User;
import aiss.vimeoMiner.model.video.Video;

import java.util.ArrayList;

public class Modelparser {

    public static VMChannel channelParser(Channel channel){
        VMChannel newChannel = new VMChannel();
        newChannel.setId(channel.getUri().substring(11));
        newChannel.setDescription(channel.getDescription());
        newChannel.setName(channel.getName());
        newChannel.setCreatedTime(channel.getCreatedTime());
        return newChannel;
    }

    public static VMVideo videoParser(Video video){
        VMVideo newVideo = new VMVideo();
        newVideo.setId(video.getUri().substring(8));
        newVideo.setName(video.getName());
        newVideo.setReleaseTime(video.getCreatedTime());
        newVideo.setDescription(video.getDescription());
        newVideo.setComments(new ArrayList<>());
        newVideo.setCaptions(new ArrayList<>());
        return newVideo;
    }

    public static VMComment commentParser(Comment comment){
        VMComment newComment = new VMComment();
        newComment.setId();
        newComment.setAuthor(parseUser(comment.getUser()));
        newComment.setText(comment.getText());
        newComment.setCreatedOn(comment.getCreatedOn());
        return newComment;
    }

    public static VMUser parseUser(User user){
        VMUser vmUser = new VMUser();
        vmUser.setId(user.getUri());
        vmUser.setName(user);
        vmUser.setUser_link();
        vmUser.setPicture_link();
    }



}
