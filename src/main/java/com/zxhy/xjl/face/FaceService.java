package com.zxhy.xjl.face;
/**
 * 人脸识别服务
 * @author leasonlive
 *
 */
public interface FaceService {
	/**
	 * 照片类型包含三种
	 * idPhoto代表身份证上面的照片
	 * capturePhoto代表实时抓拍的照片
	 * uploadPhoto代表通过文件上传上来的照片
	 * @author leasonlive
	 *
	 */
	 enum PhotoType {
		 idPhoto, capturePhoto2,uploadPhoto};
	 /**
	  * 上传人脸照片到人脸库中 
	  * @param idCode 身份证号码
	  * @param photoType 照片类型
	  * @param photo 照片
	  */
	public boolean addFacePhoto(String idCode, PhotoType photoType, byte[] photo);
	/**
	 * 核对人脸照片
	 * @param idCode 身份证号码
	 * @param photoType 指定使用人脸库中那种照片进行比对
	 * @param photo 需要比对的照片
	 */
	public boolean checkFace(String idCode, PhotoType photoType, byte[] photo);
	/**
	 * 核对人脸照片
	 * 先使用人脸库中的抓拍照片进行比对，然后是身份证照片比对，最后是上传照片比对，只要有一个能比较成功则返回成功
	 * @param idCode 身份证号码
	 * @param photo 照片
	 */
	public boolean checkFace(String idCode, byte[] photo);
	/**
	 * 从人脸库中获取一张照片
	 * @param idCode 身份证号码
	 * @param photoType 照片类型
	 * @return
	 */
	public byte[] getPhoto(String idCode, PhotoType photoType);
}
