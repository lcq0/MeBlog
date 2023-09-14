package com.quanxiaoha.weblog.common.eventbus;

/**
 * @author: lcq
 * @url: www.lingcq.online
 * @date: 2023-07-02 9:20
 * @description: TODO
 **/
public interface EventListener {
    void handleEvent(ArticleEvent weblogEvent);
}
