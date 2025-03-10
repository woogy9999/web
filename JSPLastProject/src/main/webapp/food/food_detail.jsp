<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../food/map.css">
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="bradcumb-title text-center">
						<h2>맛집 상세보기</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="breadcumb-nav">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home" aria-hidden="true"></i> Home</a></li>
							<li class="breadcrumb-item"><a href="#">Archive</a></li>
							<li class="breadcrumb-item active" aria-current="page">Single
								Post Blog</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- ****** Breadcumb Area End ****** -->

	<!-- ****** Single Blog Area Start ****** -->
	<section class="single_blog_area section_padding_80">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-lg-8">
					<div class="row no-gutters">

						<!-- Single Post -->
						<div class="col-12 col-sm-12">


							<table class="table">
								<tr>
									<td width=30% class="text-center" rowspan="8"><img
										src="https://www.menupan.com${vo.poster }" style="width: 100%">
									</td>
									<td colspan="2">
										<h3>${vo.name }&nbsp;<span style="color: orange;">${vo.score }</span>
										</h3>
									</td>
								</tr>
								<tr>
									<th width=20%>음식종류</th>
									<td width=50%>${vo.type }</td>
								</tr>
								<tr>
									<th width=20%>주소</th>
									<td width=50%>${vo.address }</td>
								</tr>
								<tr>
									<th width=20%>전화</th>
									<td width=50%>${vo.phone }</td>
								</tr>
								<tr>
									<th width=20%>가격대</th>
									<td width=50%>${vo.price }</td>
								</tr>
								<tr>
									<th width=20%>주차</th>
									<td width=50%>${vo.parking }</td>
								</tr>
								<tr>
									<th width=20%>영업시간</th>
									<td width=50%>${vo.time }</td>
								</tr>
								<tr>
									<th width=20%>테마</th>
									<td width=50%>${vo.theme }</td>
								</tr>
							</table>
							<table class="table">
								<tr>
									<td>${vo.content }</td>
								</tr>
								<tr>
									<td class="text-right">
									
									<c:if test="${sessionScope.id!=null }">
									<a href="#"
										class="btn btn-sm btn-success">좋아요</a> <a href="#"
										class="btn btn-sm btn-info">찜하기</a> <a href="#"
										class="btn btn-sm btn-danger">예약하기</a>
									</c:if>
										 <a
										href="../food/list.do" class="btn btn-sm btn-primary">목록</a></td>
								</tr>
							</table>

							<!-- Related Post Area -->
							<div class="related-post-area section_padding_50">

								<div class="related-post-slider owl-carousel">
									<!-- Single Related Post-->
									<c:forTokens items="${vo.images }" delims="," var="img">
										<div class="single-post">
											<!-- Post Thumb -->
											<div class="post-thumb">
												<img src="http://www.menupan.com${img }" alt="">
											</div>
										</div>
									</c:forTokens>
								</div>
							</div>
							<%-- 지도 위치 --%>
							<div class="map_wrap">
								<div id="map"
									style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

								<div id="menu_wrap" class="bg_white">
									<div class="option">
										<div>
											<form onsubmit="searchPlaces(); return false;">
												키워드 : <input type="text" value="${addr } 맛집" id="keyword"
													size="15" readonly>

											</form>
										</div>
									</div>
									<hr>
									<ul id="placesList"></ul>
									<div id="pagination"></div>
								</div>
							</div>

							<script type="text/javascript"					
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0776a8d199dc3f39cb4a1c340a565fcc&libraries=services"></script>
							<script>
								// 마커를 담을 배열입니다
								var markers = [];

								var mapContainer = document
										.getElementById('map'), // 지도를 표시할 div 
								mapOption = {
									center : new kakao.maps.LatLng(37.566826,
											126.9786567), // 지도의 중심좌표
									level : 3
								// 지도의 확대 레벨
								};

								// 지도를 생성합니다    
								var map = new kakao.maps.Map(mapContainer,
										mapOption);

								// 장소 검색 객체를 생성합니다
								var ps = new kakao.maps.services.Places();

								// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
								var infowindow = new kakao.maps.InfoWindow({
									zIndex : 1
								});

								// 키워드로 장소를 검색합니다
								searchPlaces();

								// 키워드 검색을 요청하는 함수입니다
								function searchPlaces() {

									var keyword = document
											.getElementById('keyword').value;

									if (!keyword.replace(/^\s+|\s+$/g, '')) {
										alert('키워드를 입력해주세요!');
										return false;
									}

									// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
									ps.keywordSearch(keyword, placesSearchCB);
								}

								// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
								function placesSearchCB(data, status,
										pagination) {
									if (status === kakao.maps.services.Status.OK) {

										// 정상적으로 검색이 완료됐으면
										// 검색 목록과 마커를 표출합니다
										displayPlaces(data);

										// 페이지 번호를 표출합니다
										displayPagination(pagination);

									} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

										alert('검색 결과가 존재하지 않습니다.');
										return;

									} else if (status === kakao.maps.services.Status.ERROR) {

										alert('검색 결과 중 오류가 발생했습니다.');
										return;

									}
								}

								// 검색 결과 목록과 마커를 표출하는 함수입니다
								function displayPlaces(places) {

									var listEl = document
											.getElementById('placesList'), menuEl = document
											.getElementById('menu_wrap'), fragment = document
											.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

									// 검색 결과 목록에 추가된 항목들을 제거합니다
									removeAllChildNods(listEl);

									// 지도에 표시되고 있는 마커를 제거합니다
									removeMarker();

									for (var i = 0; i < places.length; i++) {

										// 마커를 생성하고 지도에 표시합니다
										var placePosition = new kakao.maps.LatLng(
												places[i].y, places[i].x), marker = addMarker(
												placePosition, i), itemEl = getListItem(
												i, places[i]); // 검색 결과 항목 Element를 생성합니다

										// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
										// LatLngBounds 객체에 좌표를 추가합니다
										bounds.extend(placePosition);

										// 마커와 검색결과 항목에 mouseover 했을때
										// 해당 장소에 인포윈도우에 장소명을 표시합니다
										// mouseout 했을 때는 인포윈도우를 닫습니다
										(function(marker, title) {
											kakao.maps.event.addListener(
													marker, 'mouseover',
													function() {
														displayInfowindow(
																marker, title);
													});

											kakao.maps.event.addListener(
													marker, 'mouseout',
													function() {
														infowindow.close();
													});

											itemEl.onmouseover = function() {
												displayInfowindow(marker, title);
											};

											itemEl.onmouseout = function() {
												infowindow.close();
											};
										})(marker, places[i].place_name);

										fragment.appendChild(itemEl);
									}

									// 검색결과 항목들을 검색결과 목록 Element에 추가합니다
									listEl.appendChild(fragment);
									menuEl.scrollTop = 0;

									// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
									map.setBounds(bounds);
								}

								// 검색결과 항목을 Element로 반환하는 함수입니다
								function getListItem(index, places) {

									var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
											+ (index + 1)
											+ '"></span>'
											+ '<div class="info">'
											+ '   <h5>'
											+ places.place_name + '</h5>';

									if (places.road_address_name) {
										itemStr += '    <span>'
												+ places.road_address_name
												+ '</span>'
												+ '   <span class="jibun gray">'
												+ places.address_name
												+ '</span>';
									} else {
										itemStr += '    <span>'
												+ places.address_name
												+ '</span>';
									}

									itemStr += '  <span class="tel">'
											+ places.phone + '</span>'
											+ '</div>';

									el.innerHTML = itemStr;
									el.className = 'item';

									return el;
								}

								// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
								function addMarker(position, idx, title) {
									var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
									imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
									imgOptions = {
										spriteSize : new kakao.maps.Size(36,
												691), // 스프라이트 이미지의 크기
										spriteOrigin : new kakao.maps.Point(0,
												(idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
										offset : new kakao.maps.Point(13, 37)
									// 마커 좌표에 일치시킬 이미지 내에서의 좌표
									}, markerImage = new kakao.maps.MarkerImage(
											imageSrc, imageSize, imgOptions), marker = new kakao.maps.Marker(
											{
												position : position, // 마커의 위치
												image : markerImage
											});

									marker.setMap(map); // 지도 위에 마커를 표출합니다
									markers.push(marker); // 배열에 생성된 마커를 추가합니다

									return marker;
								}

								// 지도 위에 표시되고 있는 마커를 모두 제거합니다
								function removeMarker() {
									for (var i = 0; i < markers.length; i++) {
										markers[i].setMap(null);
									}
									markers = [];
								}

								// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
								function displayPagination(pagination) {
									var paginationEl = document
											.getElementById('pagination'), fragment = document
											.createDocumentFragment(), i;

									// 기존에 추가된 페이지번호를 삭제합니다
									while (paginationEl.hasChildNodes()) {
										paginationEl
												.removeChild(paginationEl.lastChild);
									}

									for (i = 1; i <= pagination.last; i++) {
										var el = document.createElement('a');
										el.href = "#";
										el.innerHTML = i;

										if (i === pagination.current) {
											el.className = 'on';
										} else {
											el.onclick = (function(i) {
												return function() {
													pagination.gotoPage(i);
												}
											})(i);
										}

										fragment.appendChild(el);
									}
									paginationEl.appendChild(fragment);
								}

								// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
								// 인포윈도우에 장소명을 표시합니다
								function displayInfowindow(marker, title) {
									var content = '<div style="padding:5px;z-index:1;">'
											+ title + '</div>';

									infowindow.setContent(content);
									infowindow.open(map, marker);
								}

								// 검색결과 목록의 자식 Element를 제거하는 함수입니다
								function removeAllChildNods(el) {
									while (el.hasChildNodes()) {
										el.removeChild(el.lastChild);
									}
								}
							</script>
							<!-- Comment Area Start -->
							<div class="comment_area section_padding_50 clearfix">
								<h4 class="mb-30">2 Comments</h4>

								<ol>
									<!-- Single Comment Area -->
									<li class="single_comment_area">
										<div class="comment-wrapper d-flex">
											<!-- Comment Meta -->
											<div class="comment-author">
												<img src="../img/blog-img/17.jpg" alt="">
											</div>
											<!-- Comment Content -->
											<div class="comment-content">
												<span class="comment-date text-muted">27 Aug 2018</span>
												<h5>Brandon Kelley</h5>
												<p>Neque porro qui squam est, qui dolorem ipsum quia
													dolor sit amet, consectetur, adipisci velit, sed quia non
													numquam eius modi tempora.</p>
												<a href="#">Like</a> <a class="active" href="#">Reply</a>
											</div>
										</div>
										<ol class="children">
											<li class="single_comment_area">
												<div class="comment-wrapper d-flex">
													<!-- Comment Meta -->
													<div class="comment-author">
														<img src="../img/blog-img/18.jpg" alt="">
													</div>
													<!-- Comment Content -->
													<div class="comment-content">
														<span class="comment-date text-muted">27 Aug 2018</span>
														<h5>Brandon Kelley</h5>
														<p>Neque porro qui squam est, qui dolorem ipsum quia
															dolor sit amet, consectetur, adipisci velit, sed quia non
															numquam eius modi tempora.</p>
														<a href="#">Like</a> <a class="active" href="#">Reply</a>
													</div>
												</div>
											</li>
										</ol>
									</li>
									<li class="single_comment_area">
										<div class="comment-wrapper d-flex">
											<!-- Comment Meta -->
											<div class="comment-author">
												<img src="../img/blog-img/19.jpg" alt="">
											</div>
											<!-- Comment Content -->
											<div class="comment-content">
												<span class="comment-date text-muted">27 Aug 2018</span>
												<h5>Brandon Kelley</h5>
												<p>Neque porro qui squam est, qui dolorem ipsum quia
													dolor sit amet, consectetur, adipisci velit, sed quia non
													numquam eius modi tempora.</p>
												<a href="#">Like</a> <a class="active" href="#">Reply</a>
											</div>
										</div>
									</li>
								</ol>
							</div>

							<!-- Leave A Comment -->
							<div class="leave-comment-area section_padding_50 clearfix">
								<div class="comment-form">
									<h4 class="mb-30">Leave A Comment</h4>

									<!-- Comment Form -->
									<form action="#" method="post">
										<div class="form-group">
											<input type="text" class="form-control" id="contact-name"
												placeholder="Name">
										</div>
										<div class="form-group">
											<input type="email" class="form-control" id="contact-email"
												placeholder="Email">
										</div>
										<div class="form-group">
											<input type="text" class="form-control" id="contact-website"
												placeholder="Website">
										</div>
										<div class="form-group">
											<textarea class="form-control" name="message" id="message"
												cols="30" rows="10" placeholder="Message"></textarea>
										</div>
										<button type="submit" class="btn contact-btn">Post
											Comment</button>
									</form>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>