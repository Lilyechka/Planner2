$('#createTaskForm').submit(function(event) {
    event.preventDefault();

    var formData = $(this).serialize();

    $.post('/api/tasks', formData)
        .done(function(response) {
            console.log('Завдання успішно створено:', response);
        })
        .fail(function(xhr, status, error) {
            console.error('Помилка при створенні завдання:', error);
        });
});

$('#editTaskForm').submit(function(event) {
    event.preventDefault();

    var taskId = $(this).data('task-id');
    var formData = $(this).serialize();

    $.ajax({
        url: '/api/tasks/' + taskId,
        method: 'PUT',
        data: formData
    })
        .done(function(response) {
            console.log('Завдання успішно оновлено:', response);
        })
        .fail(function(xhr, status, error) {
            console.error('Помилка при оновленні завдання:', error);
        });
});
$('.delete-task-btn').click(function(event) {
    event.preventDefault();

    var taskId = $(this).data('task-id');

    $.ajax({
        url: '/api/tasks/' + taskId,
        method: 'DELETE'
    })
        .done(function(response) {
            console.log('Завдання успішно видалено:', response);

        })
        .fail(function(xhr, status, error) {
            console.error('Помилка при видаленні завдання:', error);
        });
});
