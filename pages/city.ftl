<html>
<body>
<#if city??>
    <form action="/city/clear" method="post" >
        <label for="change">Ваш регион - ${city}</label>
        <button id="change" type="submit">Сменить</button>
    </form>
<#else>
    <form action="/city" method="post">
        <select name="city">
            <option value="1">МОСКВА</option>
            <option value="2">САНКТ-ПЕТЕРБУРГ</option>
        </select>
        <button type="submit">Выбрать</button>
    </form>
</#if>
</body>
</html>