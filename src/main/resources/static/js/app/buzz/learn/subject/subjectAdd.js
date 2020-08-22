var validator;
var $subjectAddForm = $("#subject-add-form");

$(function() {
    // validateRule();

    // 点击保存按钮
    $("#subject-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $subjectAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "subject/add", $subjectAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "subject/update", $subjectAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    // 点击关闭按钮
    $("#subject-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#subject-add-button").attr("name", "save");
    $MB.closeAndRestModal("subject-add");
    // validator.resetForm(); // doit  这里放开后 为啥报错？？？
    $("#subject-add-modal-title").html('新增科目');
}
