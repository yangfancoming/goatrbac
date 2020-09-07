
$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "student/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
            };
        },
        columns: [{checkbox: true},
            {field: 'studentId',visible: false},
            {field: 'studentName',title: '学生姓名'},
            {field: 'studentTel',title: '手机号码'},
            {field: 'studentCode',title: '学号'},
            {field: 'classesId',title: '所属班级'},
            {field: 'modifyTime',title: '修改时间',visible: false},
            {field: 'createTime',title: '创建时间'}
        ]
    }
    $MB.initTable('studentTable', settings);
});

function search() {
    $MB.refreshTable('studentTable');
}

function refresh() {
    $(".student-table-form")[0].reset();
    $MB.refreshTable('studentTable');
}

function deletstudents() {
    var selected = $("#studentTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].studentId;
        if (i != (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function() {
        $.post(ctx + 'student/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
