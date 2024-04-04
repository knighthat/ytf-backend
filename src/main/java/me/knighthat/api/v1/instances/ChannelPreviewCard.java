package me.knighthat.api.v1.instances;

import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.model.Channel;
import lombok.Getter;

import java.util.Date;


@Getter
public class ChannelPreviewCard extends PreviewCard {

    public static ChannelPreviewCard DUMMY = new ChannelPreviewCard( "0", "", new DateTime( new Date() ), "", "" );

    private final String title;
    private final String url;

    public ChannelPreviewCard(
            String id,
            String thumbNail,
            DateTime uploadDate,
            String title,
            String url
    ) {
        super( id, CardType.CHANNEL, thumbNail, uploadDate );
        this.title = title;
        this.url = url;
    }

    public ChannelPreviewCard( Channel channel ) {
        this(
                channel.getId(),
                channel.getSnippet().getThumbnails().getDefault().getUrl(),
                channel.getSnippet().getPublishedAt(),
                channel.getSnippet().getTitle(),
                channel.getSnippet().getCustomUrl()
        );
    }
}
