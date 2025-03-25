<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : 'post',
			url : '../reserve/reserve_food_info.do',
			success : function(result) {
				$('#food_list').html(result)
			}
		})
	})
</script>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="bradcumb-title text-center">
						<h2>예약하기</h2>
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
							<li class="breadcrumb-item active" aria-current="page">food-list
								Page</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- ****** Breadcumb Area End ****** -->

	<!-- ****** Archive Area Start ****** -->
	<section class="archive-area section_padding_80">
		<div class="container">
			<div class="row">
				<table class="table">
					<tr>
					
						<td width="30%" height="600">
						
							<table class="table">
								<tr>
									<td class="table-danger"><h4 class="text-center">맛집 정보</h4></td>
								</tr>
								<tr>
									<td>
										<div id="food_list" style="height: 600px; overflow-y: scroll"></div>
									</td>
								</tr>
							</table>
							
						</td>
						
						<td width="40%" height="600">
							<table class="table">
								<tr>
									<td class="table-info"><h4 class="text-center">예약일 정보</h4></td>
								</tr>
								<tr>
								 <td id="food_rdays"></td>
								</tr>
							</table>
						</td>
						
						<td width="30%" height="850" rowspan="2">
							<table class="table">
								<tr>
									<td class="table-success" colspan="2"><h4 class="text-center">예약 정보</h4></td>
								</tr>
								
								<tr>
								 <td class="text-center" colspan="2">
								  <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQMAAADCCAMAAAB6zFdcAAAAY1BMVEXy8vJmZmb4+Pj5+flbW1tiYmL09PReXl5ra2thYWHp6elZWVmtra3IyMiVlZW3t7e/v7+goKDb29vk5OSGhobFxcXV1dVxcXHOzs5UVFR9fX11dXWDg4ONjY3S0tKlpaWUlJQMIUm5AAAO+UlEQVR4nO1dCYOiuBKGJFQ4RC4VAa///ytfVSUgikf3br8dM51vZ3t65NB81J1KDIJfD/jTH8DDw8PDw8PDw8PDw8PDw8PDw8PDw8PDw8PDw8PDw8PDw8PDw+MBfG9TEAjx61kQZVWLn7qZm2yKsku6k3z96b80NDfHTxCXKAzV/h0J4guQriqVyLsQSUBJeHGOaMpz9RbnogY3aZBlRiTsn9oEENuhU9EXoLu4CMBFFmTBJJzEA3UAHFJ6UOGXodraSVEwkpDtH6kDUsBji7R6j4jOzHY/5mX+SxhJ0I/UAWAgBrJjUb5FsU40npw0bqqDkYQH6iAqHJbepJI8A7wCHpVBhWoT9W+czGcCRsN4rw7QIAXJWn7pyQJJFJLQnRykIJi8w+lOHeSKpPsbCi6PURhtpMskZHfBEiAFqvwGB1DjbVTtJgdIQhfeR4yiJDH43m16VJ7qVcT1sYDRJmQz7wDQ4oBWXxcDZA/2eJcsdVQQrDroqySIPVo4/c3xEG/6G7x9FkBMkmCGLTZo4NbP5fohOYJcQ+yqHNy7SBCHKOyaxXBASGkzRUwV7w9DQML0HTv6YRjVwQwN6ljdSTWOH+qyOvZD2w79sSp2AaXMcyLEOcE4ycmsweDWMGLwN2kCDRST6OKgKYm0KVKiu2xY1eKGqLQjWXIyYDa4Gsbg9vESIWWvHuSQGmkIZmGRpLJM7CAH/Ikx7A/klkjoRkmYeBDBSlsCKInUidYaf1p56Kp0kn6oKWsYGgl8w+n2H08KKbr5TRTJMncAUYTaVAiyYV3kdYOo90XV6ywyWnEOxHguJVpRcq5TxHgH8eEBND79dNWHSjPMo53XEwDqgV/WerNNxTWFRNeQ7o+JORZOV4gDJ9HK3pAQ9efmo+0kwFnpRUkon0kCH1XxKrWF06tsU8pcDKQ/YVfBqFLHbGk2unX6uR4Tgt4wEN186Ks6QN2RtBeB9ZkUIRCE0Xe0ljlrim5TE19huJWo6J6FJKwfFew+AzF9XJSE+IpknjsADJlaB8IOuNkX6+PhsFmv8rGSLMSKDWayG0mA/DLM78eU6GXE9REAeaRaUVg28xeniNGK/p5rpSgAdTWgW0gi9g+Zjtd7M1kn65ZFYTfxdhM1pPlAJLWfyQFnRskRbsO9WbBkxJ9+iqBss+hWxhMVrgLDz5pGmc3qMGD/8FFxxsMUd34eDUCZUbiMbR/MO4h9nI0Dz7quyxJDhw4LMhQgV3Q4mcs7kOjYpEKuScE+0SxCSiXAB7XgBQnQdGw4VXI4b091fcpXm1BxlKR5WgFkwWfM5llAnM7r885YkoDF5PPEIIATfu5+mSDDggRB5RGdXPaYJpkAgRKoKmRjmBV0GtdUk81Em6jbLomSbmg43agiLsl8HAuiVM+KX+jgbiPGtuvO6W26DCIoOGJWa7KfkkJEVYx2sR7TC00lRirNvapH/DGIQj+r+4AYOPTJrbkEUQcPBEYATSuEakNPWB6icCw6sPCj7UisQxC5Qg4+MFp8wYFYmdBJTxHjw9QHB75n53+kZDPFEUcbugBIxEJVbclfkIexHPwfB/MP8ZwDSNnMk7Lnbx6eSCnGVGciYatGIyKOqP9nCbJKWAcclAP66GFsDOM7EiBtI+bK+FpTR6I6O801wAlp2bjIAaQUPhayVPdxwgMApKwOgXWh5AJBbriyiC4TbeHFRQ7YGrQ4ku3X1IF8QHLBs7iOdJD2DjpvSp6tAvc4AIitl5MmcX4jCYGkrIl8IHtEnmZhg6K5/EQS4hoHACeaOaTi2soUzLrXkoCPubcegWryGAthDFWMZYRsKxyUA7nGgazJ5cecEpBUvyZB7MgQYGjA05Q9e4ai4ysznm9wjgNB8k+WLad5IzaM2Rt1kH0U6orCRWVLBSCac9/2Z1NacY0DaEiMA9tRUMmvuEhDF6lPT9JvYkWejgIzPeEYBxzbH+nxaY59zVwkRYxPhwCsNhgQADmEpFokR85xgAESvQyk5C2FPmbeIX+lDvJCEQUaw93DXNQ5DjDaU3uUX/QK+Ein/gSVv5gnmISHwqtkeU/HOKA2Akr/yByoLeeNcqtMsPT0XhwiDjRGVIpukV45xgGnvSqwMf/OfGwzDaeekwBgDSkl3ctZe9c4oPA/wldFbNycqQiyJLwggRwqNa6QJnWLziznODD1TwCqIE7tOEYSnquDJMdAURJq0LJN0UUOYiqsU6R7bUmyU/PPSJDt38ZBaHUhSa8HjDoYF7kcjLSawxzsnOeAHjcY64bJ4KzDYvsiYhQ06Y6MUfrkvj0g70b5rzyYtOGKFy4SqA0nDqxnTe8PO8ZBABTy11RQwzyouKmmX13kXbcOBpUZJ4xmNuX+qHMc0FovvcXhYMYYHW97UmzEuF0Gw6vI5AmUcMXux8oYI0c8nI4Mw+1U3OQi7x80Co/GoJJzi43zHMBeUXUYj7dUOLj73HLbhXedKmBXOygyIqRAD3h1jYMgs27urE2F9AYyZxe5FfMruIZK6aIkKVm4Rvc44EShFKZCulyRMErCDQmJKRzyIoZwYTGd44Bfx4eKTxe9IyXEd7AucnudhjNTc4Ht1l1e4R4HbNsp9xM0OX9tZp8gc+MdrhPtAxfjgTPnR4mVexxQ7seT8jyVHC4jY1NZ0hMJ8qgTOo2nWqMHI3WOA1Mh5bS5pgh4s/zs1jDmYpyPrio6ndPt84M2A/c4YK+YUMsEr27TD5on7ooqwB1qZsb90eoXBzkAGiG7OHkgi1/dL9gAKwnZqA7cpE3ZFgWLD97KPQ7YyIUtdZxxF6c63jduEQmdMYzjERBrfZttz+7nIgc7sggUMENz7T67hS2vXb0DFV2mhqS7+znIge2wovGJhpuZsyq4L63LvZ5HjOhOlBoe385JDkwlLaM9YyDl7n0dnlMx2QXqzksLnliexQOr1ZO5KEc5qHkhApNgWnHDpDsUNa9hwMHU5aazTf8zSXg2Skc5MNOMTAIGjLFpN1QqHDbH42YI7fIm/abkPr6VkxyMPchcPqSeinhclRBdW7dVtNreuMinb+UkBxQbnLleQtOvGAZDechuFmeobihSYVzkOxLc5IBgJEH3DU+7C5GWl1ZntP9JpuJj0QiekM3D9yS4y0FguvOibBUIsxJByqDZnU67BgXA5AoCilvD+Pit3OUAYyVeqKDDAqRd0GTARwFfLFvbnK1ekeAyB/j8j8rY/6pm13ddn4AE1OfEHNVvJMFpDlD+89Cy0FbbBqQFpHk1mGWBiSrG3OHpWznNAT3wVWQXAKosGjaX9fqCAUJm1rGgDFSpFPlrFwm5dpoDXqzRZpNbjGYBQphhBE15hCmvdcvJF/tWH9u7TxNJ7zdxYYcAp0uikvt1bXqT28WfOMonM1D2rfSTysIfhmk8++ICG7SAu9WxTVSGAQL+r+PDeR/MtpCSL9QBMw6au/xADgLqIVvOky8wekPyC2l92m+3+alOA04iASZXYecdHkpC+njq5c8DxIVaTr6+2MyM+RoiLEruXGgtFySApIWU8SeKwbhlAxq1b2HiIrg7IPd38w78JmhMLihw2YduFsPVolCdd+nPIOAlgTObQIpSF7QyKuk/k4Jg3LKh+8I2kV9CMuYOo5qIveJSSxR+7AZaAMdvbBf6ZUzqADCwP9Vt+rk7xYAo4yz5cRImdRCHBMPLaPW5DBAg2K/7+CfBNsa6SGj64bj94J1AGFQGkUL+IEywVNo+RsqvFv0Ifz3EfiqvmRnZ30fBGCypZbD0m8CbjKA6/GISMDS871T5jZD7J7nDb4IxjM/qCb8Ecn91kc5hmRR/41rbnsQNe3tTXnOIBFqWan+RwdvvUhDiydBmdQXhnItsDu2Fn2Lebt4KgjjHTxpY6ll+KB1zkbT7o1pRK1pk2y1fgFZyJo+IEkU23xxO2ojRERIEb+cV8KKcseC+HOTYhdIgBw978A5RVsL1zNFFumETmAMKakYOTKVsfspYPps4mG0MNu1NbTeqHzdUNZKwXPz7kWAOosOVg0AETRPMlAICamFuaAdZ5iAQaTPunpk2KQhTPMWQgDpWg7ThfbVIEqKP3C5uCaMLtNTfcADpMcqycD0pBARtd057pTZGDqJ0o7KWNwLLe52poZRQH+IwHPoTwDlWWXIkjsS+bd9tqPIhMBwklRw5CBOaTtbT1oK0aqvtFbfuCuQgpl1Io1YAR4Q6CrvCNK5EXSWPKkyQJm7YvFepzwVx0MZhZHWBViREJf5Q+YyDMF4NIXkE/qKSqudNUOi7a/p8Qw3r6bkNk+MqrbMwOZcxbw/yLyKu/xrEQV8leisNBwfa40v23KzKIA6ykzzhz5o4oFQgo2Uu+HtWy7SjRfLGHhCBg6BddVr5r8LO/xjEwdBkUS95FwxoaX5QVsm0KgV2aNx4LSeOFcetU0C6kAPkBn8XitYzCOSgBLnGy6TYouF0ZfgM5kAOoWoMBzE5OXFOyFUwiAPa9aWj768xvlEQBwIlQ6NHSGhzMMvBkfYWokKK/rOD+ibYHshC6yq2crDgILMcaMMBh1OWA+TjlgNquHCUg9TskfpGDnb3coC/Y4itSxg5iCYOXFIGwwFv+vZMDn4JB7y1+K0cbOYcBI85WOhChPaAVkW5qAtmAQtxMJBfEOvooV+44aBWtIYJcMA5yUFGfoEu473TXAmPGCMH1JlK8cExCjdSxtemLeIAs+CSRzzjgPbNyHKJAqQw0N7gBUAnxbz13IOdiz8YlgPeFYfkIO/CZNNHFBCZE4gDDAJDaii54YDoCo8YYg6SdwKJkn2KQeawwYtLt+SgUpq+elCuVUS7RstLliC61bSiFzkYDlkUdYWAVEUYMUv8R0PL2XSE/9Emkpg76AQTh5IujrKNG7nSCEgvm5rj2vWh4pJovj4cqus33nLOFKwOG6oPiKLHRwzb3lQaVsfDZsWTy6JeVQX9VR0OF5fKqQSYupGFWbUEdtHOdAL7RmGLqXxo/JKB+algvujYvPQHxvFvMU9vZgUx+wJyYFY8XmvHMDs3MMWjm9dcMgZfAcfKf92ovgfa3qF1Ubp/EnAJy98tBty4/dvFwOPvs/H/FJ4HDw8PDw8PDw8PDw8PDw8PDw8PDw8PDw9n4Sc6gv8BPqzKzwARh84AAAAASUVORK5CYII=" 
								  style="width: 250px; height: 180px;" id="food_poster">
								 </td>
								</tr>
								
								<tr>
									<td width="30%" style="color:gray;">업체명</td>
									<td width="70%"><span id="food_name"></span></td>
								</tr>
							</table>
						</td>
						
					</tr>
					
					
					<tr>
						<td width="30%" height="250">
							<table class="table">
								<tr>
									<td class="table-primary"><h4 class="text-center">시간 정보</h4></td>
								</tr>
							</table>
						</td>
						
						<td width="40%" height="250">
							<table class="table">
								<tr>
									<td class="table-info"><h4 class="text-center">인원 정보</h4></td>
								</tr>
							</table>
						</td>
						
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>