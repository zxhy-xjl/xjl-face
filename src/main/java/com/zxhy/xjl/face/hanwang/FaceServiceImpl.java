package com.zxhy.xjl.face.hanwang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.zxhy.xjl.face.FaceService;
import com.ztesoft.demo.HwResult;
import com.ztesoft.demo.NewCertificationin;
import com.ztesoft.utils.Utils;


/**
 * 汉王人脸识别
 * 
 * @author leasonlive
 *
 */
@Service
public class FaceServiceImpl implements FaceService {
	private static Log log = LogFactory.getLog(FaceServiceImpl.class);
	private String faceUploadURL;
	private String faceRecognizeURL;
	
	public String getFaceUploadURL() {
		return faceUploadURL;
	}

	public void setFaceUploadURL(String faceUploadURL) {
		this.faceUploadURL = faceUploadURL;
	}

	public String getFaceRecognizeURL() {
		return faceRecognizeURL;
	}

	public void setFaceRecognizeURL(String faceRecognizeURL) {
		this.faceRecognizeURL = faceRecognizeURL;
	}

	public boolean addFacePhoto(String idCode, PhotoType photoType, byte[] photo) {
		log.debug("idCode:" + idCode);
		log.debug("photoType:" + photoType);
		log.debug("photoSize:" + photo.length);
		String str = Utils.ToBase64(photo);
		NewCertificationin certin = new NewCertificationin();
		certin.setCardId(idCode);// 身份证号码
		certin.setClientType("1");// 上传照片的客户端类型 ：电脑端和手机端一个是0一个是1
		certin.setImg(str);// 上传的照片的
		// 1=实时采集照片，idPhoto=2身份证照片，3=普通照片
		if(photoType==FaceService.PhotoType.idPhoto){
			certin.setPhotoType("2");
		}
		if(photoType==FaceService.PhotoType.capturePhoto2){ 
			certin.setPhotoType("1");
		}
		if(photoType==FaceService.PhotoType.uploadPhoto){
			certin.setPhotoType("3");
		}
		HwResult hw = null;
		certin.setInterfacetype(NewCertificationin.INTERFACE_UPLOAD);
		hw = com.ztesoft.facefunction.FaceCert.faceCert(certin,this.faceUploadURL);
		if (hw != null) {
			if ("true".equals(hw.getSuccess()) && "照片上传成功！".equals(hw.getMessage()) && "0".equals(hw.getCode())) {
				log.debug("照片上传至汉王服务器成功 ");
				return true;
			} else {
				log.debug("照片上传至汉王服务器失败");
				return false;
			}
		} else {
			log.debug("照片上传至汉王服务器失败");
			return false;
		}
	}

	public boolean checkFace(String idCode, PhotoType photoType, byte[] photo) {
		NewCertificationin certin = new NewCertificationin();
		certin.setCardId(idCode);
		certin.setClientType("1");
		certin.setImg(Utils.ToBase64(photo));
		if (photoType == FaceService.PhotoType.idPhoto) {
			certin.setPhotoType("2");
		}
		if (photoType == FaceService.PhotoType.capturePhoto2) {
			certin.setPhotoType("1");
		}
		if (photoType == FaceService.PhotoType.uploadPhoto) {
			certin.setPhotoType("3");
		}

		HwResult hw = null;
		certin.setInterfacetype(NewCertificationin.INTERFACE_UPLOAD);
		hw = com.ztesoft.facefunction.FaceCert.faceCert(certin,
				this.faceRecognizeURL);
		if (hw != null) {
			String recPass = hw.getVerify();
			if ("true".equals(recPass)) {
				log.debug("汉王照片比对成功");
				return true;
			} else {
				log.debug("汉王照片比对失败");
				return false;
			}
		} else {
			log.debug("汉王服务器返回空值，比对失败");
			return false;
		}
	}

	public boolean checkFace(String idCode, byte[] photo) {
		NewCertificationin certin = new NewCertificationin();
		certin.setCardId(idCode);
		certin.setClientType("1");
		certin.setImg(Utils.ToBase64(photo));
		HwResult hw = null;
		certin.setInterfacetype(NewCertificationin.INTERFACE_UPLOAD);
		hw = com.ztesoft.facefunction.FaceCert.faceCert(certin,
			this.faceRecognizeURL);
		if (hw != null) {
			String recPass = hw.getVerify();
			if ("true".equals(recPass)) {
				log.debug("汉王照片比对成功");
				return true;
			} else {
				log.debug("汉王照片比对失败");
				return false;
			}
		} else {
			log.debug("汉王服务器返回空值，比对失败");
			return false;
		}
		
		
	}
	public byte[] getPhoto(String idCode, PhotoType photoType) {
	
		return null;
	}


}
