package aiss.vimeoMiner.parser;

import aiss.vimeoMiner.VMmodel.*;
import aiss.vimeoMiner.model.captions.Caption;
import aiss.vimeoMiner.model.channel.Channel;
import aiss.vimeoMiner.model.comment.Comment;
import aiss.vimeoMiner.model.comment.User;
import aiss.vimeoMiner.model.video.Video;

public class ModelParser {

    public static VMChannel channelParser(Channel channel){
        VMChannel newChannel = new VMChannel();
        newChannel.setId(channel.getUri().substring(channel.getUri().lastIndexOf('/') + 1));
        newChannel.setDescription(channel.getDescription());
        newChannel.setName(channel.getName());
        newChannel.setCreatedTime(channel.getCreatedTime());
        return newChannel;
    }

    public static VMVideo videoParser(Video video){
        VMVideo newVideo = new VMVideo();
        newVideo.setId(video.getUri().substring(video.getUri().lastIndexOf('/') + 1));
        newVideo.setName(video.getName());
        newVideo.setReleaseTime(video.getCreatedTime());
        newVideo.setDescription(video.getDescription());
        newVideo.setComments(video.getComments().stream().map(ModelParser::commentParser).toList());
        newVideo.setCaptions(video.getCaptions().stream().map(ModelParser::captionParser).toList());
        return newVideo;
    }

    private static VMCaption captionParser(Caption caption) {
        VMCaption newCaption = new VMCaption();
        newCaption.setId(caption.getId().toString());
        newCaption.setName(caption.getName());
        newCaption.setLanguage(caption.getLanguage());
        return newCaption;
    }

    public static VMComment commentParser(Comment comment){
        VMComment newComment = new VMComment();
        newComment.setId(comment.getUri().substring(comment.getUri().lastIndexOf('/') + 1));
        newComment.setAuthor(userParser(comment.getUser()));
        newComment.setText(comment.getText());
        newComment.setCreatedOn(comment.getCreatedOn());
        return newComment;
    }

    public static VMUser userParser(User user){
        VMUser newUser = new VMUser();
        newUser.setId(Long.valueOf(user.getUri().substring(user.getUri().lastIndexOf('/') + 1)));
        newUser.setName(user.getName());
        newUser.setUser_link(user.getLink());
        newUser.setPicture_link(user.getPictures().getBaseLink());
        return newUser;
    }

}
