package aiss.vimeoMiner.controller;

import aiss.vimeoMiner.VMmodel.VMChannel;
import aiss.vimeoMiner.model.channel.Channel;
import aiss.vimeoMiner.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;


import static aiss.vimeoMiner.parser.ModelParser.channelParser;

@Tag(name = "Channel", description = "Channel management API")

@RestController
@RequestMapping("/vimeominer/channels")
public class ChannelController {

    public VMChannel sentToVideoMiner(VMChannel newChannel){
        String uri = "http://localhost:8080/videominer/channels";
        HttpEntity<VMChannel> request = new HttpEntity<>(newChannel);
        ResponseEntity<VMChannel> response = restTemplate.exchange(uri, HttpMethod.POST, request, VMChannel.class);
        return response.getBody();
    }

    @Autowired
    ChannelService channelService;
    @Autowired
    RestTemplate restTemplate;


    @Operation(
            summary = "Retrive a list of channels",
            description = "Get a list of channels",
            tags = {"channel", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of channels", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Channel not found", content = {@Content(schema = @Schema())})
    })
    @GetMapping
    public List<Channel> findAll() {
        return channelService.getChannels();
    }


    @Operation(
            summary = "Retrive a channel by id",
            description = "Get a channel object specifying its id",
            tags = {"channel", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/{id}")
    public Channel findOne(@Parameter(description = "id of the channel to be searched")@PathVariable String id){
        return channelService.getChannel(id);
    }


    @Operation(
            summary = "Upload a channel by ID to VideoMiner",
            description = "Retrieves a channel by its ID, parses it to a VMChannel format, and uploads it to VideoMiner.",
            tags = {"channel", "upload"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Channel uploaded successfully", content = {@Content(schema = @Schema(implementation = VMChannel.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public VMChannel uploadChannel(@PathVariable String id) {
        VMChannel newchannel = channelParser(findOne(id));
        return sentToVideoMiner(newchannel);
    }

}
