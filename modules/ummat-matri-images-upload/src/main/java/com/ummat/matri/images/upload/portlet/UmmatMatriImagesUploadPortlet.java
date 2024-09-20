package com.ummat.matri.images.upload.portlet;

import com.ummat.matri.images.upload.constants.UmmatMatriImagesUploadPortletKeys;
import com.ummat.slayer.model.MatriImages;
import com.ummat.slayer.service.MatriImagesLocalService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.util.DLURLHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gayathri
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=MATRI",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UmmatMatriImagesUpload",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UmmatMatriImagesUploadPortletKeys.UMMATMATRIIMAGESUPLOAD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UmmatMatriImagesUploadPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest request, RenderResponse response){
		
		log.info("Executing doview Method");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map<String, String> imageAndIdMap = new HashMap<>();
		
		try{
			List<MatriImages> matriImages = _matriImagesService.getImagesByUserId(themeDisplay.getUserId());
			for(MatriImages matriImage: matriImages) {
				FileEntry fileEntry = _dlAppService.getFileEntry(matriImage.getDlEntryId());
				imageAndIdMap.put(UmmatMatriImagesUploadPortletKeys.RENDER_IMAGE_MAP_KEY+matriImages.indexOf(matriImage),
						_dlURLHelper.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, StringPool.BLANK)
						+UmmatMatriImagesUploadPortletKeys.VALUES_DIVIDER+matriImage.getDlEntryId());
			}
		}catch(Exception e){
			log.error("Exception Occured "+e.getLocalizedMessage());
		}
		
		request.setAttribute("images", imageAndIdMap);
		
		try {
			super.doView(request, response);
		} catch (IOException | PortletException e) {
			log.error("Exception Occured "+e.getLocalizedMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	public void uploadImages(ActionRequest request, ActionResponse response) {
		
		log.info("Executing UploadImages...");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request); 
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		int count = ParamUtil.getInteger(request, "count");
		Folder folder = null;
		
		try {
			folder = _dlAppService.getFolder(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, 
					UmmatMatriImagesUploadPortletKeys.IMAGE_FOLDER_NAME);
		} catch (PortalException e) {
			log.error("Exception Occured "+e.getLocalizedMessage());
		}
		
		if(Validator.isNotNull(folder)) {
			for(int i=0;i<count;i++) {
				
				File image = uploadPortletRequest.getFile("image"+i);
				long fileEntryId = ParamUtil.getLong(request, "dlFileEntry"+i);
				if(Validator.isNotNull(image)) {
					String title = uploadPortletRequest.getFileName("image"+i);
					String mimeType = uploadPortletRequest.getContentType("image"+i);
					
					if(fileEntryId > 0) {
						
						try {
							_dlAppService.updateFileEntry(themeDisplay.getUserId(), fileEntryId, title, mimeType, title, 
									null, UmmatMatriImagesUploadPortletKeys.FILE_UPLOAD_DESCRIPTION, StringPool.BLANK,
									null, image, null, null, serviceContext);
						} catch (PortalException e) {
							log.error("Exception Occured "+e.getLocalizedMessage());
						}
						
					}else {
						try {
							FileEntry fileEntry = _dlAppService.addFileEntry(themeDisplay.getUserId(), 
									themeDisplay.getScopeGroupId(), folder.getFolderId(),
									title, mimeType, title, UmmatMatriImagesUploadPortletKeys.FILE_UPLOAD_DESCRIPTION, 
									StringPool.BLANK, image, serviceContext);
							
							_matriImagesService.addMatriImages(themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), 
									themeDisplay.getUserId(),themeDisplay.getUser().getFullName(), fileEntry.getFileEntryId());
							
						} catch (PortalException e) {
							log.error("Exception Occured "+e.getLocalizedMessage());
						}
					}
				}
				
			}
		}
		
	}
	
	@Reference
	private DLAppLocalService _dlAppService;
	
	@Reference
	private MatriImagesLocalService _matriImagesService;
	
	@Reference
	private DLURLHelper _dlURLHelper;
	
	private static final Log log = LogFactoryUtil.getLog(UmmatMatriImagesUploadPortlet.class);
}