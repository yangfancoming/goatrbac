$(function() {

    // 页面加载的初始化请求
    var settings = {
        url: ctx + "device/list",
        pageSize: 10,
        queryParams: function(params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                deviceCode: $(".device-table-form").find("input[name='deviceCode']").val().trim(),
                ssex: $(".device-table-form").find("select[name='ssex']").val(),
                status: $(".device-table-form").find("select[name='status']").val()
            };
        },
        columns: [{checkbox: true},
            {field: 'deviceId',visible: false},
            {field: 'deviceName',title: '设备名称'},
            {field: 'deviceCode',title: '设备编码'},
            {field: 'ip',title: 'ip'},
            {field: 'prot',title: '端口'},
            {field: 'registerTime',title: '注册时间'},
            {field: 'createTime',title: '创建时间'},
            {
                field: 'status',title: '状态',
                formatter: function(value, row, index) {
                    if (value == '1') return '<span class="badge badge-success">有效</span>';
                    if (value == '0') return '<span class="badge badge-warning">锁定</span>';
                }
            }

        ]
    }
    $MB.initTable('deviceTable', settings);
});

function search() {
    $MB.refreshTable('deviceTable');
}

function refresh() {
    $(".device-table-form")[0].reset();
    $MB.refreshTable('deviceTable');
}

function deleteUsers() {
    var selected = $("#deviceTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    var contain = false;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].userId;
        if (i != (selected_length - 1)) ids += ",";
        if (userName == selected[i].username) contain = true;
    }
    if (contain) {
        $MB.n_warning('勾选用户中包含当前登录用户，无法删除！');
        return;
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function() {
        $.post(ctx + 'user/delete', { "ids": ids }, function(r) {
            if (r.code == 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function exportUserExcel(){
	$.post(ctx+"device/excel",$(".device-table-form").serialize(),function(r){
		if (r.code == 0) {
			window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
		} else {
			$MB.n_warning(r.msg);
		}
	});
}

function exportUserCsv(){
	$.post(ctx+"device/csv",$(".device-table-form").serialize(),function(r){
		if (r.code == 0) {
			window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
		} else {
			$MB.n_warning(r.msg);
		}
	});
}