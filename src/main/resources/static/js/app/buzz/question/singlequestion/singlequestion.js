// doit 试题描述 过多的话 会拉长表格 需要调整

$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "singlequestion/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                // questionType: $(".singlequestion-table-form").find("select[name='questionType']").val().trim(),
                // ssex: $(".singlequestion-table-form").find("select[name='ssex']").val(),
                // questionStatus: $(".singlequestion-table-form").find("select[name='questionStatus']").val()
            };
        },

        columns: [{checkbox: true},
            {field: 'questionId',visible: false},
            {field: 'subjectName',title: '所属科目'},
            {field: 'questionDesc',title: '题目'},
            {field: 'questionOptions',title: '选项'},
            {field: 'questionAnswer',title: '答案'},
            {field: 'questionScore',title: '分值'},
            {field: 'questionLabel',title: '标签'},
            {field: 'questionText',title: '文字解答'},
            {field: 'modifyTime',title: '修改时间',visible: false},
        ]
    }
    $MB.initTable('singlequestionTable', settings);
});

function search() {
    $MB.refreshTable('singlequestionTable');
}

function refresh() {
    $(".singlequestion-table-form")[0].reset();
    $MB.refreshTable('singlequestionTable');
}

function deletQuestions() {
    var selected = $("#singlequestionTable").bootstrapTable('getSelections');
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
        $.post(ctx + 'singlequestion/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
