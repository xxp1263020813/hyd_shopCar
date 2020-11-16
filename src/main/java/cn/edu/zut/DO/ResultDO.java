package cn.edu.zut.DO;

public class ResultDO<E> {
    private String info;
    private boolean status ;//结果状态，true正常，false不正常
    private E result;//返回的结果对象

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public E getResult() {
        return result;
    }

    public void setResult(E result) {
        this.result = result;
    }
}
