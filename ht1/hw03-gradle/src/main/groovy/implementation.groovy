import java.time.LocalDateTime

myTasks = new TaskManager()

// создаем задачи,
myTasks.createTask('task1', LocalDateTime.now(),LocalDateTime.now().plusDays(10),[])
myTasks.showTasks()
myTasks.createTask('task2', LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(3),[])
myTasks.createTask('task3', LocalDateTime.now().plusDays(10),LocalDateTime.now().plusDays(15),[])
myTasks.showTasks()

// удаляем задачи
myTasks.deleteTask(2)
myTasks.deleteTask(22)
myTasks.showTasks()

// добавляем action для задачи
myTasks.tasks[0].addAction('делай раз',LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(3))
myTasks.tasks[0].addAction('делай два',LocalDateTime.now().plusDays(3),LocalDateTime.now().plusDays(5))
myTasks.tasks[0].addAction('делай три',LocalDateTime.now().plusDays(6),LocalDateTime.now().plusDays(11))
myTasks.tasks[0].addAction('делай четыре',LocalDateTime.now().plusDays(3),LocalDateTime.now().plusDays(6))
myTasks.tasks[0].showActions()

// удаляем действие
myTasks.tasks[0].deleteAction(1)
myTasks.tasks[0].showActions()

// кол-во дел на дату
LocalDateTime date1 = LocalDateTime.now()
myTasks.showCntDayTasks(date1)

// отображение списка дел на дату
myTasks.showDayTasks(date1)

// отображение busy time на дату
myTasks.showBusyTime(date1)