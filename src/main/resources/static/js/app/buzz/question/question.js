$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "question/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                questionType: $(".question-table-form").find("select[name='questionType']").val().trim(),
                ssex: $(".question-table-form").find("select[name='ssex']").val(),
                status: $(".question-table-form").find("select[name='status']").val()
            };
        },

        columns: [{checkbox: true},
            {field: 'questionId',visible: false},
            {field: 'questionType',title: '类型',
                formatter: function(value, row, index) {
                    if (value == '0') return '单选题';
                    if (value == '1') return '多选题';
                    if (value == '2') return '填空题';
                    if (value == '3') return '简答题';
                    else return '未知题型';
                }
             },
            {field: 'questionDesc',title: '题目'},
            {field: 'questionOptions',title: '选项'},
            {field: 'questionAnswer',title: '答案'},

            {field: 'questioScore',title: '分值'},
            {field: 'questionAudio',title: '音频解答'},
            {field: 'modifyTime',title: '修改时间'},
            {field: 'createTime',title: '创建时间'},
            {
                field: 'questionStatus',title: '状态',
                formatter: function(value, row, index) {
                    if (value == '1') return '<span class="badge badge-success">有效</span>';
                    if (value == '0') return '<span class="badge badge-warning">锁定</span>';
                }
            }

        ]
    }
    $MB.initTable('questionTable', settings);
});

function search() {
    $MB.refreshTable('questionTable');
}

function refresh() {
    $(".question-table-form")[0].reset();
    $MB.refreshTable('questionTable');
}

function deletQuestions() {
    var selected = $("#questionTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].questionId;
        if (i != (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function() {
        $.post(ctx + 'question/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
