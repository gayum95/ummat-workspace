<%@page import="java.util.ArrayList"%>
<%@ include file="../init.jsp"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/matrilist.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<div class="main-div">
<button class="lg-hide" onclick="FilterBar()"><i class="fa-solid fa-bars"></i></button>
<%
	PortletURL informationRenderURL = renderResponse.createRenderURL();
    informationRenderURL.setParameter("jspPage","/Matri/ProfileDetails.jsp" );
    List<District> districtList = new ArrayList<>();
    List<Region> regionsForCountry = new ArrayList<>();
    
    if(Validator.isNotNull(request.getAttribute("districtLists"))){
    	districtList = (List) request.getAttribute("districtLists");
    	
    }
    
    if(Validator.isNotNull(request.getAttribute("regionLists"))){
    	regionsForCountry =  (List)request.getAttribute("regionLists");
    }
    
    List<Long> excludedProfileIds = List.of();
	List<User> currentProfiles = (List) request.getAttribute("currentProfilesSearch");
	if (Validator.isNull(currentProfiles)) {
		currentProfiles = (List) request.getAttribute("currentProfiles");
	}
	  //  List<MatriUser> matriUserList = MatriUserLocalServiceUtil.getMatriUsers(-1, -1);
      List<MatriUser> matriUserList = (List) request.getAttribute("matriUserList");
    System.out.println("Size of matriUserList: " + matriUserList.size());
    
	
	%>

<div class="first-div" id="filter-bar">
  <div class="logo">Find Your Partner</div>
    <input type="text"  id="searchProfile" placeholder="Search Profile ID..." />
    <h3>Gender Filter</h3>
    <div class="filter-checkboxes">
      <label><input type="checkbox" class="genderCheckbox" value="all" /> All</label>
    <label><input type="checkbox" class="genderCheckbox" value="male" /> Male</label>
    <label><input type="checkbox" class="genderCheckbox" value="female" /> Female</label>
    
     <input type="text" id="genderhidden" value="" />
    <input type="text" id="jamathhidden" value="" />
    <input type="hidden" id="statehidden" value="" />
    <input type="hidden" id=disthidden value="" />
    <input type="hidden" id="areahidden" value="" /> 
    <input type="hidden" id="useridhidden" value="" /> 
  
</div>
    <h3>Select to Jamath</h3>
    <select id="typeSelect">
      <option value="All">All Jamath</option>
      <option value="Thowheed Jamath"> Thowheed Jamath</option>
      <option value=" Sunnathwal Jamath"> Sunnathwal Jamath</option>
      <option value="TNTJ"> TNTJ</option>
      <option value="Others">Others</option>
    </select>
		<h3>Location Filter</h3>
		<div class="fil1">
	<select name="state" class="form-control" label="Select state" id="selectedState">
    <option value="">Select State</option>
    <%
									for (Region stateListItem : regionsForCountry ) {	    
							     	%>
									<option value="<%=stateListItem.getRegionCode()%>"><%=stateListItem.getName()%></option>
									<%
									 }
                                    %>
                                    <script>
    $("#selectedState").on("change", selectedState);

    function selectedState() {
        var stateCode = $("#selectedState").val();
        Liferay.Service(
        		'/district/get-by-region-code', // Assuming this service endpoint exists
            {
            	regionCode: stateCode
            },
            function(data) {
                var districtList = data;
                $('#selectedDistrict').empty();
             //   $('#selectedDistrict').append('<option value="">Select District</option>');
                for (var i in districtList) {
                    $('#selectedDistrict').append("<option value='" + districtList[i].districtId + "'>" + districtList[i].name + "</option>");
                }
            }
        );
    }
</script>
</select>
			</div>
			<div class="fil2">
		<select name="district" class="form-control" label="District" id="selectedDistrict" required="true">
    <option value="">Select District</option>

<script>
								$("#selectedDistrict").on("change",
										selectedDistrict);
								function selectedDistrict() {
									var districtId = $("#selectedDistrict")
											.val();
									Liferay
											.Service(
													'/locality/get-locality-by-district-id',
													{
														districtId : districtId
													},
													function(data) {
														var areaNameList = data;
														$('#availableLocality')
																.empty();
														for ( var i in areaNameList) {
															$(
																	'#availableLocality')
																	.append(
																			"<option value='"+ areaNameList[i].name +"'>"
																					+ areaNameList[i].name
																					+ "</option>");
														}
													});
								}
							</script>
							</select>
				</div>
			<div class="fil3">
<select name="area" class="form-control" label="Area" id="availableLocality" onchange="selectArea(this)">
    <option value="">Select Area</option>
</select>
	</div>
	<div class="language-selection">
    <label for="languageSelect">Select Language:</label>
    <select id="languageSelect">
        <option value="en">English</option>
        <option value="ta">Tamil</option>
        <option value="ml">Malayalam</option>
        <option value="hi">Hindi</option>
    </select>
</div>
	<aui:script>
AUI().use('aui-base', 'aui-io-request', function(A) {
  <!--   // Function to translate text -->
    async function translateText(text, targetLanguage) {
        const url = 'https://google-translate1.p.rapidapi.com/language/translate/v2';
        const options = {
            method: 'POST',
            headers: {
                'content-type': 'application/x-www-form-urlencoded',
                'Accept-Encoding': 'application/gzip',
                'X-RapidAPI-Key': '2bf5227206mshfff49a942d618c8p18b0fbjsn80e0dd733f58',
                'X-RapidAPI-Host': 'google-translate113.p.rapidapi.com'
            },
            body: new URLSearchParams({
                q: text,
                target: targetLanguage
            })
        };

        try {
            const response = await fetch(url, options);
            const result = await response.json();
            if (result.data && result.data.translations) {
                return result.data.translations[0].translatedText;
            } else {
                return text; // Fallback to original text if translation fails
            }
        } catch (error) {
            console.error(error);
            return text; // Fallback to original text if API request fails
        }
    }

    <!-- // Event listener for language selection -->
    A.one('#languageSelect').on('change', function() {
        const selectedLanguage = this.get('value');
        A.all('.translatable').each(async function(node) {
            const originalText = node.getAttribute('data-text');
            const translatedText = await translateText(originalText, selectedLanguage);
            node.setHTML(translatedText);
        });
    });
});
</aui:script>
</div>

<div class="second-div">
    <ul class="card-list pager" id="userList">
        <% 
        
        
            
            int pageSize = 10; 
            int totalPages = (int) Math.ceil((double) matriUserList.size() / pageSize);
            int currentPage = ParamUtil.getInteger(request, "page", 1);
            
         
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, matriUserList.size());

          
            List<MatriUser> currentPageUsers = matriUserList.subList(startIndex, endIndex);
            for (MatriUser matrimonyUser : currentPageUsers) {
                long userId = matrimonyUser.getUserId();
                User userItems = UserLocalServiceUtil.fetchUser(userId);
                
                
                
                // Check if the user ID is not excluded
                if (Validator.isNotNull(userItems) && !excludedProfileIds.contains(userId)) {
                	
        %>
        <li class="card-list-item">
            <div class="card">
                <div class="card-image">
                    <img src="<%= userItems.getPortraitURL(themeDisplay) %>" alt="placeholder" />
                </div>
                <div class="card-content">
                    <h3 class="card-heading">ProfileId <%=userItems.getUserId()%></h3>
                    <div class="profile-details">
                        <strong>NAME:</strong> <span class="translatable" data-text="<%= userItems.getFullName() %>"><%= userItems.getFullName() %></span> <br>
                        <strong>JOB:</strong> <span class="translatable" data-text="<%= userItems.getJobTitle() %>"><%= userItems.getJobTitle() %></span><br>
                        <strong>Jamath:</strong> <span class="translatable" data-text="<%= matrimonyUser.getJamath() %>"><%= matrimonyUser.getJamath() %><br>
                        <%-- Format the date of profile creation --%>
                        <% 
                            Date createDate = userItems.getCreateDate();
                            
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String formattedDate = dateFormat.format(createDate); 
                        %>
                        <strong>CREATED DATE:</strong><%=formattedDate %> <br>
                    </div>
                    <%-- Set parameter for user details URL --%>
                      <% 
                     
                        informationRenderURL.setParameter("userId",String.valueOf(userItems.getUserId())); 
                    		
                    %>
                   
                </div>
                 <button class="btn btn-sm primary" onclick="window.location.href='<%= informationRenderURL %>'">My Details</button>
            </div>
        </li>
        <% 
                } 
            }
        %>
    </ul>

     <!-- Pagination -->
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <%-- Previous page button --%>
            <%
                PortletURL previousPageURL = renderResponse.createRenderURL();
                previousPageURL.setParameter("page", String.valueOf(Math.max(currentPage - 1, 1)));
            %>
            <li class="page-item <%= currentPage == 1 ? "disabled" : "" %>">
                <a class="page-link" href="<%= previousPageURL.toString() %>">Previous</a>
            </li>

            <%-- Page numbers --%>
            <% for (int i = 1; i <= totalPages; i++) { %>
                <%
                    PortletURL pageURL = renderResponse.createRenderURL();
                    pageURL.setParameter("page", String.valueOf(i));
                %>
                <li class="page-item <%= currentPage == i ? "active" : "" %>">
                    <a class="page-link" href="<%= pageURL.toString() %>"><%= i %></a>
                </li>
            <% } %>

            <%-- Next page button --%>
            <%
                PortletURL nextPageURL = renderResponse.createRenderURL();
                nextPageURL.setParameter("page", String.valueOf(Math.min(currentPage + 1, totalPages)));
            %>
            <li class="page-item <%= currentPage == totalPages ? "disabled" : "" %>">
                <a class="page-link" href="<%= nextPageURL.toString() %>">Next</a>
            </li>
        </ul>
    </nav>
</div>

<aui:script>
AUI().use('aui-base', 'aui-io-request', function(A) {
  <!--    Ensure the document is ready before binding the change event -->

     A.all('.genderCheckbox').on('change', function() {
        var selectedGenders = [];
        var allChecked = false;

        A.all('.genderCheckbox:checked').each(function(node) {
            var value = node.get('value');
            if (value === 'all') {
                allChecked = true;
            } else {
                selectedGenders.push(value);
            }
        });

        // If "All" is checked, ignore other selections
        if (allChecked) {
            selectedGenders = ['all'];
        }
       alert(selectedGenders);
		var genderhidden = document.getElementById("genderhidden");
        // Set the value of the hidden field
        genderhidden.value = selectedGenders;
        filterUsersByGender();
    });

	A.all('#typeSelect').on('change', function() {
	var selectElement = document.getElementById("typeSelect");

        // Get the selected value
        var selectedValue = selectElement.value;
		var jamathhidden = document.getElementById("jamathhidden");
        // Set the value of the hidden field
        jamathhidden.value = selectedValue;
        filterUsersByGender();
    });
    <!-- userid -->
    A.all('#searchProfile').on('change', function() {
	var selectElement = document.getElementById("searchProfile");

        // Get the selected value
        var selectedValue = selectElement.value;
		var useridhidden = document.getElementById("useridhidden");
        // Set the value of the hidden field
        useridhidden.value = selectedValue;
        filterUsersByGender();
    });
    
    	A.all('#selectedState').on('change', function() {
	var selectElement = document.getElementById("selectedState");

        // Get the selected value
        var selectedValue = selectElement.value;
		var statehidden = document.getElementById("statehidden");
        // Set the value of the hidden field
        statehidden.value = selectedValue;
        filterUsersByGender();
    });
    
    	A.all('#selectedDistrict').on('change', function() {
	var selectElement = document.getElementById("selectedDistrict");

        // Get the selected value
        var selectedValue = selectElement.value;
		var disthidden = document.getElementById("disthidden");
        // Set the value of the hidden field
        disthidden.value = selectedValue;
        filterUsersByGender();
    });
    
    	A.all('#availableLocality').on('change', function() {
	var selectElement = document.getElementById("availableLocality");

        // Get the selected value
        var selectedValue = selectElement.value;
		var areahidden = document.getElementById("areahidden");
        // Set the value of the hidden field
        areahidden.value = selectedValue;
        filterUsersByGender();
    });

    function filterUsersByGender() {
      <!--   // Resource URL with the correct ID -->
        var resourceURL = '<portlet:resourceURL id="Gnder" />';
		 var gender = document.getElementById("genderhidden").value;
		 var jamadh = document.getElementById("jamathhidden").value;
		 var state = document.getElementById("statehidden").value;
		 var dist = document.getElementById("disthidden").value;
		 var area = document.getElementById("areahidden").value;
		 var profileid = document.getElementById("useridhidden").value;

		<!-- // var gen = genders.join(','); -->
		// var gen =Array.from(gender);
//Array.from(str);
		 var params = gender+'|'+jamadh+'|'+state+'|'+dist+'|'+area+'|'+profileid;
			alert(params);
        A.io.request(resourceURL, {
            dataType: 'json',
            method: 'GET',
            data: { genders:params, },
            on: {
                success: function() {
                    var response = this.get('responseData');
                    var filteredUsers = response.currentProfiles;
                    var userListHtml = '';

                    // Iterate over filtered users and construct HTML
                    A.Array.each(filteredUsers, function(user) {
                        userListHtml += '<li class="card-list-item">' +
                            '<div class="card">' +
                            '<div class="card-image">' +
                            '<img src="' + user.portraitURL + '" alt="placeholder" />' +
                            '</div>' +
                            '<div class="card-content">' +
                            '<h3 class="card-heading">' + user.userId + '</h3>' +
                            '<div class="profile-details">' +
                            '<strong>NAME:</strong> ' + user.fullName + '<br>' +
                            '<strong>JOB:</strong> ' + user.jobTitle + '<br>' +
                            '<strong>Jamath:</strong> ' +  user.Jamath + '<br>' +
                            <!-- '<strong>Gender:</strong> ' + user.gender + '<br>' + -->
                            '<strong>PROFILE CREATED:</strong> ' + user.createDate + '<br>' +
                            '</div>' +
                            '<button class="btn btn-sm primary">' +
                           '<a href="' + user.informationRenderURL + '">My Details</a>' +
                            '</button>' +
                            '</div>' +
                            '</li>';
                    });

                    // Update the user list in the DOM
                    A.one('#userList').setHTML(userListHtml);
                },
                failure: function() {
                    console.error('Error fetching filtered users');
                }
            }
        });
    }
});
</aui:script>




<script>

/*----Mobile-View-FilterBar-------*/

function FilterBar() {
	var filterBar = document.getElementById('filter-bar');
	filterBar.classList.toggle('active');    

}

</script>










