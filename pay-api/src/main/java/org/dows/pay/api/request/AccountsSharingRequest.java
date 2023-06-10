//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.dows.pay.api.request;

import com.github.binarywang.wxpay.v3.SpecEncrypt;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AccountsSharingRequest implements Serializable {
    private static final long serialVersionUID = -8662837652326828377L;
    @SerializedName("appid")
    private String appid;
    @SerializedName("sub_mchid")
    private String subMchid;
    @SerializedName("transaction_id")
    private String transactionId;
    @SerializedName("out_order_no")
    private String outOrderNo;
    @SerializedName("receivers")
    @SpecEncrypt
    private List<AccountsSharingRequest.Receiver> receivers;
    @SerializedName("finish")
    private Boolean finish;
    @SerializedName("unfreeze_unsplit")
    private Boolean unfreezeUnsplit;

    public String getAppid() {
        return this.appid;
    }

    public String getSubMchid() {
        return this.subMchid;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getOutOrderNo() {
        return this.outOrderNo;
    }

    public List<AccountsSharingRequest.Receiver> getReceivers() {
        return this.receivers;
    }

    public Boolean getFinish() {
        return this.finish;
    }

    public Boolean getUnfreezeUnsplit() {
        return this.unfreezeUnsplit;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setSubMchid(String subMchid) {
        this.subMchid = subMchid;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public void setReceivers(List<AccountsSharingRequest.Receiver> receivers) {
        this.receivers = receivers;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public void setUnfreezeUnsplit(Boolean unfreezeUnsplit) {
        this.unfreezeUnsplit = unfreezeUnsplit;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AccountsSharingRequest)) {
            return false;
        } else {
            AccountsSharingRequest other = (AccountsSharingRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$finish = this.getFinish();
                Object other$finish = other.getFinish();
                if (this$finish == null) {
                    if (other$finish != null) {
                        return false;
                    }
                } else if (!this$finish.equals(other$finish)) {
                    return false;
                }

                Object this$appid = this.getAppid();
                Object other$appid = other.getAppid();
                if (this$appid == null) {
                    if (other$appid != null) {
                        return false;
                    }
                } else if (!this$appid.equals(other$appid)) {
                    return false;
                }

                Object this$subMchid = this.getSubMchid();
                Object other$subMchid = other.getSubMchid();
                if (this$subMchid == null) {
                    if (other$subMchid != null) {
                        return false;
                    }
                } else if (!this$subMchid.equals(other$subMchid)) {
                    return false;
                }

                label62: {
                    Object this$transactionId = this.getTransactionId();
                    Object other$transactionId = other.getTransactionId();
                    if (this$transactionId == null) {
                        if (other$transactionId == null) {
                            break label62;
                        }
                    } else if (this$transactionId.equals(other$transactionId)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$outOrderNo = this.getOutOrderNo();
                    Object other$outOrderNo = other.getOutOrderNo();
                    if (this$outOrderNo == null) {
                        if (other$outOrderNo == null) {
                            break label55;
                        }
                    } else if (this$outOrderNo.equals(other$outOrderNo)) {
                        break label55;
                    }

                    return false;
                }

                Object this$receivers = this.getReceivers();
                Object other$receivers = other.getReceivers();
                if (this$receivers == null) {
                    if (other$receivers != null) {
                        return false;
                    }
                } else if (!this$receivers.equals(other$receivers)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof AccountsSharingRequest;
    }


    public String toString() {
        return "ProfitSharingRequest(appid=" + this.getAppid() + ", subMchid=" + this.getSubMchid() + ", transactionId=" + this.getTransactionId() + ", outOrderNo=" + this.getOutOrderNo() + ", receivers=" + this.getReceivers() + ", finish=" + this.getFinish() + ")";
    }

    public AccountsSharingRequest() {
    }

    public static class Receiver implements Serializable {
        private static final long serialVersionUID = 8995144356011793136L;
        @SerializedName("type")
        private String type;
        @SerializedName("account")
        private String account;
        @SerializedName("amount")
        private Integer amount;
        @SerializedName("description")
        private String description;
        @SerializedName("receiver_name")
        @SpecEncrypt
        private String receiverName;

        public String getType() {
            return this.type;
        }

        public String getReceiverAccount() {
            return this.account;
        }

        public Integer getAmount() {
            return this.amount;
        }

        public String getDescription() {
            return this.description;
        }

        public String getReceiverName() {
            return this.receiverName;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof AccountsSharingRequest.Receiver)) {
                return false;
            } else {
                AccountsSharingRequest.Receiver other = (AccountsSharingRequest.Receiver)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    label71: {
                        Object this$amount = this.getAmount();
                        Object other$amount = other.getAmount();
                        if (this$amount == null) {
                            if (other$amount == null) {
                                break label71;
                            }
                        } else if (this$amount.equals(other$amount)) {
                            break label71;
                        }

                        return false;
                    }

                    Object this$type = this.getType();
                    Object other$type = other.getType();
                    if (this$type == null) {
                        if (other$type != null) {
                            return false;
                        }
                    } else if (!this$type.equals(other$type)) {
                        return false;
                    }

                    label57: {
                        Object this$receiverAccount = this.getReceiverAccount();
                        Object other$receiverAccount = other.getReceiverAccount();
                        if (this$receiverAccount == null) {
                            if (other$receiverAccount == null) {
                                break label57;
                            }
                        } else if (this$receiverAccount.equals(other$receiverAccount)) {
                            break label57;
                        }

                        return false;
                    }

                    Object this$description = this.getDescription();
                    Object other$description = other.getDescription();
                    if (this$description == null) {
                        if (other$description != null) {
                            return false;
                        }
                    } else if (!this$description.equals(other$description)) {
                        return false;
                    }

                    Object this$receiverName = this.getReceiverName();
                    Object other$receiverName = other.getReceiverName();
                    if (this$receiverName == null) {
                        if (other$receiverName == null) {
                            return true;
                        }
                    } else if (this$receiverName.equals(other$receiverName)) {
                        return true;
                    }

                    return false;
                }
            }
        }

        protected boolean canEqual(Object other) {
            return other instanceof AccountsSharingRequest.Receiver;
        }


        public String toString() {
            return "ProfitSharingRequest.Receiver(type=" + this.getType() + ", receiverAccount=" + this.getReceiverAccount() + ", amount=" + this.getAmount() + ", description=" + this.getDescription() + ", receiverName=" + this.getReceiverName() + ")";
        }

        public Receiver() {
        }
    }
}
