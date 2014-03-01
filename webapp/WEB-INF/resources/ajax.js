var req;
// Путь к файлу на сервере на который будет отправляться запрос
var handlerPath = 'xmlhttp.php';

function createRequest() {
    // Создание объекта XMLHttpRequest отличается для Internet Explorer и других обозревателей, поэтому для совместимости эту операцию приходиться дублировать разными способами
    if (window.XMLHttpRequest) req = new XMLHttpRequest();      // normal browser
    else if (window.ActiveXObject) {                            // IE
        try {
            req = new ActiveXObject('Msxml2.XMLHTTP');          // IE разных версий
        } catch (e) {
        }                                           // может создавать
        try {                                                   // объект по разному
            req = new ActiveXObject('Microsoft.XMLHTTP');
        } catch (e) {
        }
    }
    return req;
}

function getData(handlerPath, parameters) {
    // Создаем запрос
    req = createRequest();
    if (req) {
        // Отправляем запрос методом POST с обязательным указанием файла обработчика (true - асинхронный режим включен)
        req.open("POST", handlerPath, false);
        // При использовании объекта XMLHttpRequest с методом POST требуется дополнительно отправлять header
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        // Передаем необходимые параметры (несколько параметров разделяются амперсандами)
        req.send(parameters);

        // Для статуса "OK"
        if (req.status == 200) {
            // Получаем ответ функции в виде строки
            var rData = req.responseText;
            // Проверяем данные с помощью регулярных выражений, после выполняем функцию eval()
            var eData = !(/[^,:{}\[\]0-9.\-+Eaeflnr-u \n\r\t]/.test(rData.replace(/"(\\.|[^"\\])*"/g, ''))) && eval('(' + rData + ')');
            // Создаем массив данных
            var eArray = new Object(eData);
        } else {
            alert("Не удалось получить данные:\n" + req.statusText);
        }
    } else {
        alert("Браузер не поддерживает AJAX");
    }
    return eArray;
}
