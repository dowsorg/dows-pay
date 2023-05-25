package org.dows.pay.weixin.mp.message.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;

/**
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MusicXmlMessage extends XmlMessageHeader {

    @JsonProperty("Music")
    private Music music;

    public MusicXmlMessage() {
        this.msgType = MsgType.music;
        this.setCreateTime(new Date());
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public MusicXmlMessage music(Music music) {
        this.music = music;
        return this;
    }
}