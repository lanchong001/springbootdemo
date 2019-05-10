package com.lym.springboot.starter.service;

/**
 * @Author: in liuyuanming
 * @Description: 增加前缀和后缀服务
 * @Date:Created in  2019/5/10 15:04
 */
public class ExampleService {

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 后缀
     */
    private String suffix;

    /**
     * 构造函数
     * @param prefix 前缀
     * @param suffix 后缀
     */
    public ExampleService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * 给某个单词增加前缀和后缀
     * @param word 单词
     * @return 增加前缀和后缀后的结果
     */
    public String wrap(String word) {
        return prefix + word + suffix;
    }

}
