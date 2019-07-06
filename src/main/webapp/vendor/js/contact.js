function getPath() {
    var curPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curPath.indexOf(pathName);
    var localhostPath = curPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
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
        url: getPath() + "/contact/getAllInfo",
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
    var insertName = $('#insertName').val();
    var insertPhone = $('#insertPhone').val();
    var insertEmail = $('#insertEmail').val();
    var insertCompany = $('#insertCompany').val();
    var insertAddress = $('#insertAddress').val();


    $.ajax({
        type: "post",
        url: getPath() + "/contact/insertData",
        async: false,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            "contactId": 0,
            "userId": 0,
            "name": insertName,
            "phone": insertPhone,
            "email": insertEmail,
            "company": insertCompany,
            "address": insertAddress,
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
            ids += this.contactId + ",";
        });
        ids = ids.substring(0, ids.length - 1);

        bootbox.confirm({
            centerVertical: true,
            title: "删除确认",
            message: "确认删除所选?",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> 取消'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> 确认'
                }
            },
            callback: function (result) {
                if (result) {
                    $.ajax({
                        type: 'POST',
                        url: getPath() + "/contact/deleteByIds",
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
        $('#updateName').val(rows[0].name);
        $('#updatePhone').val(rows[0].phone);
        $('#updateEmail').val(rows[0].email);
        $('#updateCompany').val(rows[0].company);
        $('#updateAddress').val(rows[0].address);
        $('#updateModal').modal("toggle");
    }
});

$('#updateSave').click(function () {
    var rows = $('#table').bootstrapTable('getSelections');
    var updateId = rows[0].contactId;
    var updateName = $('#updateName').val();
    var updatePhone = $('#updatePhone').val();
    var updateEmail = $('#updateEmail').val();
    var updateCompany = $('#updateCompany').val();
    var updateAddress = $('#updateAddress').val();

    $.ajax({
        type: "post",
        url: getPath() + "/contact/updateData",
        async: false,
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            "contactId": updateId,
            "userId": 0,
            "name": updateName,
            "phone": updatePhone,
            "email": updateEmail,
            "company": updateCompany,
            "address": updateAddress,
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


// 姓名搜索
$('#findByDateBtn').click(function () {
    var searchName = $("#searchName").val();
    $.ajax({
        type: "post",
        url: getPath() + "/contact/findByName",
        async: false,
        dataType: 'json',
        data: {searchName: searchName},
        success: function (data) {
            console.log(data);
            if (data.total != 0) {
                $('#findByNameModal').modal("hide");
                $('#table').bootstrapTable('destroy');
                $('#table').bootstrapTable();
                $('#table').bootstrapTable('load', data);
            } else {
                $('#findByNameModal').modal("hide");
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
        url: getPath() + "/contact/findByKeyWord",
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

