
var count = 0;
var count_line = 1;

var count_budget = 0;
var count_budget_line = 1;


var num = 5;
var num_index = 4;


var i;
var check = true;
var check_budget = true;
//var check_type = null;
//var check_plan = null;
//var check_payment = null;

$(document).ready(function () {

    $('#example').DataTable();
   
    $(function () {

        $('#startDate').datetimepicker();

        $('#endDate').datetimepicker();

        $('#paymentDate').datetimepicker();
//        $('#endDate').datepicker({
//            dateFormat: 'dd/mm/yy'
//        });
//        $('#paymentDate').datepicker({
//            dateFormat: 'dd/mm/yy'
//        });
    });
});


$(document).ready(function () {
     $('#example2').DataTable();
    });

//
//function selectType2() {
//    count_budget = 0;
//    count_budget_line = 1;
//    $('#listBudget' + count_budget + '').empty();
//    $('#mybody2').empty();
//    var selectedValue = $('#typeID').val();
//    $.ajax({
//        url: 'selectType',
//        type: 'GET',
//        data: 'typeID=' + selectedValue,
//        headers: {dataType: 'json',
//            Accept: 'application/json'
//        },
//        success: function (result) {
//
//            $('#listBudget' + count_budget + '').attr('name', 'ticketDTraining[' + count_budget + '].trainingBudgetDescription.budgetID');
//            if (result == "") {
//                $('#listBudget' + count_budget + '').html('<option value="" label="--- Select ---"/>');
//            }
//            $.each(result, function (key, val) {
//                if (key == 0) {
//                    var tr = '<option value=\"0\" label=\"--- Select ---\"/>';
//                }
//                tr = tr + '<option value=\"' + val.budgetID + '\" label=\"' + val.budgetDescription + '\"> </option>';
//                $('#listBudget' + count_budget + '').append(tr);
//
//            });
//        }
//
//    });
//    var n = "<tr>";
//    n = n + "<td>" + count_budget_line + "</td>";
//    n = n + "<td><select id=\"listBudget" + count_budget + "\" name=\"ticketDTraining[" + count_budget + "].trainingBudgetDescription.budgetID\" class=\"form-control\" style=\"width: 200px\"></select></td>";
//    n = n + "<td> <textarea class=\"form-control\" id=\"budgetDetail" + count_budget + "\" name=\"ticketDTraining[" + count_budget + "].budgetDetail\" style=\" resize: none;\">  </textarea></td>";
//    n = n + "<td><input type=\"text\" id=\"amount" + count_budget + "\"name=\"ticketDTraining[" + count_budget + "].amount\" class=\"form-control\"  /></td>";
//    n = n + "<td><button id=\"addRow\" class=\"btn btn-success\" style=\"width: 35px; float: left\"  type=\"button\" onclick=\"addRowBudget();\">+</button>";
//    n = n + "<button id=\"delRow\" class=\"btn btn-danger\"  style=\"width: 35px;\"  type=\"button\" onclick=\"deleteRowBudget();\">-</button> </td>";
//    n = n + "</tr>";
//    $('#tbbudget > tbody:last').append(n);
//}
//
//
//function selectType() {
//    count_budget = 0;
//    count_budget_line = 1;
//    $('#listBudget' + count_budget + '').empty();
//    $('#mybody2').empty();
//    var selectedValue = $('#typeID').val();
//    $.ajax({
//        url: 'training/selectType',
//        type: 'GET',
//        data: 'typeID=' + selectedValue,
//        headers: {dataType: 'json',
//            Accept: 'application/json'
//        },
//        success: function (result) {
//
//            $('#listBudget' + count_budget + '').attr('name', 'ticketDTraining[' + count_budget + '].trainingBudgetDescription.budgetID');
//            if (result == "") {
//                $('#listBudget' + count_budget + '').html('<option value="" label="--- Select ---"/>');
//            }
//            $.each(result, function (key, val) {
//                if (key == 0) {
//                    var tr = '<option value=\"0\" label=\"--- Select ---\"/>';
//                }
//                tr = tr + '<option value=\"' + val.budgetID + '\" label=\"' + val.budgetDescription + '\"> </option>';
//                $('#listBudget' + count_budget + '').append(tr);
//
//            });
//        }
//
//    });
//    var n = "<tr>";
//    n = n + "<td>" + count_budget_line + "</td>";
//    n = n + "<td><select id=\"listBudget" + count_budget + "\" name=\"ticketDTraining[" + count_budget + "].trainingBudgetDescription.budgetID\" class=\"form-control\" style=\"width: 200px\"></select></td>";
//    n = n + "<td> <textarea class=\"form-control\" id=\"budgetDetail" + count_budget + "\" name=\"ticketDTraining[" + count_budget + "].budgetDetail\" style=\" resize: none;\">  </textarea></td>";
//    n = n + "<td><input type=\"text\" id=\"amount" + count_budget + "\"name=\"ticketDTraining[" + count_budget + "].amount\" class=\"form-control\"  /></td>";
//    n = n + "<td><button id=\"addRow\" class=\"btn btn-success\" style=\"width: 35px; float: left\"  type=\"button\" onclick=\"addRowBudget();\">+</button>";
//    n = n + "<button id=\"delRow\" class=\"btn btn-danger\"  style=\"width: 35px;\"  type=\"button\" onclick=\"deleteRowBudget();\">-</button> </td>";
//    n = n + "</tr>";
//    $('#tbbudget > tbody:last').append(n);
//}

function addRowParticipant() {
    var rowCount = $('#myTbl tr').length;
    count = rowCount - 1;
    count_line = rowCount;
    for (i = 0; i <= count; i++)
    {
        var row = $('#participant' + i).val();
        if (row == "") {
            check = false;
        }

    }
    if (check == true) {
        count++;
        count_line++;
        var tr = "<tr>";
        tr = tr + "<td> <input type=\'text\'  id=\'participant" + count + "\' name='trainingParticipant[" + count + "].participantName'  class=\'form-control\' /></td>";
        tr = tr + "</tr>";

        $('#myTbl > tbody:last').append(tr);
    }
    else {
        check = true;
        alert('Not Null Participant');
    }

}
function deleteRowParticipant() {
    if ($('#myTbl tr').length != 1) {
        $('#myTbl > tbody tr:last, this').remove();
    }
}

function addRowBudget() {

    var rowCount = $('#tbbudget tr').length;
    num_index = rowCount - 1;
    num = rowCount;
    for (i = 0; i <= num_index; i++)
    {
        var item = $('#item' + i).val();
        var amount = $('#amount' + i).val();
        if (item == "" || amount == "") {
            check = false;
        }

    }

    if (check == true) {

        if ($('#tbbudget tr').length <= 10) {
            var n = "<tr>";
            n = n + "<td>" + num + "</td>";
            n = n + "<td><input type=\"text\" id=\"item" + num_index + "\"name=\"ticketHeader.ticketDTraining[" + num_index + "].item\" class=\"form-control\"  /></td>";
            n = n + "<td> <textarea id=\"budgetDetail" + num_index + "\" class=\"form-control\"  name=\"ticketHeader.ticketDTraining[" + num_index + "].budgetDetail\" style=\" resize: none;]\">  </textarea></td>";
            n = n + "<td><input type=\"text\" id=\"amount" + num_index + "\"name=\"ticketHeader.ticketDTraining[" + num_index + "].amount\" class=\"form-control\"   value=\"0.00\" /></td>";


            n = n + "</tr>";
            $('#tbbudget > tbody:last').append(n);

        }
    }
    else {
        check = true;
        alert('Not Null Budget');
    }

//    $('#listBudget' + count_budget + '').attr('name', 'ticketDTraining[' + count_budget + '].trainingBudgetDescription.budgetID');
//    $('#budgetDetail' + count_budget + '').attr('name', 'ticketDTraining[' + count_budget + '].budgetDetail');
//    $('#amount' + count_budget + '').attr('name', 'ticketDTraining[' + count_budget + '].amount');
//
//    for (i = 0; i <= count_budget; i++)
//    {
//        var check_listbudget = $('#listBudget' + i).val();
//        var check_amount = $('#amount' + i).val();
//        if (check_listbudget == 0 || check_amount == 0) {
//            check_budget = false;
//        }
//    }
//    var selectedValue = $('#typeID').val();
//    if (check_budget == true) {
//
//        count_budget++;
//        count_budget_line++;
//        $.ajax({
//            url: 'training/selectType',
//            type: 'GET',
//            data: 'typeID=' + selectedValue,
//            headers: {dataType: 'json',
//                Accept: 'application/json'
//            },
//            success: function (result) {
//                if (result == "") {
//                    $('#listBudget' + count_budget + '').html('<option value=\"0\" label="--- Select ---"/>');
//                }
//
//                $.each(result, function (key, val) {
//                    if (key == 0) {
//                        var tr = '<option value=\"0\" label=\"--- Select ---\"/>';
//                    }
//                    tr = tr + '<option value=\"' + val.budgetID + '\" label=\"' + val.budgetDescription + '\"> </option>';
//                    $('#listBudget' + count_budget + '').append(tr);
//                });
//            }
//        });
//
//
//        var n = "<tr>";
//        n = n + "<td>" + count_budget_line + "</td>";
//        n = n + "<td><select id=\"listBudget" + count_budget + "\" name=\"ticketDTraining[" + count_budget + "].trainingBudgetDescription.budgetID\" class=\"form-control\" style=\"width: 200px\"></select></td>";
//        n = n + "<td> <textarea class=\"form-control\" id=\"budgetDetail" + count_budget + "\" name=\"ticketDTraining[" + count_budget + "].budgetDetail\" style=\" resize: none;]\">  </textarea></td>";
//        n = n + "<td><input type=\"text\" id=\"amount" + count_budget + "\"name=\"ticketDTraining[" + count_budget + "].amount\" class=\"form-control\"  /></td>";
//
//
//        n = n + "</tr>";
//        $('#tbbudget > tbody:last').append(n);
//
//    }
//    else {
//        check_budget = true;
//        alert('Not Null Budget');
//    }

}

function deleteRowBudget() {
    if ($('#tbbudget tr').length != 6) {
        num--;
        num_index--;
        $('#tbbudget > tbody tr:last, this').remove();
    }

}
