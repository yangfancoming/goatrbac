var validator;
var $questionAddForm = $("#question-add-form");

$(function() {
    // validateRule();

    $("input[name='status']").change(function() {
        var checked = $(this).is(":checked");
        var $status_label = $("#status");
        if (checked) $status_label.html('可用');
        else $status_label.html('禁用');
    });

    $("#question-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $questionAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "question/add", $questionAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "question/update", $questionAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#question-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#question-add-button").attr("name", "save");
    $MB.closeAndRestModal("question-add");
    validator.resetForm();
    $("#question-add-modal-title").html('新增字典');
}
