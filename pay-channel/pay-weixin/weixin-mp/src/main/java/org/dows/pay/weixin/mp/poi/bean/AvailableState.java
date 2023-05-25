package org.dows.pay.weixin.mp.poi.bean;

/**
 *
 */
public enum AvailableState {

    ERROR(1), APPROVING(2), APPROVED(3), REJECTED(4), UNKNOWN(-1);

    private final int code;

    AvailableState(int code) {
        this.code = code;
    }

    public static AvailableState fromCode(int code) {
        for (AvailableState state : AvailableState.values()) {
            if (state.code == code) {
                return state;
            }
        }
        return AvailableState.UNKNOWN;
    }

    public int getCode() {
        return this.code;
    }
}
