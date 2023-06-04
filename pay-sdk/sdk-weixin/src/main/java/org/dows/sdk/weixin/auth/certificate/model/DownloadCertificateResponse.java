package org.dows.sdk.weixin.auth.certificate.model;

import com.google.gson.annotations.SerializedName;
import org.dows.sdk.client.util.GsonUtil;

import java.util.List;

public class DownloadCertificateResponse {

    @SerializedName("data")
    List<Data> dataList;

    public List<Data> getData() {
        return dataList;
    }

    public void setData(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return GsonUtil.getGson().toJson(this);
    }
}
