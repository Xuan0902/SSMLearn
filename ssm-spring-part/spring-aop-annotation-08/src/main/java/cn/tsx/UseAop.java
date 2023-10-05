package cn.tsx;

import cn.tsx.dyn.ProxyFactory;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

public class UseAop {
    public static void main(String[] args) {
        /*
        静态代理
         */
        //创建目标对象
        Calculator calculator = new CalculatorPureImpl();
//        //创建代理对象
//        StaticProxyCalculator staticProxyCalculator = new StaticProxyCalculator(calculator);
//        int add = staticProxyCalculator.add(1, 1);
//        System.out.println("add = " + add);

        /*
        jdk动态代理
         */
        ProxyFactory proxyFactory = new ProxyFactory(calculator);
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,1);
    }
}
