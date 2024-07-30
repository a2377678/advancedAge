<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>

<div id="countDown" class="countdown shadow-sm">計時提醒 25:00</div>

<!--- Button trigger modal --->
<button type="button" id="noticeTime" class="sendcase" data-bs-toggle="modal"
	data-bs-target="#notice" style="display:none">送出案件</button>
<!---------- Modal ---------->
<div class="modal fade" id="notice" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title fw-bold" id="staticBackdropLabel">請注意 !!</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body h5 fw-bold lh-base">
				若您尚未填寫完畢，請先按下【暫存資料】<br>，避免資料遺失。
			</div>
			<div class="pt-2 pb-5">
				<button type="button" class="btn btn-primary" data-bs-dismiss="modal">確認</button>
			</div>
		</div>
	</div>
</div>
<!---------- Modal end ---------->

<script src="js/countDown/countDown.js"></script>