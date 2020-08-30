
$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "combine/list",
        pageSize: 10,

        // 给组卷页面 添加选中添加试题，取消选中取消试题的触发事件
        onCheck:function(row){
            $MB.n_success($('#paperId').val());
        },

        onUncheck:function(row){
            $MB.n_success($('#paperId').val());
        },

        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                subjectId: $('#subjectId').val(),//  从隐藏域获取 试卷所属科目
                questionType: $(".combine-table-form").find("select[name='questionType']").val(), // 试题类型
            };
        },

        columns: [{checkbox: true},
            {field: 'combineId',visible: false},
            {field: 'subjectId',title: '所属科目',
                formatter: function(value, row, index) {
                    if (value == '0') return '英语';
                    if (value == '1') return '语文';
                    if (value == '2') return '数学';
                    else return '未知题型';
                }
             },
            {field: 'questionType',title: '试题类型'},
            {field: 'questionDesc',title: '试题描述'},
            {field: 'questionLabel',title: '试题标签'},

            {field: 'questionScore',title: '分值'},
            {field: 'modifyTime',title: '修改时间',visible: false},
            {field: 'createTime',title: '创建时间'},
        ]
    }
    $MB.initTable('combineTable', settings);
});

function search() {
    $MB.refreshTable('combineTable');
}

function refresh() {
    $(".combine-table-form")[0].reset();
    $MB.refreshTable('combineTable');
}

function deletcombines() {
    var selected = $("#combineTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].combineId;
        if (i != (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function() {
        $.post(ctx + 'combine/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
