var validator;
var $combineAddForm = $("#combine-add-form");

$(function() {
    // validateRule();

    $("input[name='status']").change(function() {
        var checked = $(this).is(":checked");
        var $status_label = $("#status");
        if (checked) $status_label.html('可用');
        else $status_label.html('禁用');
    });

    $("#combine-add .btn-save").click(function() {
        var name = $(this).attr("name");
        validator = $combineAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name == "save") {
                $.post(ctx + "combine/add", $combineAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name == "update") {
                $.post(ctx + "combine/update", $combineAddForm.serialize(), function(r) {
                    if (r.code == 0) {
                        closeModal();
                        refresh();
                        $MB.n_success(r.msg);
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#combine-add .btn-close").click(function() {
        closeModal();
    });

});

function closeModal() {
	$("#combine-add-button").attr("name", "save");
    $MB.closeAndRestModal("combine-add");
    validator.resetForm();
    $("#combine-add-modal-title").html('新增字典');
}
