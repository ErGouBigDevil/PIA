function getPath() {
    var curPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curPath.indexOf(pathName);
    var localhostPath = curPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    // console.log(pathName)
    // console.log(pathName.substr(1))
    // console.log(projectName)
    return localhostPath + projectName;
}


$(document).ready(function () {
    initTable();
});


// 加载表格
function initTable() {
    $('#table').bootstrapTable('destroy');
    $("#table").bootstrapTable({
        method: "get",
        url: getPath() + "/todo/getAllInfo",
        pagination: true, //启动分页
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 25, 50, 100], //记录数可选列表
        search: false,  //是否启用查询
        showColumns: true,  //显示下拉框勾选要显示的列
        sidePagination: "server", //表示服务端请求
        queryParamsType: "limit",
        clickToSelect: true,
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                search: params.search,
                sort: params.sort,
                order: params.order,
            };
            return param;
        },
        onLoadSuccess: function () {  //加载成功时执行
            $('#mResult').addClass('alert-success');
            $('#mResult').html("加载成功!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-success');
                $('#mResult').html('');
            }, 5000);
        },
        onLoadError: function () {  //加载失败时执行
            $('#mResult').addClass('alert-danger');
            $('#mResult').html("由于服务器的原因,加载失败!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-danger');
                $('#mResult').html('');
            }, 2000);
        },
    });
}


// 刷新表格
$('#refreshBtn').click(function () {
    initTable();
});

// 添加信息
$('#insertSave').click(function () {
    var insertTitle = $('#insertTitle').val();
    var insertDeadline = $('#insertDeadline').val();
    console.log(insertDeadline + ":00");
    var insertSite = $('#insertSite').val();
    var insertNote = $('#insertNote').val();
    if (insertDeadline == "")
        insertDeadline = new Date().pattern("yyyy/MM/dd hh:mm:ss");
    else
        insertDeadline += ":00";

    $.ajax({
        type: "post",
        url: getPath() + "/todo/insertData",
        async: false,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            "toDoId": 0,
            "userId": 0,
            "title": insertTitle,
            "deadline": insertDeadline,
            "site": insertSite,
            "note": insertNote
        }),
        success: function (data) {
            if (data.flag) {
                $('#insertModal').modal("hide");
                $('#insertTitle').val('');
                $('#insertDeadline').val('');
                $('#insertSite').val('');
                $('#insertNote').val('');
                bootbox.alert({
                    centerVertical: true,
                    title: "成功",
                    message: "添加成功!",
                    locale: "zh_CN"
                })
                initTable();
            } else {
                bootbox.alert({
                    centerVertical: true,
                    title: "失败",
                    message: "添加失败!",
                    locale: "zh_CN"
                })
                initTable();
            }

        },
        error: function () {
            $('#mResult').addClass('alert-danger');
            $('#mResult').html("由于服务器原因，添加失败!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-danger');
                $('#mResult').html('');
            }, 2000);
        }
    })

});


// 删除信息
$('#removeBtn').click(function () {
    var rows = $('#table').bootstrapTable('getSelections');
    if (rows.length == 0) {
        bootbox.alert({
            centerVertical: true,
            title: "错误",
            message: "删除操作至少需要选择一条数据!",
            locale: "zh_CN"
        });

    } else {
        var ids = '';
        $.each(rows, function () {
            ids += this.toDoId + ",";
        });
        ids = ids.substring(0, ids.length - 1);

        bootbox.confirm({
            centerVertical: true,
            title: "删除确认",
            message: "确认删除所选?",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Cancel'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function (result) {
                if (result) {
                    $.ajax({
                        type: 'POST',
                        url: getPath() + "/todo/deleteByIds",
                        data: {ids: ids},
                        dataType: "json",
                        success: function (data) {
                            if (data.flag) {
                                bootbox.alert({
                                    centerVertical: true,
                                    title: "成功",
                                    message: "删除成功!",
                                    locale: "zh_CN"
                                });
                                initTable();
                            } else {
                                bootbox.alert({
                                    centerVertical: true,
                                    title: "失败",
                                    message: "删除失败!",
                                    locale: "zh_CN"
                                });
                                initTable();
                            }
                        },
                        error: function (data) {
                            $('#mResult').addClass('alert-danger');
                            $('#mResult').html("由于服务器原因，删除失败!");
                            setTimeout(function () {
                                $('#mResult').removeClass('alert-danger');
                                $('#mResult').html('');
                            }, 2000);
                        },
                    });
                }
            }
        });
    }
});

// 更新信息
$('#updateBtn').click(function () {
    var rows = $('#table').bootstrapTable('getSelections');
    if (rows.length != 1) {
        bootbox.alert({
            centerVertical: true,
            title: "错误",
            message: "修改操作只能选择一条数据！",
            locale: "zh_CN"
        });
    } else {
        $('#updateTitle').val(rows[0].title);
        $('#updateNote').val(rows[0].note);
        $('#updateDeadline').val(rows[0].deadline);
        $('#updateSite').val(rows[0].site);
        $('#updateModal').modal("toggle");
    }
});

$('#updateSave').click(function () {
    var rows = $('#table').bootstrapTable('getSelections');
    var updateId = rows[0].toDoId;
    var updateTitle = $('#updateTitle').val();
    var updateDeadline = $('#updateDeadline').val();
    var updateSite = $('#updateSite').val();
    var updateNote = $('#updateNote').val();
    if (updateDeadline == "")
        updateDeadline = new Date().pattern("yyyy/MM/dd hh:mm:ss");
    else
        updateDeadline = updateDeadline.replace(/-/g, "/");


    $.ajax({
        type: "post",
        url: getPath() + "/todo/updateData",
        async: false,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            "toDoId": updateId,
            "userId": 0,
            "title": updateTitle,
            "deadline": updateDeadline,
            "site": updateSite,
            "note": updateNote
        }),
        success: function (data) {
            if (data.flag) {
                $('#updateModal').modal("hide");
                $('#updateTitle').val('');
                $('#updateDeadline').val('');
                $('#updateSite').val('');
                $('#updateNote').val('');
                bootbox.alert({
                    centerVertical: true,
                    title: "成功",
                    message: "修改成功!",
                    locale: "zh_CN"
                })
                initTable();
            } else {
                bootbox.alert({
                    centerVertical: true,
                    title: "失败",
                    message: "修改失败!",
                    locale: "zh_CN"
                });
                initTable();
            }

        },
        error: function () {
            $('#updateModal').modal("hide");
            $('#updateTitle').val('');
            $('#updateDeadline').val('');
            $('#updateSite').val('');
            $('#updateNote').val('');
            $('#mResult').addClass('alert-danger');
            $('#mResult').html("由于服务器原因，添加失败!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-danger');
                $('#mResult').html('');
            }, 200);
        }
    })
});


// 日期搜索
$('#findByDateBtn').click(function () {
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    $.ajax({
        type: "post",
        url: getPath() + "/todo/findByDate",
        async: false,
        dataType: 'json',
        data: {startDate: startDate + ":00", endDate: endDate + ":00"},
        success: function (data) {
            console.log(data);
            if (data.total != 0) {
                $('#findByDateModal').modal("hide");
                $("#startDate").val("");
                $("#endDate").val("");
                $('#table').bootstrapTable('destroy');
                $('#table').bootstrapTable();
                $('#table').bootstrapTable('load', data);
            } else {
                $('#findByDateModal').modal("hide");
                $("#startDate").val("");
                $("#endDate").val("");
                bootbox.alert({
                    centerVertical: true,
                    title: "失败",
                    message: "搜索失败!",
                    locale: "zh_CN"
                })
                initTable();
            }

        },
        error: function () {
            $('#mResult').addClass('alert-danger');
            $('#mResult').html("由于服务器原因，搜索失败!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-danger');
                $('#mResult').html('');
            }, 2000);
        }
    })
});


// 模糊搜索
$('#fuzzSearch').click(function () {
    var keyWord = $('#searchKeyWord').val();
    $.ajax({
        type: "post",
        url: getPath() + "/todo/findByKeyWord",
        async: false,
        data: {keyword: keyWord},
        dataType: "json",
        success: function (data) {
            if (data.total != 0) {
                $('#findByKeywordModal').modal("hide");
                $('#searchKeyWord').val("");
                $('#table').bootstrapTable('destroy');
                $('#table').bootstrapTable();
                $('#table').bootstrapTable('load', data);
            } else {
                bootbox.alert({
                    centerVertical: true,
                    title: "失败",
                    message: "搜索失败!",
                    locale: "zh_CN"
                })
                initTable();
            }
        },
        error: function () {
            $('#mResult').addClass('alert-danger');
            $('#mResult').html("由于服务器原因，搜索失败!");
            setTimeout(function () {
                $('#mResult').removeClass('alert-danger');
                $('#mResult').html('');
            }, 2000);
        }
    })
});

