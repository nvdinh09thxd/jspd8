<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@include file="inc/header.jsp"%>

	  <div class="body">
	    <div class="body_resize">
	      <div class="left">
	        <h2>Đăng tin</h2>
	        <form action="#" method="post" id="contactform">
	          <ol>
	            <li>
	              <label for="name">Tên tin*</label>
	              <input id="name" name="name" class="text" />
	            </li>
	            <li>
	              <label for="preview_text">Mô tả*</label>
	              <textarea id="preview_text" name="preview_text" rows="6" cols="50"></textarea>
	            </li>
	            
	            <li>
	              <label for="detail_text">Chi tiết*</label>
	              <textarea id="detail_text" name="detail_text" rows="10" cols="50"></textarea>
	            </li>
	            
	            <li class="buttons">
	              <input type="submit" name="imageField" id="imageField"  value="Đăng tin" class="send" />
	              <div class="clr"></div>
	            </li>
	          </ol>
	        </form>
	      </div>
	      
	<%@include file="inc/right-bar.jsp"%>      
	
	    </div>
	  </div>

  	<%@include file="inc/footer.jsp"%>

