function getStudentList() {
    $.ajax({
        url: 'cs?action=getStudentList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#content').html(data);
        },
        error: function (data) {
            alert('Error');
        }
    });
}

// Schedule  Begin
function getScheduleList() {
    $.ajax({
        url: 'cs?action=getScheduleList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#contentSchedule').html(data);
        },
        error: function (data) {
            alert('Error');
        }
    });
}

function addSchedule() {
    var studentName = $('#name').val();
    var studentSurname = $('#surname').val();
    var studentEmail = $('#email').val();
    var studentDate = $('#date').val();
    var universityId = $('#university').val();
    var data = {
        studentName: studentName,
        studentSurname: studentSurname,
        studentEmail: studentEmail,
        studentDate: studentDate,
        universityId: universityId,
    };
    $.ajax({
        url: 'cs?action=addSchedule',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function () {
            alert('Schedule was added successfully');
            getScheduleList();
        }
    });
}

$("#addSchedule").on('click', function () {
    addSchedule();
});

$(function () {
    $('#showSchedule').click(function () {
        $('#contentSchedule').show();
        getScheduleList();
    });

    $('#hideSchedule').click(function () {
        $('#contentSchedule').hide();
    });
});

// *-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*

$(function () {
    $.ajax({
        url: 'cs?action=universityList',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#university').html(data);
        },
        error: function () {
            console.log('Error');
        }
    });
});


$(function () {
    $('#buttonContent').click(function () {
        $('#content').show();
        getStudentList();
    });

    $('#hideStudent').click(function () {
        $('#content').hide();
    });
});

$(function () {
    $('#buttonContent').click(function () {
        $('#content').show();
        getStudentList();
    });

    $('#hideStudent').click(function () {
        $('#content').hide();
    });
});

function addStudent() {
    var name = $('#name').val();
    var surname = $('#surname').val();
    var email = $('#email').val();
    var date = $('#date').val();
    var data = {
        name: name,
        surname: surname,
        email: email,
        date: date,
    };
    $.ajax({
        url: 'cs?action=addStudent',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function () {
            alert('Student was added successfully');
            getStudentList();
        }
    });
}

$("#addStudent").on('click', function () {
    addStudent();
    $("#addStudent").off("click");
});


$("#addTest").on('click', function () {
    addTest();
});


function addTest() {
    var imagePat = uploadImage('testImage');
    var testName = $('#testName').val();
    var data = {
        testName:testName,
        imagePath:imagePath
    };
    $.ajax({
        url: 'http://localhost:8080/course/cs?action=addTest',
        type: 'POST',
        data: data,
        dataType: 'text',
        success: function () {
            alert('Test successfully added');
        }
    });
}

function selectedSchedule(scheduleId, student, university) {
}
