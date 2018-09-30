<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>movie-elasticsearch</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/common.css">
</head>
<body class="container">
    <header>
        <h1 class="center-block">Movie ElasticSearch</h1>
    </header>
    <section>
        <form action="/s" class="input-group">
            <input name="wd" class="form-control">
            <div class="input-group-btn">
                <button type="submit" class="btn btn-primary">搜索</button>
            </div>
        </form>
        <p>豆瓣高分：
            <#list recommendWord as word>
            <a href="/s?wd=${word?url('utf-8')}">${word}</a>
            </#list>
        </p>
    </section>
</body>
</html>