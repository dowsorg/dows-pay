package org.dows.pay.weixin.mp.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


/**
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class LinkRequest extends XmlMessageHeader {

    @JsonProperty("Title")
    @JacksonXmlCData
    private String title;

    @JsonProperty("Description")
    @JacksonXmlCData
    private String desc;

    @JsonProperty("Url")
    @JacksonXmlCData
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
