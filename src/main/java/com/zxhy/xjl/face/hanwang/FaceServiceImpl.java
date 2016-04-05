package com.zxhy.xjl.face.hanwang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zxhy.xjl.face.FaceService;
import com.zxhy.xjl.face.FaceService.PhotoType;
/**
 * 汉王人脸识别
 * @author leasonlive
 *
 */
@Service
public class FaceServiceImpl implements FaceService {
	private static Log log = LogFactory.getLog(FaceServiceImpl.class);
	public void addFacePhoto(String idCode, PhotoType photoType, byte[] photo) {
		log.debug("idCode:" + idCode);
		log.debug("photoType:" + photoType);
		log.debug("photoSize:" + photo.length);
	}

	public boolean checkFace(String idCode, PhotoType photoType, byte[] photo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkFace(String idCode, byte[] photo) {
		// TODO Auto-generated method stub
		return false;
	}
	public byte[] getPhoto(String idCode, PhotoType photoType) {
		// TODO Auto-generated method stub
		return null;
	}

}
