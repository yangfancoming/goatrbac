// doit 试题描述 过多的话 会拉长表格 需要调整

$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "fillquestion/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                // questionType: $(".fillquestion-table-form").find("select[name='questionType']").val().trim(),
                // ssex: $(".fillquestion-table-form").find("select[name='ssex']").val(),
                // questionStatus: $(".fillquestion-table-form").find("select[name='questionStatus']").val()
            };
        },

        columns: [{checkbox: true},
            {field: 'questionId',visible: false},
            {field: 'questionType',title: '类型',
                formatter: function(value, row, index) {
                    if (value == '3') return '填空题';
                    else return '未知题型';
                }
             },
            {field: 'questionDesc',title: '题目'},
            {field: 'subjectId',title: '所属科目'},
            {field: 'questionLabel',title: '标签'},
            {field: 'questionOptions',title: '选项'},
            {field: 'questionAnswer',title: '答案'},

            {field: 'questionScore',title: '分值'},
            {field: 'questionAudio',title: '音频解答'},
            {field: 'modifyTime',title: '修改时间',visible: false},
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
    $MB.initTable('fillquestionTable', settings);
});

function search() {
    $MB.refreshTable('fillquestionTable');
}

function refresh() {
    $(".fillquestion-table-form")[0].reset();
    $MB.refreshTable('fillquestionTable');
}

function deletQuestions() {
    var selected = $("#fillquestionTable").bootstrapTable('getSelections');
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
        $.post(ctx + 'fillquestion/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
