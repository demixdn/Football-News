package com.github.footballdata.model;

import android.support.annotation.Nullable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Date: 25.01.2017
 * Time: 14:06
 *
 * @author Aleks Sander
 *         Project FootballNews
 */
@Root(name = "rss")
public class RssDTO {
    @Attribute(name = "xmlns:atom", required = false)
    private String type;

    @Attribute(name = "version", required = false)
    private float version;

    @Nullable
    @Element(name = "channel")
    private ChannelDTO channel;

    public RssDTO() {
    }

    public RssDTO(ChannelDTO channel) {
        this.channel = channel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    @Nullable
    public ChannelDTO getChannel() {
        return channel;
    }

    public void setChannel(ChannelDTO channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "RssDTO{" + channel.toString() + '}';
    }
}
