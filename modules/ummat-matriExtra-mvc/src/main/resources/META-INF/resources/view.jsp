<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Base64"%>
<%@page import="ummat.matriExtra.slayer.service.MatriUserImageLocalServiceUtil"%>
<%@page import="ummat.matriExtra.slayer.model.MatriUserImage"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="./init.jsp" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<portlet:actionURL name="uploadImage" var="uploadImagesURL" />
<html>
<head>
    <title>Upload Images</title>
    <!-- Use Liferay’s theme, which includes Bootstrap -->
    <style>
        /* Include your custom CSS here */
        .image-upload-container {
            display: grid;
            grid-template-areas: 'img-u-one img-u-two img-u-three img-u-four img-u-five img-u-six';
            gap: 10px;
        }
        .image-upload-one, .image-upload-two, .image-upload-three, .image-upload-four, .image-upload-five, .image-upload-six {
            display: flex;
            justify-content: center;
        }
        .center {
            display: inline;
            margin: 3px;
        }
        .form-input {
            width: 100px;
            padding: 3px;
            background: #fff;
            border: 2px dashed dodgerblue;
        }
        .form-input input {
            display: none;
        }
        .form-input label {
            display: block;
            width: 100px;
            height: auto;
            max-height: 100px;
            background: #333;
            border-radius: 10px;
            cursor: pointer;
        }
        .form-input img {
            width: 100px;
            height: 100px;
            margin: 2px;
            opacity: .4;
        }
        .imgRemove {
            position: relative;
            bottom: 114px;
            left: 68%;
            background-color: transparent;
            border: none;
            font-size: 30px;
            outline: none;
        }
        .imgRemove::after {
            content: ' \21BA';
            color: #fff;
            font-weight: 900;
            border-radius: 8px;
            cursor: pointer;
        }
        .small {
            color: #fff;
        }
        @media only screen and (max-width: 700px) {
            .image-upload-container {
                grid-template-areas: 'img-u-one img-u-two img-u-three'
                                     'img-u-four img-u-five img-u-six';
            }
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h4>Upload Images</h4>
        </div>
        <div class="card-body">
            <form action="<%= uploadImagesURL.toString() %>/image/upload" method="post" enctype="multipart/form-data">
                <div class="image-upload-container">
                  <%--    <input type="hidden" name="userId" value="<%= ParamUtil.getLong(request, "userId") %>" />
        <input type="hidden" name="matriUserId" value="<%= ParamUtil.getLong(request, "matriUserId") %>" /> --%>
                 <div class="form-group">
                    <label for="userName">User Name</label>
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="User Name" required />
                </div>
                <input type="hidden" name="userId" value="40918" />
                <input type="hidden" name="matriUserId" value="40924" />
                    <div class="image-upload-one">
                        <div class="center">
                            <div class="form-input">
                                <label for="file-ip-1">
                                    <img id="file-ip-1-preview" src="https://i.ibb.co/ZVFsg37/default.png" alt="Image Preview">
                                    <button type="button" class="imgRemove" onclick="myImgRemove(1)"></button>
                                </label>
                                <input type="file" name="imageOne" id="file-ip-1" accept="image/*" onchange="showPreview(event, 1);">
                            </div>
                            <small class="small">Use the &#8634; icon to reset the image</small>
                        </div>
                    </div>
                    <div class="image-upload-two">
                        <div class="center">
                            <div class="form-input">
                                <label for="file-ip-2">
                                    <img id="file-ip-2-preview" src="https://i.ibb.co/ZVFsg37/default.png" alt="Image Preview">
                                    <button type="button" class="imgRemove" onclick="myImgRemove(2)"></button>
                                </label>
                                <input type="file" name="imageTwo" id="file-ip-2" accept="image/*" onchange="showPreview(event, 2);">
                            </div>
                            <small class="small">Use the &#8634; icon to reset the image</small>
                        </div>
                    </div>
                    <div class="image-upload-three">
                        <div class="center">
                            <div class="form-input">
                                <label for="file-ip-3">
                                    <img id="file-ip-3-preview" src="https://i.ibb.co/ZVFsg37/default.png" alt="Image Preview">
                                    <button type="button" class="imgRemove" onclick="myImgRemove(3)"></button>
                                </label>
                                <input type="file" name="imageThree" id="file-ip-3" accept="image/*" onchange="showPreview(event, 3);">
                            </div>
                            <small class="small">Use the &#8634; icon to reset the image</small>
                        </div>
                    </div>
                    <div class="image-upload-four">
                        <div class="center">
                            <div class="form-input">
                                <label for="file-ip-4">
                                    <img id="file-ip-4-preview" src="https://i.ibb.co/ZVFsg37/default.png" alt="Image Preview">
                                    <button type="button" class="imgRemove" onclick="myImgRemove(4)"></button>
                                </label>
                                <input type="file" name="imageFour" id="file-ip-4" accept="image/*" onchange="showPreview(event, 4);">
                            </div>
                            <small class="small">Use the &#8634; icon to reset the image</small>
                        </div>
                    </div>
                     </div>
                <button type="submit" class="btn btn-primary mt-3">Upload</button>
            </form>
        </div>
    </div>
</div>
<!-- Liferay's required scripts are typically already included in the Liferay theme, but you can include them here if needed -->
<%-- <script src="<%= themeDisplay.getPathThemeJs() %>/jquery.min.js"></script>
<script src="<%= themeDisplay.getPathThemeJs() %>/bootstrap.bundle.min.js"></script> --%>

<script>
    function showPreview(event, number) {
        if(event.target.files.length > 0) {
            let src = URL.createObjectURL(event.target.files[0]);
            let preview = document.getElementById("file-ip-" + number + "-preview");
            preview.src = src;
            preview.style.display = "block";
        } 
    }

    function myImgRemove(number) {
        document.getElementById("file-ip-" + number + "-preview").src = "https://i.ibb.co/ZVFsg37/default.png";
        document.getElementById("file-ip-" + number).value = null;
    }
</script>
<%-- <p>Display Images</p>
    <%
    // Method to convert Blob to byte[]
    byte[] blobToByteArray(Blob blob) throws IOException, SQLException {
        if (blob == null) {
            return new byte[0]; // Return empty array if blob is null
        }
        try (InputStream inputStream = blob.getBinaryStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }

    long matriImageId = ParamUtil.getLong(request, "matriImageId");
    MatriUserImage matriUserImage = MatriUserImageLocalServiceUtil.getMatriUserImage(matriImageId);
    if (matriUserImage != null) {
        Blob blobImageOne = matriUserImage.getImageOne();
        Blob blobImageTwo = matriUserImage.getImageTwo();
        Blob blobImageThree = matriUserImage.getImageThree();
        Blob blobImageFour = matriUserImage.getImageFour();

        byte[] imageOne = blobToByteArray(blobImageOne);
        byte[] imageTwo = blobToByteArray(blobImageTwo);
        byte[] imageThree = blobToByteArray(blobImageThree);
        byte[] imageFour = blobToByteArray(blobImageFour);
%>
    <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(imageOne) %>" alt="Image One" /><br/>
    <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(imageTwo) %>" alt="Image Two" /><br/>
    <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(imageThree) %>" alt="Image Three" /><br/>
    <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(imageFour) %>" alt="Image Four" /><br/>
    <%
        }
    %> --%>
</body>
</html>