package com.iu.b1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.b1.member.MemberFilesVO;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("file down");
		
		//controller에서 model에 path라는 이름으로 "upload"를 넣어놓았음
		String filePath = (String)model.get("path");
		
		//controller에서 model에 memberFiles라는 이름으로 
		//파라미터 fnum으로 찾은 memberFilesVO값을 넣어놓았음
		MemberFilesVO memberFilesVO = (MemberFilesVO)model.get("memberFiles");
		
		//filepath에 현재 upload값만 들어있으므로, /static/upload로 다시 경로를 만들어줌.
		filePath = "/static/"+filePath;
		ClassPathResource classPathResource = new ClassPathResource(filePath);
		
		
		//filepath를 설정할때, 각각 경로를 다르게 입력해준다.
		//1. ClassPathResource : "/static/"
		//2. resourceLoader : "classpath:/static/"
		
		
		//File객체에  파일이 들어있는 폴더위치와 그 파일의 이름을 넣어준다.
		File file = new File(classPathResource.getFile(), memberFilesVO.getFname());
		
		//한글처리 
		response.setCharacterEncoding("UTF-8");
		
		//파일크기 설정
		response.setContentLengthLong(file.length());
		
		//다운로드시 파일이름을 인코딩
		String filename = URLEncoder.encode(memberFilesVO.getOname(), "UTF-8");
		
		//header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일 읽어오는 stream : FileInputStream
		FileInputStream fi = new FileInputStream(file);
		
		//파일 출력하는 stream : OutputStream
		OutputStream os = response.getOutputStream();
		
		//파일출력
		FileCopyUtils.copy(fi,os);

		//끝
		os.close();
		fi.close();
		
	}
	
	
}
