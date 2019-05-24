package com.paprika.modules.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author adam
 * @date 2019/5/13
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuVo implements Serializable{
    private String name;

    private String path;

    private String redirect;

    private String component;

    private Boolean alwaysShow;

    private MenuMetaVo menuMetaVo;

    private List<MenuVo> children;
}
