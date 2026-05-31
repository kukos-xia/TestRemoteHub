public interface CategoryService extends IService<Category> {


    /**
     * 家具
     * // ssssssssssss
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadCategory (Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);

  
}