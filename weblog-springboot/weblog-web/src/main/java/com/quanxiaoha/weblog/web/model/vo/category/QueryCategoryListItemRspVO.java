package com.quanxiaoha.weblog.web.model.vo.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lcq
 * @url: www.lingcq.online
 * @date: 2023-04-19 16:06
 * @description: TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryCategoryListItemRspVO {
    private Long id;
    private String name;
}
