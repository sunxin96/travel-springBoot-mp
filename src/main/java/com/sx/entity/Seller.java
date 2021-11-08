package com.sx.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tab_seller")
public class Seller implements Serializable {

  @TableId(type = IdType.AUTO)
  private Long sid;
  private String sname;
  private String consphone;
  private String address;

  public Seller(Long sid, String sname, String consphone, String address) {
    this.sid = sid;
    this.sname = sname;
    this.consphone = consphone;
    this.address = address;
  }

  public Seller() {
  }
}
