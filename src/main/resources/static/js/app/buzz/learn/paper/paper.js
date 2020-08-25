
$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "paper/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                questionType: $(".paper-table-form").find("select[name='questionType']").val().trim(),
                ssex: $(".paper-table-form").find("select[name='ssex']").val(),
                questionStatus: $(".paper-table-form").find("select[name='questionStatus']").val()
            };
        },

        columns: [{checkbox: true},
            {field: 'paperId',visible: false},
            {field: 'subjectId',title: '所属科目'},
            {field: 'paperName',title: '试卷名称'},
            {field: 'paperDesc',title: '试卷描述'},
            {field: 'paperScore',title: '试卷总分'},
            {field: 'modifyTime',title: '修改时间',visible: false},
            {field: 'createTime',title: '创建时间'},
            {
                field: 'paperStatus',title: '状态',
                formatter: function(value, row, index) {
                    if (value == '1') return '<span class="badge badge-success">有效</span>';
                    if (value == '0') return '<span class="badge badge-warning">锁定</span>';
                }
            },
            {
                title: '操作',
                formatter: function(value, row, index) {
                    return "<button href='#' onclick='offline(1)'>管理试题</button>";
                }
            }

        ]
    }
    $MB.initTable('paperTable', settings);
});

function offline(id) {
    // 点击左侧菜单后 显示右侧内容
    $.get(ctx + "combine/jump", {}, function(r) {
        $main_content.html("").append(r);
    });
    console.log(id,1111)
}


function search() {
    $MB.refreshTable('paperTable');
}

function refresh() {
    $(".paper-table-form")[0].reset();
    $MB.refreshTable('paperTable');
}

function deletQuestions() {
    var selected = $("#paperTable").bootstrapTable('getSelections');
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
        $.post(ctx + 'paper/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
