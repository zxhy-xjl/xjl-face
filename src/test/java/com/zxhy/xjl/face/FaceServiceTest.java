package com.zxhy.xjl.face;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
* @author  yangzaixiong
* 创建时间             2016年4月8日下午5:20:50
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext-face.xml"})
public class FaceServiceTest {
	@Autowired
	private FaceService faceService;
	@Test
	public void addFacePhoto() throws IOException{
	     byte[] photo=null; 
	    
	      //{"message":"发生错误：人脸定位失败，请检查图片中人脸是否清晰、明亮、端正！","code":-9,"success":false}
	     photo= FileUtils.readFileToByteArray(FileUtils.toFile(FaceServiceTest.class.getResource("/data/uploadPhoto.png")));
		 Assert.assertFalse(this.faceService.addFacePhoto("640102196708120329", FaceService.PhotoType.uploadPhoto, photo));
		
		 photo = FileUtils.readFileToByteArray(FileUtils.toFile(FaceServiceTest.class.getResource("/data/idPhoto.png")));
		 Assert.assertTrue(this.faceService.addFacePhoto("640102196708120329", FaceService.PhotoType.idPhoto, photo));
		
		 photo = FileUtils.readFileToByteArray(FileUtils.toFile(FaceServiceTest.class.getResource("/data/capturePhoto.png")));
		 Assert.assertTrue(this.faceService.addFacePhoto("640102196708120329", FaceService.PhotoType.capturePhoto2, photo));
		}
	
	
	
	
}
