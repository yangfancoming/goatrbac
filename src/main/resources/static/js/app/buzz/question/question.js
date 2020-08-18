$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "question/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                questionCode: $(".question-table-form").find("input[name='questionCode']").val().trim(),
                ssex: $(".question-table-form").find("select[name='ssex']").val(),
                status: $(".question-table-form").find("select[name='status']").val()
            };
        },

        columns: [{checkbox: true},
            {field: 'questionId',visible: false},
            {field: 'questionType',title: '类型'},
            {field: 'questionStatus',title: '状态'},
            {field: 'questionAudio',title: '音频解答'},
            {field: 'questioScore',title: '分值'},
            {field: 'questionAnswer',title: '答案'},
            {field: 'questionDesc',title: '描述'},
            {field: 'questionOptions',title: '选项'},
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

