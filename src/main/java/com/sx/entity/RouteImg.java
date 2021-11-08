package com.sx.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tab_route_img")
public class RouteImg implements Serializable {

  @TableId(type = IdType.AUTO)
  private Integer rgid;
  private Integer rid;
  @TableField("bigPic")
  private String bigPic;
  @TableField("smallPic")
  private String smallPic;



}
