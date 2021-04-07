package com.learn.mybatisplus.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "my_user")
//@KeySequence
public class MyUser /*ActiveRecord模式*/ extends Model<MyUser> implements Serializable {
    @TableId(value = "my_id" ,type = IdType.ASSIGN_ID)
    private Long myId;
    @TableField(value = "my_name")
    private String myName;

    @TableField(value = "my_age")
    private Integer myAge;

    @TableField(value = "my_email")
    private String myEmail;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "deleted",fill = FieldFill.INSERT)
    @TableLogic
    private Boolean deleted;
}
