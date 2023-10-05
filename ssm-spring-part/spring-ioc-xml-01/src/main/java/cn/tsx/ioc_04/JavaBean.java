package cn.tsx.ioc_04;

public class JavaBean {
    /**
     * 初始化
     */
    public void init() {
        System.out.println("JavaBean.Init");
    }

    /**
     * 销毁
     */
    public void clear() {
        System.out.println("JavaBean.Clear");
    }
}
