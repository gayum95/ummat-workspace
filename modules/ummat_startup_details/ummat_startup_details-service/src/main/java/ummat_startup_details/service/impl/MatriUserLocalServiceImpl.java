/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ummat_startup_details.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

import ummat_startup_details.model.MatriUser;
import ummat_startup_details.service.base.MatriUserLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ummat_startup_details.model.MatriUser",
	service = AopService.class
)
public class MatriUserLocalServiceImpl extends MatriUserLocalServiceBaseImpl {

	@Override
	public Map<String, Integer> getUsersByJamath() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MatriUser> getMatriUserByJamath(String jamath) {
        List<MatriUser> matriUsers = matriUserPersistence.findAll();
        return matriUsers.stream()
                .filter(matriUser -> matriUser.getJamath().equals(jamath))
                .collect(Collectors.toList());
    }
	
	
	 public List<MatriUser> findByDistrict(long districtId) {
	        return matriUserPersistence.findByfindByDistrict(districtId);
	    }

	    public List<MatriUser> findByArea(String area) {
	        return matriUserPersistence.findByfindByArea(area);
	    }

	    public List<MatriUser> findByDistricAndAreat(long districtId, String area) {
	        return matriUserPersistence.findByfindByDistricAndAreat(districtId, area);
	    }
}