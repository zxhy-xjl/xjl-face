package com.zxhy.xjl.face;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext-face.xml"})
public class FaceServiceTest {
	@Autowired
	private FaceService faceService;
	@Test
	public void addFacePhoto() throws IOException{
		byte[] photo = FileUtils.readFileToByteArray(FileUtils.toFile(FaceServiceTest.class.getResource("/data/idPhoto.png")));
		this.faceService.addFacePhoto("3201", FaceService.PhotoType.idPhoto, photo);
	}
}
