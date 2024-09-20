<%@ include file="init.jsp" %>

<%
String logoURL = request.getContextPath() +"/images/profile.png";
Map<String, String> images = (Map<String, String>) request.getAttribute("images");
%>

<portlet:actionURL var="uploadImageURL" name="uploadImages"></portlet:actionURL>

<div class="container">
		<aui:form name="uploadImages" method="post" enctype="multipart/form-data" action="<%= uploadImageURL.toString() %>">
			<aui:input name="count" type="hidden" value="3"/>
			<div class="row">
				<div class="col-md-4">
					<%
						if(Validator.isNotNull(images.get(UmmatMatriImagesUploadPortletKeys.RENDER_IMAGE_MAP_KEY+"0"))){ 
							String image = images.get(UmmatMatriImagesUploadPortletKeys.RENDER_IMAGE_MAP_KEY+"0");
					%>
						<img id="image0" src="<%= image.split(UmmatMatriImagesUploadPortletKeys.VALUES_DIVIDER)[0] %>" class="matriImages">
						<aui:input name="dlFileEntry0" type="hidden" value="<%= image.split(UmmatMatriImagesUploadPortletKeys.VALUES_DIVIDER)[1] %>"/>
					<%}else{ %>
						<img id="image0" src="<%= logoURL %>" class="matriImages" />
						<aui:input name="dlFileEntry0" type="hidden" value="0"/>
					<%} %>
					
					<aui:input name="image0" type="file" onChange="readURL(this,'image0')" label="image1">
						<aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
					</aui:input>
					
				</div>
				
				<div class="col-md-4">
					<%
						if(Validator.isNotNull(images.get(UmmatMatriImagesUploadPortletKeys.RENDER_IMAGE_MAP_KEY+"1"))){ 
							String image = images.get(UmmatMatriImagesUploadPortletKeys.RENDER_IMAGE_MAP_KEY+"1");
					%>
						<img id="image1" src="<%= image.split(UmmatMatriImagesUploadPortletKeys.VALUES_DIVIDER)[0] %>" class="matriImages">
						<aui:input name="dlFileEntry1" type="hidden" value="<%= image.split(UmmatMatriImagesUploadPortletKeys.VALUES_DIVIDER)[1] %>"/>
					<%}else{ %>
						<img id="image1" src="<%= logoURL %>" class="matriImages" />
						<aui:input name="dlFileEntry1" type="hidden" value="0"/>
					<%} %>
					<aui:input name="image1" type="file" onChange="readURL(this,'image1')" label="image2">
						<aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
					</aui:input>
				</div>
				
				<div class="col-md-4">
					<%
						if(Validator.isNotNull(images.get(UmmatMatriImagesUploadPortletKeys.RENDER_IMAGE_MAP_KEY+"2"))){ 
							String image = images.get(UmmatMatriImagesUploadPortletKeys.RENDER_IMAGE_MAP_KEY+"2");
					%>
						<img id="image2" src="<%= image.split(UmmatMatriImagesUploadPortletKeys.VALUES_DIVIDER)[0] %>" class="matriImages">
						<aui:input name="dlFileEntry2" type="hidden" value="<%= image.split(UmmatMatriImagesUploadPortletKeys.VALUES_DIVIDER)[1] %>"/>
					<%}else{ %>
						<img id="image2" src="<%= logoURL %>" class="matriImages" />
						<aui:input name="dlFileEntry2" type="hidden" value="0"/>
					<%} %>
					<aui:input name="image2" type="file" onChange="readURL(this,'image2')" label="image3">
						<aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
					</aui:input>
				</div>
			</div>
			<aui:button type="submit" value="Upload"></aui:button>
			
		</aui:form>
</div>


<script>
function readURL(input,displayImgId) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#'+displayImgId)
                .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
</script>