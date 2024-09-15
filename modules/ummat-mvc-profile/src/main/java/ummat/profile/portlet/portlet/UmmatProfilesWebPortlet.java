package ummat.profile.portlet.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.ummat.slayer.model.District;
import com.ummat.slayer.service.DistrictLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ummat.profile.portlet.constants.UmmatProfilesWebPortletKeys;
import ummat_startup_details.model.MatriUser;
import ummat_startup_details.service.MatriUserLocalService;
import ummat_startup_details.service.MatriUserLocalServiceUtil;

/**
 * @author Rasheed
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=UmmatProfilesWeb",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/Matri/Profilelist.jsp",
		"javax.portlet.name=" + UmmatProfilesWebPortletKeys.MATRI_PROFILE_LIST,
		"javax.portlet.resource-bundle=content.Language", "com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UmmatProfilesWebPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Set<User> currentProfileSet = new HashSet<>();
		currentProfileSet.addAll(UserLocalServiceUtil.getUsers(-1, -1));
		List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserUserGroups(themeDisplay.getUserId());
		for (UserGroup userGroupItem : userGroups) {
			List<User> users = UserLocalServiceUtil.getUserGroupUsers(userGroupItem.getUserGroupId());
			for (User userItem : users) {
				currentProfileSet.add(userItem);
				currentProfileSet.addAll(users);

			}
		}
		List<User> currentProfileList = new ArrayList<>(currentProfileSet);
		List<MatriUser> matriUserList = MatriUserLocalServiceUtil.getMatriUsers(-1, -1);
		List<District> districts = DistrictLocalServiceUtil.getDistricts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("districtLists", districts);
		renderRequest.setAttribute("currentProfiles", currentProfileList);
		renderRequest.setAttribute("matriUserList", matriUserList);
		String countryCode = "IN";
		Country country = null;
		try {
			country = CountryLocalServiceUtil.getCountryByA2(20096, countryCode);
		} catch (PortalException e) {

			e.printStackTrace();
			renderRequest.setAttribute("error", "Error fetching country: " + e.getMessage());
		}

		if (country != null) {
			long countryId = country.getCountryId();
			DynamicQuery dynamicQuery = RegionLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(RestrictionsFactoryUtil.eq("countryId", countryId));
			List<Region> regions = RegionLocalServiceUtil.dynamicQuery(dynamicQuery);
			renderRequest.setAttribute("regionLists", regions);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		System.out.println("Inside serve resource------>>>");
		try {
			if ("Gnder".equalsIgnoreCase(resourceRequest.getResourceID())) {
				String filterParam = ParamUtil.getString(resourceRequest, "genders", "");

				System.out.println(filterParam);
				filterParam = filterParam.replace("|", "| ");
				String[] params = filterParam.split("\\|");
				System.out.println("params: " + Arrays.toString(params));
				// logger.debug("params: " + Arrays.toString(params));
				String gen = params[0].trim() + ",";
				String[] genders = gen.split(",");
				// System.out.println("Genders: " + Arrays.toString(genders));
				logger.info("Genders: ====> 1 " + Arrays.toString(genders));
				String jamadh = params[1].trim();
				String state = params[2].trim();
				String dist = params[3].trim();
				Long distId = 0L;
				if (!dist.isEmpty()) {
					try {
						distId = Long.parseLong(dist);
					} catch (NumberFormatException e) {
						System.out.println("Invalid dist ID: " + dist);
					}
				}

				String area = params[4].trim();

				// search profile id

				String profile = params[5].trim();
				Long profileid = 0L;
				if (!profile.isEmpty()) {
					try {
						profileid = Long.parseLong(profile);
					} catch (NumberFormatException e) {
						System.out.println("Invalid profileid ID: " + profile);
					}
				}
				logger.info("jamadh: " + jamadh);
				logger.info("state: " + state);
				logger.info("dist: " + dist);
				logger.info("area: " + area);
				logger.info("profileid: " + profileid);

				List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
				System.out.println("Number of users: " + users.size()); // Print the size of the users list

				List<User> filteredUsers = new ArrayList<>();
				List<MatriUser> stateFilterUserList = null;
				List<MatriUser> distFilterUserList = null;
				List<MatriUser> areaFilterUserList = null;
				List<MatriUser> jamathFilterUserList = null;

				List<Long> excludedProfileIds = Arrays.asList(33847L, 33874L, 33880L, 40831L, 20099L, 20123L, 20127L,
						112583L, 112610L, 112616L);// Define

				List<MatriUser> matriAllUsers = MatriUserLocalServiceUtil.getMatriUsers(-1, -1);

				Map<Object, List<MatriUser>> stateMap = matriAllUsers.stream()
						.collect(Collectors.groupingBy(u -> u.getState()));

				// System.out.println("State Map " + stateMap);

				Map<Object, List<MatriUser>> distMap = matriAllUsers.stream()
						.collect(Collectors.groupingBy(u -> u.getDistrict()));
				// System.out.println("distMap " + distMap);

				Map<String, List<MatriUser>> areaMap = matriAllUsers.stream()
						.collect(Collectors.groupingBy(u -> u.getArea()));
				// System.out.println("areaMap " + areaMap);

				Map<String, List<MatriUser>> jamathMap = matriAllUsers.stream()
						.collect(Collectors.groupingBy(u -> u.getJamath()));
				// System.out.println("jamathMap " + jamathMap);

				if (state != null) {
					System.out.println(" State filtering is executing ");
					stateFilterUserList = (List<MatriUser>) stateMap.get(state);
				}

				if (distId != 0) {
					System.out.println(" District filtering is executing ");
					distFilterUserList = (List<MatriUser>) stateMap.get(distId);
				}

				if (area != null && !area.isEmpty()) {
					System.out.println("area filtering is executing ");
					areaFilterUserList = areaMap.get(area);
				}

				if (jamadh != null && !jamadh.isEmpty()) {
					System.out.println("Jamath filtering is executing ");
					jamathFilterUserList = jamathMap.get(jamadh);
				}

				boolean matchesStateFilter = stateFilterUserList == null;
				boolean matchesDistFilter = distFilterUserList == null;
				boolean matchesJamathFilter = jamathFilterUserList == null;
				boolean matchesGenderFilter = false;

				for (User user : users) {
					if (excludedProfileIds.contains(user.getUserId())) {
						continue; // Skip the users with excluded IDs
					}
					/*
					 * int Profileloopcount = 0; Profileloopcount++;
					 */
					/*
					 * boolean matchesStateFilter = stateFilterUserList == null; boolean
					 * matchesDistFilter = distFilterUserList == null; boolean matchAreaFilter =
					 * areaFilterUserList == null; boolean matchesJamathFilter =
					 * jamathFilterUserList == null; boolean matchesGenderFilter = false;
					 */

					// Check single state filter
					if (stateFilterUserList != null) {
						for (MatriUser muser : stateFilterUserList) {
							if (muser.getUserId() == user.getUserId()) {
								filteredUsers.add(user);
							}
						}
					}

					// Check district filter
					if (distFilterUserList != null) {
						for (MatriUser muser : distFilterUserList) {
							if (muser.getUserId() == user.getUserId()) {
								if (muser.getDistrict() == Long.parseLong(dist)) {
									filteredUsers.add(user);
								}

							}
						}
					}

					// check area filter
					if (areaFilterUserList != null) {
						for (MatriUser muser : areaFilterUserList) {
							if (muser.getUserId() == user.getUserId()) {
								filteredUsers.add(user);
								break;
							}
						}
					}

					/*
					 * // Check gender filter boolean isMale = user.isMale(); String userGender =
					 * isMale ? "male" : "female"; boolean genderFilterPassed =
					 * Arrays.asList(genders).contains("all") ||
					 * Arrays.asList(genders).contains(userGender);
					 * 
					 * // Check jamath filter
					 * 
					 * boolean jamathFilterPassed = false; if (jamathFilterUserList != null) {
					 * jamathFilterPassed = jamathFilterUserList.stream() .anyMatch(muser ->
					 * muser.getUserId() == user.getUserId()); } else if (jamadh.equals("Others")) {
					 * List<String> explicitlyListedJamaths = Arrays.asList("Thowheed Jamath",
					 * "Sunnathwal Jamath", "TNTJ"); jamathFilterPassed = matriAllUsers.stream()
					 * .anyMatch(muser -> !explicitlyListedJamaths.contains(muser.getJamath()) &&
					 * muser.getUserId() == user.getUserId()); } else if (jamadh.equals("All")) {
					 * jamathFilterPassed = true; }
					 * 
					 * boolean jamathFilterPassed = false;
					 * 
					 * // Check if jamathFilterUserList is not null and contains the user if
					 * (jamathFilterUserList != null) { jamathFilterPassed =
					 * jamathFilterUserList.stream() .anyMatch(muser -> muser.getUserId() ==
					 * user.getUserId()); } else if ("Others".equals(jamadh)) {
					 * 
					 * List<String> explicitlyListedJamaths = Arrays.asList("Thowheed Jamath",
					 * "Sunnathwal Jamath", "TNTJ"); jamathFilterPassed = matriAllUsers.stream()
					 * .anyMatch(muser -> !explicitlyListedJamaths.contains(muser.getJamath()) &&
					 * muser.getUserId() == user.getUserId()); } else if ("All".equals(jamadh)) { //
					 * If jamadh is "All", all users pass the jamath filter jamathFilterPassed =
					 * true; } else { // Check if jamadh is a specific value and matches the user's
					 * jamath jamathFilterPassed = user..equals(jamadh); }
					 * 
					 * 
					 * 
					 * 
					 * 
					 * // Combine gender and jamath filter logic
					 * 
					 * if (genderFilterPassed && jamathFilterPassed) { filteredUsers.add(user);
					 * System.out.println("gender and jamath filter executed"); } else if
					 * (genderFilterPassed && !jamathFilterPassed) { filteredUsers.add(user);
					 * System.out.println("gender filter executed"); } else if (!genderFilterPassed
					 * && jamathFilterPassed) { filteredUsers.add(user);
					 * System.out.println("jamath filter executed"); }
					 * 
					 * 
					 * if (genderFilterPassed && jamathFilterPassed) { filteredUsers.add(user);
					 * System.out.println("Gender and Jamath filter executed: " + user); break; }
					 * else if (genderFilterPassed) { filteredUsers.add(user);
					 * System.out.println("Gender filter executed: " + user); } else if
					 * (jamathFilterPassed) { filteredUsers.add(user);
					 * System.out.println("Jamath filter executed: " + user);
					 * 
					 * }
					 */
					
					boolean isMale = user.isMale();
					String userGender = isMale ? "male" : "female";
					boolean genderFilterPassed = Arrays.asList(genders).contains("all") || Arrays.asList(genders).contains(userGender);

					boolean jamathFilterPassed = false;

					// Check if jamathFilterUserList is not null and contains the user
					if (jamathFilterUserList != null) {
					    jamathFilterPassed = jamathFilterUserList.stream()
					            .anyMatch(muser -> muser.getUserId() == user.getUserId());
					} else if ("Others".equals(jamadh)) {
					    List<String> explicitlyListedJamaths = Arrays.asList("Thowheed Jamath", "Sunnathwal Jamath", "TNTJ");
					    jamathFilterPassed = matriAllUsers.stream()
					            .anyMatch(muser -> !explicitlyListedJamaths.contains(muser.getJamath()) &&
					                              muser.getUserId() == user.getUserId());
					} else if ("All".equals(jamadh)) {
					    // If jamadh is "All", all users pass the jamath filter
					    jamathFilterPassed = true;
					} 
					
					// Combine gender and jamath filter logic
					if (genderFilterPassed && jamathFilterPassed) {
					    filteredUsers.add(user);
					    System.out.println("Gender and Jamath filter executed: " + user);
					} else if (genderFilterPassed) {
					    filteredUsers.add(user);
					    System.out.println("Gender filter executed: " + user);
					} else if (jamathFilterPassed) {
					    filteredUsers.add(user);
					    System.out.println("Jamath filter executed: " + user);
					}

					// Issuses
					/*
					 * 1) jamath or gender any one Alredy selected data dislayed 2) next selected
					 * any one return loop to diplay data 3) lats one every thime loop data tp
					 * display
					 */

					if (profileid != 0 && user.getUserId() == profileid) {
						filteredUsers.add(user);
						System.out.println("Filter profile id");

					}

				}

				JSONArray usersArray = JSONFactoryUtil.createJSONArray();
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

				for (User user : filteredUsers) {
					long userId = user.getUserId();
					if (!excludedProfileIds.contains(userId)) {
						JSONObject userJson = JSONFactoryUtil.createJSONObject();
						userJson.put("userId", user.getUserId());
						userJson.put("portraitURL", user.getPortraitURL(themeDisplay));
						userJson.put("fullName", user.getFullName());
						userJson.put("jobTitle", user.getJobTitle());
						userJson.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(user.getCreateDate()));

						for (MatriUser matriUser : matriAllUsers) {
							if (matriUser.getUserId() == userId) {
								userJson.put("Jamath", matriUser.getJamath());
								break;
							}
						}
						PortletURL informationRenderURL = PortletURLFactoryUtil.create(resourceRequest,
								themeDisplay.getPpid(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
						informationRenderURL.setParameter("jspPage", "/Matri/ProfileDetails.jsp");
						informationRenderURL.setParameter("userId", String.valueOf(user.getUserId()));

						userJson.put("informationRenderURL", informationRenderURL.toString());
						usersArray.put(userJson);
					}
				}

				JSONObject responseObject = JSONFactoryUtil.createJSONObject();
				responseObject.put("currentProfiles", usersArray);

				PrintWriter out = resourceResponse.getWriter();
				out.print(responseObject.toString());
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	@Reference
	private MatriUserLocalService _matriUserLocalService;

	/*
	 *
	 * public static String ObjectToString(Object object) { if (object != null) {
	 * return String.valueOf(object); } return ""; }
	 */

	private static final Log logger = LogFactoryUtil.getLog(UmmatProfilesWebPortlet.class);

}