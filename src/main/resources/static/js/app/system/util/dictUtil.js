
(function ($) {

    $.fn.getSubject = function (elId,tableName,fieldName) {
        // 清空原有select内的数据
        $("#" + elId + "").empty;
        // 添加下拉框 默认选项
        $("#" + elId + "").append("<option value='' selected>所有</option>");
        // 动态初始化 性别下拉框
        $.post(ctx + 'dict/ssex', {"tableName":tableName,"fieldName":fieldName}, function(r) {
            if (r.code == 0) {
                // var data = JSON.parse(r.msg);// sos 调试好久就是缺少了 这一句转换啊！！！  如果后台传回的不是json 则主要这样的转换
                $.each(r.msg, function (index, item) {
                    $("#" + elId + "").append("<option value='"+item.keyy+"'>"+item.value+"</option>");
                });
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        },'json');
    }
})(jQuery);


