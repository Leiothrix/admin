package com.paprika.modules.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author adam
 * @date 2019/5/13
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
@Data
@AllArgsConstructor
public class MenuMetaVo implements Serializable {

    private String title;

    private String icon;
}
