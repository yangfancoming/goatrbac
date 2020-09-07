
$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "classes/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
            };
        },
        columns: [{checkbox: true},
            {field: 'classesId',visible: false},
            {field: 'classesName',title: '班级名称'},
            {field: 'modifyTime',title: '修改时间',visible: false},
            {field: 'createTime',title: '创建时间'}
        ]
    }
    $MB.initTable('classesTable', settings);
});

function search() {
    $MB.refreshTable('classesTable');
}

function refresh() {
    $(".classes-table-form")[0].reset();
    $MB.refreshTable('classesTable');
}

function deletclassess() {
    var selected = $("#classesTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].classesId;
        if (i != (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function() {
        $.post(ctx + 'classes/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
