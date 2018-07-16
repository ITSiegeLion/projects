/**
 * 
 */

$(function(){	
	var initUrl = '/store/shopadmin/getshopinitinfo';
	var registerShopUrl = '/store/shopadmin/registershop';
	getShopInitInfo();
	//从后台获取区域列表、商铺分类列表数据填充到下拉列表中
	function getShopInitInfo(){
		$.getJSON(initUrl,function(data){
			if(data.success){
				var tempHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item,index){
					tempHtml += '<option data-id="'+item.shopCategoryId+'">'
					+item.shopCategoryName+'</option>';
				})
				data.areaList.map(function(item,index){
					tempAreaHtml += '<option data-id="'+item.areaId+'">'
					+item.areaName+'</option>';
				})
				$('#shop-category').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		});
	};
	
	$('#submit').click(function(){
		var shop = {};
		shop.shopName = $('#shop-name').val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();
		// 选择选定好的店铺类别
		shop.shopCategory = {
			shopCategoryId : $('#shop-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		// 选择选定好的区域信息
		shop.area = {
			areaId : $('#area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		var shopImg = $('#shop-img')[0].files[0];
		var formData = new FormData();
		formData.append('shopImg',shopImg);
		formData.append('shopStr',JSON.stringify(shop));
		var kaptcha = $('#j_kaptcha').val();
		if(!kaptcha){
			$.toast("请输入验证码");
			return;
		}		
		formData.append('kaptcha',kaptcha);
		$.ajax({
			url : registerShopUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('提交成功！');
				} else {
					$.toast('提交失败！' + data.errMsg);
				}
				// 点击验证码图片的时候，注册码会改变
				$('#captcha_img').click();
			}
		});
	});
	
	
})