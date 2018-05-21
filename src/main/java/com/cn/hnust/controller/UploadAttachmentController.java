package com.cn.hnust.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.util.JsonResult;
import com.cn.hnust.util.OperationFileUtil;
import com.cn.hnust.util.UploadAndDownloadPathUtil;
import com.mysql.fabric.xmlrpc.base.Array;

@RequestMapping("/upload")
@Controller
public class UploadAttachmentController {

	@RequestMapping("/uploadProductPicAndChangeName.do")
	@ResponseBody
	public JsonResult uploadProductPicAndChangeName(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, String> compressNameMap = null;
		
		JsonResult jsonResult = new JsonResult();
		String fileName = "";
        List<String> result = new ArrayList<String>();
		
		String projectNo = request.getParameter("projectNo");

		try {

			String drawingName = request.getParameter("fileName");

			String path = UploadAndDownloadPathUtil.getProjectImg()
					+ File.separator + projectNo + File.separator + "1"+File.separator;
			
			String compressPath = path + "compressImg" + File.separator;

			File file = new File(path);
			File compressImg = new File(compressPath);
			if (!file.exists() && !file.isDirectory()) {
				file.mkdirs();
			}
			if (!compressImg.exists() && !compressImg.isDirectory()) {
				compressImg.mkdirs();
			}

			Map<String, Map<String, String>> multiFileUpload = OperationFileUtil
					.multiFileUpload2(request, path, compressPath, null);

			String compressName = "";
			if (multiFileUpload != null && multiFileUpload.size() > 0) {
				compressNameMap = multiFileUpload.get("compressFilePaths");
				boolean isWindow = System.getProperty("os.name").startsWith(
						"Windows");

				if (compressNameMap != null) {
					if (isWindow) {

						for (Map.Entry<String, String> pic : compressNameMap
								.entrySet()) {
							String compressfileName = "";
							compressfileName = (UploadAndDownloadPathUtil
									.getProjectStatic() + pic.getValue()
									.substring(
											UploadAndDownloadPathUtil
													.getProjectImg().length()))
									.replaceAll("\\\\", "/");
						
							result.add(compressfileName);

						}
					} else {

						for (Map.Entry<String, String> pic : compressNameMap
								.entrySet()) {
							String compressfileName = "";
							compressfileName = (UploadAndDownloadPathUtil
									.getProjectStatic() + pic.getValue().substring(
									UploadAndDownloadPathUtil.getProjectImg()
											.length()));
							result.add(compressfileName);

						}

					}
					jsonResult.setData(result);
					jsonResult.setOk(true);

				}

			}
		} catch (Exception e) {

			e.printStackTrace();
			jsonResult.setOk(false);
			jsonResult.setMessage(e.getMessage());

		}

		return jsonResult;

	}
	
	
	
	

}
