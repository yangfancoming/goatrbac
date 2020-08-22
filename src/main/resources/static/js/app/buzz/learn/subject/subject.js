// doit 试题描述 过多的话 会拉长表格 需要调整

$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "subject/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
            };
        },
        columns: [{checkbox: true},
            {field: 'subjectId',visible: false},
            {field: 'subjectName',title: '科目名称'},
            {field: 'modifyTime',title: '修改时间',visible: false},
            {field: 'createTime',title: '创建时间'}
        ]
    }
    $MB.initTable('subjectTable', settings);
});

function search() {
    $MB.refreshTable('subjectTable');
}

function refresh() {
    $(".subject-table-form")[0].reset();
    $MB.refreshTable('subjectTable');
}

function deletsubjects() {
    var selected = $("#subjectTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].subjectId;
        if (i != (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function() {
        $.post(ctx + 'subject/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
