<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Customer CSS commons.css -->
    <link rel="stylesheet" href="../css/commons.css">
</head>

<body>
    <nav>nav</nav>
    <main class="container">
        <h2>BOARD CREATE</h2>
        <form action="">
            <div class="mb-3 mt-3">
                <label for="TITLE" class="form-label">TITLE:</label>
                <input type="text" class="form-control" id="TITLE" placeholder="Enter TITLE" name="TITLE">
            </div>
            <div class="mb-3">
                <label for="WRITER_ID" class="form-label">WRITER_ID :</label>
                <input type="text" class="form-control" id="WRITER_ID" placeholder="Enter WRITER_ID" name="WRITER_ID">
            </div>
            <div class="mb-3">
                <label for="PARENT_BOARDS" class="form-label">CATEGORY :</label>
                <input type="text" class="form-control" id="PARENT_BOARDS" placeholder="Enter CATEGORY" name="PARENT_BOARDS">
            </div>
            <div class="mb-3">
                <label for="CONTENTS">CONTENTS :</label>
                <textarea class="form-control" rows="5" id="CONTENTS" name="CONTENTS"></textarea>
            </div>
            <!-- 게시물 작성 -->
            <button type="submit" class="btn btn-primary" formaction="/q/board/list_pagination" formmethod="get" name="btn_type" value="insert">POST</button>
            <!--홈으로 이동  -->
            <button type="submit" class="btn btn-danger" formaction="/">CANCEL</button>

          </form>
    </main>
    <footer>footer</footer>
</body>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</html>