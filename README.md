
# 待优化

    部门管理 编辑 复选框多级回显 前端有问题 可以参考用户分配角色回显
    
    数据权限控制


# bootstrap-table 后台返回数据正确，前台却不显示

    有时表格会出现不显示数据的问题：
    
    这时就要看 分页的配置了：
    
    从源码中进行分析： （定位串：  var bootstrapTable_default = { ）
    
    如果 设置 sidePagination: "server", 则 通过 url 或者 data 返回的数据 就 应当是 类似于：
    {total:2,rows:[{'typeId':1,'typeCode':'haha1','typeDesc':'haha1'},{'typeId':1,'typeCode':'haha2','typeDesc':'haha2'}]}
    必须包含 total 和 rows;
    
    如果 设置 sidePagination: "client", 就不必了。




# https
    访问地址 
    https://www.goatcoming.cn/login


# todo 
    发布阿里云后   nignx 把https转发到项目后  一直重定向的问题 





























 