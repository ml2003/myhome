package smart.myhome.service;

import java.io.Serializable;

public class RequestResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final RequestResult OK = new RequestResult(true, "Ok");

    public static RequestResult ok() {
        return OK;
    }

    public static RequestResult ok(String msg) {
        return new RequestResult(true, msg);
    }

    public static RequestResult notImplemented() {
        return new RequestResult(false, "Функция не реализована");
    }

    public static RequestResult err(String msg) {
        return new RequestResult(false, msg);
    }

    private String requestId;
    private HandleStat stat;

    public RequestResult() {
    }

    public RequestResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    boolean success = true;

    String msg;
    public boolean isSuccess() {
        return success;
    }

    public boolean isErr() {
        return !success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public HandleStat getStat() {
        return stat;
    }

    public void setStat(HandleStat stat) {
        this.stat = stat;
    }

    public void add(RequestResult res) {
        if (res.isErr())
            success = false;
        if (res.stat != null) {
            if (stat == null)
                stat = res.stat;
            else
                stat.addStat(res.stat);
        }
        if (res.msg != null)
            if (msg == null)
                msg = res.msg;
            else
                msg += "\n" + res.msg;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                (requestId != null ? ", requestId='" + requestId + '\'' : "") +
                '}';
    }

}
