package cn.tsx.statics;

import cn.tsx.Calculator;

/**
 * author: Xuan
 * <p>
 * create: 2023-09-20
 **/

public class StaticProxyCalculator implements Calculator {
    private Calculator calculator;

    /*
    目标
     */
    public StaticProxyCalculator(Calculator target) {
        this.calculator = target;
    }

    /*
    静态代理
     */
    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.add(i, j);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
