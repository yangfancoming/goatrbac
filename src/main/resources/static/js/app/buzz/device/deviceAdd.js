var validator;
var $deviceAddForm = $("#device-add-form");

$(function() {
    validateRule();

    $("input[name='status']").change(function() {
        var checked = $(this).is(":checked");
        var $status_label = $("#status");
        if (checked) $status_label.html('可用');
        else $status_label.html('禁用');
    });

    $("#device-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $deviceAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "device/add", $deviceAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "device/update", $deviceAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#device-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#device-add-button").attr("name", "save");
    $MB.closeAndRestModal("device-add");
    validator.resetForm();
    $("#device-add-modal-title").html('新增字典');
}

function validateRule() {
    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
    validator = $deviceAddForm.validate({
        rules: {
            key: {
                required: true,
                digits: true,
                maxlength: 10,
            },
            value: {
                required: true,
                maxlength: 10,
            },
            tableName: {
                required: true,
                maxlength: 10,
            },
            fieldName: {
                required: true,
                maxlength: 10,
            }
        },
        messages: {
            key: {
                required: icon + "请输入键名",
                digits: icon + "请输入整数",
                maxlength: icon + "长度不能超过10个字符",
            },
            value: {
                required: icon + "请输入键值",
                maxlength: icon + "长度不能超过10个字符",
            },
            tableName: {
                required: icon + "请输入关联表名",
                maxlength: icon + "长度不能超过10个字符",
            },
            fieldName: {
                required: icon + "请输入字段名",
                maxlength: icon + "长度不能超过10个字符",
            }
        }
    });
}