package com.iu.b1.util;

import java.io.File;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {

	@Autowired
	private ServletContext serveltContext;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	
	public File getUseResourceLoader(String filePath) throws Exception {
		String path = "classpath:/static/";
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		//					 classes:static 						   , 내가 그아래에 만들 폴더명
		
		System.out.println(file.getAbsolutePath());

		//ResourceLoader 
		//classpath 경로를 받아오기 위해 사용
		//생성하려는 폴더가 없으면 에러발생
		//static경로는 이미 찾을 수 있으므로 static경로를 이용해서 File객체를 생성하고
		//하위폴더를 Child를 사용해서 폴더 생성
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
	

	
	public File useServletContext(String filePath) {
		String files = serveltContext.getRealPath(filePath);
		System.out.println(files);
		
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
	
	
	
	public File getUseClassPathResource(String filePath) throws Exception {
		//classpath 경로를 받아오기 위해 사용
		//resourceLoader와 달리 시작경로의 classpath 구문은 생략
		//나머지는 resourceLoader와 같다.
		String path = "static/";
		ClassPathResource classPathResource = new ClassPathResource(path);
		//static에서 classpath를 가져오겠다 
		
		File file = new File(classPathResource.getFile(), filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		System.out.println(file.getAbsolutePath());
		
		return file;
	}
	
	
}
