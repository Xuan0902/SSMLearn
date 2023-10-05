package cn.tsx.pojo;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-23
 **/

public class Teacher {
    private String tId;
    private String tName;

    public Teacher() {
    }

    public Teacher(String tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    /**
     * 获取
     * @return tId
     */
    public String getTId() {
        return tId;
    }

    /**
     * 设置
     * @param tId
     */
    public void setTId(String tId) {
        this.tId = tId;
    }

    /**
     * 获取
     * @return tName
     */
    public String getTName() {
        return tName;
    }

    /**
     * 设置
     * @param tName
     */
    public void setTName(String tName) {
        this.tName = tName;
    }

    public String toString() {
        return "Teacher{tId = " + tId + ", tName = " + tName + "}";
    }
}
