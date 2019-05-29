var imagePath = null;
function uploadImage(inputId) {
    var file = $('#' + inputId).prop("files")[0];
    if (file.type == 'image/jpeg' || file.type == 'image/jpg' || file.type == 'image/png') {
        if (file.size <= 1024 * 1024 * 3) {
            var formData = new FormData();
            formData.append("file", file);
            $.ajax({
                url: 'http://localhost:8080/course/uf',
                type: 'POST',
                data: formData,
                cache: false,
                async: false,
                dataType: 'text',
                processData: false,
                contentType: false,
                success: function (response) {
                    if (response == 'error' || response == null) {
                        alert('Image download error');
                    } else {
                        imagePath = response;
                        console.log(imagePath);
                    }
                }
            });
        } else {
            alert('The maximum image size should not exceed 3 MB');
        }

    } else {
        alert('Incorrect image format');
    }
    return imagePath;
}