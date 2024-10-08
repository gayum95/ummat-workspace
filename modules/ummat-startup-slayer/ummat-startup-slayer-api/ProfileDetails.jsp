<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ummat.slayer.model.District"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.io.Serializable"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>

<%
	// Retrieve the user ID from the request parameter
	String userIdParam = request.getParameter("userId");

	// Check if the user ID is not null and is a valid Long value
	if (userIdParam != null && userIdParam.matches("\\d+")) {
		long userId = Long.parseLong(userIdParam);

		try {
			// Retrieve user details using UserLocalServiceUtil
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userids = themeDisplay.getUserId();
			User userDetails = UserLocalServiceUtil.getUser(userId);
			
			// Retrieve and format user details
			long UserId = userDetails.getUserId();
			userids = UserId;
			String fullName = userDetails.getFullName();
			String jobTitle = userDetails.getJobTitle();
			
%>

<%
		// Ensure userItems is not null
				if (userDetails != null) {
	%>
<div class="container">
  <div class="profile-header">
    <div class="profile-img">
      <img src="<%=userDetails.getPortraitURL(themeDisplay)%>" width="200" alt="Profile Image">
    </div>
    <div class="profile-nav-info">
      <h3 class="user-name"><%=fullName%> | <%=UserId%> </h3>
      <div class="address">
        <p id="state" class="state">New York,</p>
        <span id="country" class="country">USA.</span>
      </div>

    </div>
  <!--   <div class="profile-option"> -->
     <!--  <div class="notification">
        <i class="fa fa-bell"></i>
        <span class="alert-message">3</span>
      </div> -->
  <!--   </div> -->
  </div>

  <div class="main-bd">
    <div class="left-side">
      <div class="profile-side">
        <p class="mobile-no"><i class="fa fa-phone"></i><%=userDetails.getScreenName() %></p>
        <p class="user-mail"><i class="fa fa-envelope"></i> <%=userDetails.getEmailAddress() %></p>
        <div class="user-bio">
          <h3>Bio</h3>
          <p class="bio">
            Lorem ipsum dolor sit amet, hello how consectetur adipisicing elit. Sint consectetur provident magni yohoho consequuntur, voluptatibus ghdfff exercitationem at quis similique. Optio, amet!
          </p>
        </div>
        <div class="profile-btn">
          <button class="chatbtn" id="chatBtn"><i class="fa fa-comment"></i> Chat</button>

			<script>
			  document.getElementById('chatBtn').addEventListener('click', function() {
			    var chatwootBubble = document.querySelector('.woot--bubble-holder');
			    if (chatwootBubble) {
			      chatwootBubble.click();
			    }
			  });
			</script>
							<script>
				  (function(d,t) {
				    var BASE_URL="https://app.chatwoot.com";
				    var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
				    g.src=BASE_URL+"/packs/js/sdk.js";
				    g.defer = true;
				    g.async = true;
				    s.parentNode.insertBefore(g,s);
				    g.onload=function(){
				      window.chatwootSDK.run({
				        websiteToken: 'L5RTrnMDT1MwN4sCuQaXHEAp',
				        baseUrl: BASE_URL
				      });
				    };
				  })(document,"script");
				</script>
			

          <button class="createbtn" id="Create-post"><i class="fa fa-plus"></i> Request</button>
        </div>
        <div class="user-rating">
          <h3 class="rating">4.5</h3>
          <div class="rate">
            <div class="star-outer">
              <div class="star-inner">
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
                <i class="fa fa-star"></i>
              </div>
            </div>
            <span class="no-of-user-rate"><span>123</span>&nbsp;&nbsp;reviews</span>
          </div>

        </div>
      </div>

    </div>
    <div class="right-side">

      <div class="nav">
        <ul>
          <li onclick="tabs(0)" class="user-post active">Posts</li>
          <li onclick="tabs(1)" class="user-review">Her Partner Preferences</li>
          <li onclick="tabs(2)" class="user-setting"> Settings</li>
        </ul>
      </div>
      <div class="profile-body">
        <div class="profile-posts tab">
          <h1>Your Post</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa quia sunt itaque ut libero cupiditate ullam qui velit laborum placeat doloribus, non tempore nisi ratione error rem minima ducimus. Accusamus adipisci quasi at itaque repellat sed
            magni eius magnam repellendus. Quidem inventore repudiandae sunt odit. Aliquid facilis fugiat earum ex officia eveniet, nisi, similique ad ullam repudiandae molestias aspernatur qui autem, nam? Cupiditate ut quasi iste, eos perspiciatis maiores
            molestiae.</p>
        </div>
        <div class="profile-reviews tab">
          <h1>Her Partner Preferences</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam pariatur officia, aperiam quidem quasi, tenetur molestiae. Architecto mollitia laborum possimus iste esse. Perferendis tempora consectetur, quae qui nihil voluptas. Maiores debitis
            repellendus excepturi quisquam temporibus quam nobis voluptatem, reiciendis distinctio deserunt vitae! Maxime provident, distinctio animi commodi nemo, eveniet fugit porro quos nesciunt quidem a, corporis nisi dolorum minus sit eaque error
            sequi ullam. Quidem ut fugiat, praesentium velit aliquam!</p>
        </div>
        <div class="profile-settings tab">
          <div class="account-setting">
            <h1>Acount Setting</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit omnis eaque, expedita nostrum, facere libero provident laudantium. Quis, hic doloribus! Laboriosam nemo tempora praesentium. Culpa quo velit omnis, debitis maxime, sequi
              animi dolores commodi odio placeat, magnam, cupiditate facilis impedit veniam? Soluta aliquam excepturi illum natus adipisci ipsum quo, voluptatem, nemo, commodi, molestiae doloribus magni et. Cum, saepe enim quam voluptatum vel debitis
              nihil, recusandae, omnis officiis tenetur, ullam rerum.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<%
							} else {
						%>
							<p>User Not Found</p>
							<%
							}
								
									//String maritalStatus = (String) userDetails.getExpandoBridge().getAttribute("maritalStatus");
						%>
<%

		} catch (PortalException e) {
				// Handle exception when user details are not found
	%>


					<%
		}
		} else {
			// Handle case when the provided user ID is not valid
	%>


					<%
		}
	%>
<style>
@import url("https://fonts.googleapis.com/css?family=Poppins&display=swap");
@import url("https://fonts.googleapis.com/css?family=Bree+Serif&display=swap");
/* 
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
} */

/* body {
  background: #e9e9e9;
  overflow-x: hidden;
  padding-top: 90px;
  font-family: "Poppins", sans-serif;
  margin: 0 100px;
} */

.profile-header {
  background: #ccc3fa;
  width: 100%;
  display: flex;
  height: 190px;
  position: relative;
  box-shadow: 0px 3px 4px rgba(0, 0, 0, 0.2);
  border: solid 3px;
  border-color: #fff;
}

.profile-img {
  float: left;
  width: 340px;
  height: 200px;
}

.profile-img img {
  border-radius: 50%;
  height: 230px;
  width: 230px;
  border: 5px solid #fff;
  box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
  position: absolute;
  left: 50px;
  top: 20px;
  z-index: 5;
  background: #fff;
}

.profile-nav-info {
  float: left;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding-top: 60px;
}

.profile-nav-info h3 {
  font-variant: small-caps;
  font-size: 2rem;
  font-family: sans-serif;
  font-weight: bold;
  color: #2a1d6ae5;
}

.profile-nav-info .address {
  display: flex;
  font-weight: bold;
  color: #3a426c;
}

.profile-nav-info .address p {
  margin-right: 5px;
}

.profile-option {
  width: 40px;
  height: 40px;
  position: absolute;
  right: 50px;
  top: 50%;
  transform: translateY(-50%);
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  transition: all 0.5s ease-in-out;
  outline: none;
  background: #e40046;
}

.profile-option:hover {
  background: #fff;
  border: 1px solid #e40046;
}
.profile-option:hover .notification i {
  color: #e40046;
}

.profile-option:hover span {
  background: #e40046;
}

.profile-option .notification i {
  color: #fff;
  font-size: 1.2rem;
  transition: all 0.5s ease-in-out;
}

.profile-option .notification .alert-message {
  position: absolute;
  top: -5px;
  right: -5px;
  background: #fff;
  color: #e40046;
  border: 1px solid #e40046;
  padding: 5px;
  border-radius: 50%;
  height: 20px;
  width: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 0.8rem;
  font-weight: bold;
}

.main-bd {
  width: 100%;
  display: flex;
  padding-right: 15px;
}

.profile-side {
  width: 300px;
  background: #fff;
  box-shadow: 0px 3px 5px rgba(0, 0, 0, 0.2);
  padding: 90px 30px 20px;
  font-family: "Bree Serif", serif;
  margin-left: 10px;
  z-index: 99;
  border: solid 1px;
  border-color: #353658;
}

.profile-side p {
  margin-bottom: 7px;
  color: #4e3a66;
  font-size: 14px;
}

 {
  color: #e7b338;
  margin-right: 10px;
}

.mobile-no i {
  transform: rotateY(180deg);
  color: #e40046;
}

.profile-btn {
  display: flex;
}

button.chatbtn,
button.createbtn {
  border: 0;
  padding: 10px;
  width: 100%;
  border-radius: 3px;
  background: #363476;
  color: #fff;
  font-family: "Bree Serif";
  font-size: 1rem;
  margin: 5px 2px;
  cursor: pointer;
  outline: none;
  margin-bottom: 10px;
  transition: background 0.3s ease-in-out;
  box-shadow: 0px 5px 7px 0px rgba(0, 0, 0, 0.3);
}

button.chatbtn:hover,
button.createbtn:hover {
  background: rgb(255, 237, 87);
}

button.chatbtn i,
button.createbtn i {
  margin-right: 5px;
}

.user-rating {
  display: flex;
}

.user-rating h3 {
  font-size: 2.5rem;
  font-weight: 200;
  margin-right: 5px;
  letter-spacing: 1px;
  color: #4b4688;
}

.user-rating .no-of-user-rate {
  font-size: 0.9rem;
}

.rate {
  padding-top: 6px;
}

.rate i {
  font-size: 0.9rem;
  color: rgba(228, 0, 70, 1);
}

.nav {
  width: 100%;
  z-index: -1;
}

.nav ul {
  display: flex;
  justify-content: space-around;
  list-style-type: none;
  height: 40px;
  background: #fff;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
  padding-right: 150px;
  text-wrap: nowrap;
}

.nav ul li {
  padding: 10px;
  width: 100%;
  cursor: pointer;
  text-align: center;
  transition: all 0.2s ease-in-out;
}

.nav ul li:hover,
.nav ul li.active {
  box-shadow: 0px -3px 0px rgba(35, 50, 133, 0.9) inset;
}

.profile-body {
  width: 100%;
  z-index: -1;
}

.tab {
  display: none;
}

.tab {
  padding: 20px;
  width: 100%;
  text-align: center;
}

@media (max-width: 1100px) {
  .profile-side {
    width: 250px;
    padding: 90px 15px 20px;
  }

  .profile-img img {
    height: 200px;
    width: 200px;
    left: 50px;
    top: 50px;
  }
}

@media (max-width: 900px) {


  .profile-header {
    display: flex;
    height: 100%;
    flex-direction: column;
    text-align: center;
    padding-bottom: 20px;
  }

  .profile-img {
    float: left;
    width: 100%;
    height: 200px;
  }

  .profile-img img {
    position: relative;
    height: 200px;
    width: 200px;
    left: 0px;
  }

  .profile-nav-info {
    text-align: center;
  }

  .profile-option {
    right: 20px;
    top: 75%;
    transform: translateY(50%);
  }

  .main-bd {
    flex-direction: column;
    padding-right: 0;
  }

  .profile-side {
    width: 100%;
    text-align: center;
    padding: 20px;
    margin: 5px 0;
  }

  .profile-nav-info .address {
    justify-content: center;
  }

  .user-rating {
    justify-content: center;
  }
}

@media (max-width: 400px) {
 
  .profile-header h3 {
  }

  .profile-option {
    width: 30px;
    height: 30px;
    position: absolute;
    right: 15px;
    top: 83%;
  }

  .profile-option .notification .alert-message {
    top: -3px;
    right: -4px;
    padding: 4px;
    height: 15px;
    width: 15px;
    font-size: 0.7rem;
  }

  .profile-nav-info h3 {
    font-size: 1.9rem;
  }

  .profile-nav-info .address p,
  .profile-nav-info .address span {
    font-size: 0.7rem;
  }
}
#see-more-bio,
#see-less-bio {
  color: blue;
  cursor: pointer;
  text-transform: lowercase;
}
.tab h1 {
  font-family: "Bree Serif", sans-serif;
  display: flex;
  justify-content: center;
  margin: 20px auto;
}
h3, .h3 {
  font-size: calc(1rem * 1.75);
  color: #4d5381f7;
}
.profile-side p i {
  color: #5b48b8;
  margin-right: 10px;
}
</style>
