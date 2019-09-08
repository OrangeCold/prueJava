package bean;

public enum Type {
    PICTURE(1,"图片"),VIDEO(2,"视频");

    private int code;
    private String name;

    private Type(int code,String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
